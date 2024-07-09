console.log("ok I am here");
const viewContactModal = document.getElementById('view_contact_modal');
const baseURL = "http://localhost:8081"

// options with default values
const options = {
    placement: 'bottom-right',
    backdrop: 'dynamic',
    backdropClasses: 'bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40',
    closable: true,
    onHide: () => {
        console.log('modal is hidden');
    },
    onShow: () => {
        console.log('modal is shown');
    },
    onToggle: () => {
        console.log('modal has been toggled');
    },
};

// instance options object
const instanceOptions = {
    id: 'view_contact_modal',
    override: true
};

const contactModal = new Modal(viewContactModal, options, instanceOptions);

function openContactModal() {
    contactModal.show();
}

function closeContactModal() {
    contactModal.hide();
}

async function loadContactData(id) {
    console.log(id)
    try {
        const data = await (await fetch(`${baseURL}/api/contacts/${id}`)).json();
        console.log(data);

        document.querySelector('#contact_profile_picture').src = data.picture;
        document.querySelector('#contact_name').innerHTML = data.name;
        document.querySelector('#contact_email').innerHTML = data.email;
        document.querySelector('#contact_phone').innerHTML = data.phoneNumber;

        document.querySelector('#description').innerHTML = data.description;
        document.querySelector('#contact_address').innerHTML = data.address;
        document.querySelector('#favorite').innerHTML = data.favorite ? 'Yes' : 'No';
        document.querySelector('#linkedin').innerHTML = data.linkedInLink ? `<a href="${data.linkedInLink}" target="_blank">${data.linkedInLink}</a>` : 'N/A';
        document.querySelector('#website').innerHTML = data.websiteLink ? `<a href="${data.websiteLink}" target="_blank">${data.websiteLink}</a>` : 'N/A';

        openContactModal();
    } catch (error) {
        console.log("Error: ", error);
    }


}


async function deleteContact(id){
    Swal.fire({
        title: "Do you want to detlete the contact?",
       icon : "warning",
        showCancelButton: true,
        confirmButtonText: "Delete",
        
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            const url = `${baseURL}/user/contacts/delete/`+id;
            window.location.replace(url);
          
        } 
      });
}
