;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	talkWindow 0
)

(instance talkWindow of Script
	(properties)

	(method (doit)
		(if (not (& $1000 (gEgo onControl:)))
			(client setScript: 0)
			(DisposeScript 226)
		)
	)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 loop: 3)
				(cond
					((< global100 11)
						(Print 226 0) ; "The boy at the the window says, "Yes sir, what can I do for you?""
					)
					((== global100 11)
						(Print 226 1) ; "The man at the window says, "Yes sir, what can I do for you?""
					)
					(else
						(Print 226 2) ; "The motel manager is fuming when he says... "You dudes aren't gonna get away with this! You're gonna pay for that damage!!""
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'look/pane,man,boy')
				(if (< global100 11)
					(Print 226 3) ; "You see a small boy inside. Probably the manager's son."
				else
					(Print 226 4) ; "You see a man inside. You assume he is the manager."
				)
			)
			((Said 'give/cash')
				(if (< global100 11)
					(Print 226 5) ; "The boy says, "I don't think I should take your money.""
				else
					(Print 226 6) ; "The man says, "I don't need your money, buster.""
				)
			)
			((Said 'talk/man,boy')
				(cond
					((< global100 11)
						(Print 226 7) ; "Hello sir. My dad's not here right now, but maybe I can help you."
					)
					((== global100 12)
						(Print 226 8) ; "You guys did a bang-up job of ruining my day!" the manager says. "Now how about getting lost?"
					)
					(else
						(Print 226 9) ; "Yes sir, what can I do for you?"
					)
				)
			)
			((Said 'show/badge,badge')
				(if (gEgo has: 7) ; wallet
					(Print 226 10) ; "Yes, Officer, how can I help you?"
					(= global175 1)
				else
					(proc0_9) ; "You don't have it."
				)
			)
			((Said 'rent/chamber')
				(if (== global100 12)
					(Print 226 11) ; "GET SERIOUS, MAC!" says the manager... "After the mess you made, you guys ain't rentin' nothing!"
				else
					(Print 226 12) ; "I'm sorry, sir" he says, "but we don't have any vacancies."
				)
			)
			((Said 'show/japaneseshot,(shot<japaneseface),mugshot')
				(cond
					((< global100 11)
						(Print 226 13) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((gEgo has: 12) ; new_mug_shot
						(Print 226 14 #icon 112) ; "Well," the manager says, "the photograph is vaguely familiar... I believe his name was William Cole. He has room 108."
						(if global112
							(Print 226 15) ; "Ah ha!" you think to yourself, "Bains is using the name `Cole'."
						)
						(if (not (IsFlag 88))
							(SetFlag 1)
							(SetFlag 2)
							(SetScore 3 88)
						)
					)
					((gEgo has: 23) ; old_mug_shot
						(Print 226 16 #icon 123) ; "Well," the manager says, "I don't remember seeing him."
					)
					(else
						(proc0_9) ; "You don't have it."
					)
				)
			)
			((Said 'look,get,give,show,ask/list,customer,register')
				(cond
					((< global100 11)
						(Print 226 13) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((not global175)
						(Print 226 17) ; "The manager says, "Who do you think you are? My customers expect a little privacy when they stay here.""
					)
					(else
						(Print 226 18) ; "The manager says, "Who are you looking for?""
					)
				)
			)
			((or (Said '[ask]/bains') (Said '[ask]/man,boy/bains'))
				(if (< global100 11)
					(Print 226 19) ; "The boy says, "I don't know.""
				else
					(Print 226 20) ; "Scanning his guest book, he shakes his head and says... "I'm sorry. I don't have anyone listed by that name.""
				)
			)
			(
				(or
					(Said '[ask,get]/cole,chamber')
					(Said '[ask,get]/man,boy/bains')
				)
				(if (< global100 11)
					(Print 226 19) ; "The boy says, "I don't know.""
				else
					(= global178 1)
					(Print 226 21) ; "Scanning his guest book, he nods his head and says... "Yes, here we are: William Cole...Room 108.""
					(if (not (IsFlag 88))
						(SetFlag 1)
						(SetFlag 2)
						(SetScore 3 88)
					)
				)
			)
			((Said 'show/warrant[<frisk]')
				(cond
					((< global100 11)
						(Print 226 13) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((IsFlag 13)
						(Print 226 22) ; "You show the search warrant to the manager, and he says... "Ok, now what?""
						(= global174 1)
					)
					(else
						(proc0_9) ; "You don't have it."
					)
				)
			)
			((or (Said 'replace/key') (Said 'give/key/manager,boy'))
				(if (gEgo has: 27) ; motel_key
					(Print 226 23) ; "OK"
					(PutItem 27) ; motel_key
				else
					(Print 226 24) ; "You don't have the key to any room here."
				)
			)
			((Said '[ask,get]/key')
				(cond
					((gEgo has: 27) ; motel_key
						(Print 226 25) ; "You already have it."
					)
					((< global100 11)
						(Print 226 13) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((not global175)
						(Print 226 26) ; "You ask the manager for the key, and he answers... "Get serious, Mac! You rent a room...you get a key. Unfortunately for you," he says, "we don't have a vacancy.""
					)
					((not global174)
						(Print 226 27) ; "I don't care if you're the Queen of England!" he blurts out. "I have an obligation to my customers, and I know the law and there ain't nobody gettin' any key!"
					)
					((not global178)
						(Print 226 28) ; "The manager sounds like he'd really like to help as he says, "I don't know what room key you want! Besides, I've got paying customers in all of my rooms.""
					)
					(else
						(Print 226 29) ; ""Anything you say, Officer," the manager says, as he gives you the key to Room 108."
						(gEgo get: 27) ; motel_key
						(SetScore 3 162)
					)
				)
			)
			((Said 'arrest/man,boy')
				(Print 226 30) ; "You could, but it wouldn't get you anywhere."
			)
		)
	)
)

