;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm23 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
)

(procedure (localproc_0)
	(Print &rest #at -1 125)
)

(procedure (localproc_1)
	(= local9 1)
	(gCurRoom drawPic: 90 3)
	(switch local15
		(0
			(mugShot1 posn: 52 62)
			(paperClip posn: 31 28)
			(if (== ((gInventory at: 12) owner:) 23) ; new_mug_shot
				(removeableMugShot posn: 57 66)
			)
			(Animate (gCast elements:) 0)
			(Display 23 0 dsCOORD 120 15 dsWIDTH 200 dsFONT 0) ; "CASE#:M10251983. Name:Bains, Jessie Hiram. ALIAS:Sloan, Frank nmn."
			(Display 23 1 dsCOORD 20 72 dsWIDTH 300) ; "SCARS/TATTOOS: Abdominal scars caused by bullets. DOB: 11/30/51. PHYS: wht/male, 5'8", blk, brn, 150. ASSIGNED TO: Hamilton A/O: Sonny Bonds ARREST RECORD:  Count #1 - MURDER.   VICTIM - Taselli, Jason  Count #2 - ATTEMPT MURDER   VICTIM - Bonds, Sonny              (1)"
		)
		(1
			(mugShot2 posn: 69 62)
			(Animate (gCast elements:) 0)
			(Display 23 2 dsCOORD 120 15 dsWIDTH 200 dsFONT 0) ; "LYTTON CORRECTIONAL DEPT.   PERSONNEL FILE Name: Pate, Luis D. ALIAS: none. DOB: 2/28/66. PHYS: wht/male, 5'11", blk, brn, 165."
			(Display 23 3 dsCOORD 20 65 dsWIDTH 300) ; "ID# : 2204. DEPT: Booking. POS : Correc. Off. EMPL: 12/23/87. STAT: Probation. DEPARTMENTAL ACTIONS: None                        (1)"
		)
	)
	(= local10 0)
	(User canInput: 1)
)

(procedure (localproc_2)
	(= local9 0)
	(= local10 1)
	(gCurRoom drawPic: 90 2)
	(switch local15
		(0
			(mugShot1 posn: 0 0)
			(paperClip posn: 0 0)
			(if (== ((gInventory at: 12) owner:) 23) ; new_mug_shot
				(removeableMugShot posn: 0 0)
			)
			(Animate (gCast elements:) 0)
			(Display 23 4 dsCOORD 20 7 dsWIDTH 300 117) ; "SUMMARY:   After a lengthy investigation, Officer Sonny Bonds successfully infiltrated the illegal gambling operation at the Hotel Delphoria. A confrontation with Bains ended in a shoot-out and his subsequent arrest. Suspect was convicted of first degree murder. Further: testimony provided by Woody Roberts, Marie Wilkans, and Don Colby was instrumental in convicting subject Bains on additional counts of narcotics trafficking and illegal gambling activities.   CONVICTED: 10/25/1983.  INCARCERATED: State Pen.  LOCATION: Foolsum.  SENTENCE: 97 years.  PAROLE DATE: None.  CASE STATUS: Closed END FILE:              (2)", p_draw
		)
		(1
			(mugShot2 posn: 0 0)
			(Animate (gCast elements:) 0)
			(Display 23 5 dsCOORD 20 10 dsWIDTH 300 117) ; "EQUIPMENT ISSUED: #1. Mace. #2. PR/24. #3. Handcuffs. REGISTERED WEAPONS Hand gun:# S/W 5557763      4" Smith & Wesson .38 cal K-38. END FILE:                         (2)", p_draw
		)
	)
)

(instance mugShot1 of View
	(properties)
)

(instance mugShot2 of View
	(properties)
)

(instance removeableMugShot of View
	(properties)
)

(instance paperClip of View
	(properties)
)

(instance jailer of Act
	(properties)
)

(instance witness of Act
	(properties)
)

(instance witnessTalking of Sound
	(properties
		number 12
	)
)

(instance rm23 of Rm
	(properties
		picture 23
		style 0
	)

	(method (dispose)
		(rm23Script dispose:)
		(jailerScript dispose:)
		(witnessScript dispose:)
		(folderScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(if (>= global100 2)
			(= local0 1)
		)
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 1)
		(Load rsVIEW 87)
		(Load rsVIEW 50)
		(Load rsVIEW 204)
		(= local8 1)
		(= global212 3)
		(mugShot1 view: 204 loop: 2 cel: 2 posn: 0 0 init:)
		(removeableMugShot view: 204 loop: 2 cel: 2 posn: 0 0 setPri: 12 init:)
		(mugShot2 view: 204 loop: 2 cel: 1 posn: 0 0 init:)
		(paperClip view: 204 loop: 2 cel: 3 posn: 0 0 setPri: 14 init:)
		(witness
			view: 87
			illegalBits: 0
			posn: 69 112
			loop: 0
			cel: 0
			setPri: 6
			setCycle: Walk
			init:
			stopUpd:
			setScript: witnessScript
		)
		(jailer
			view: 50
			posn: 275 129
			loop: 1
			cel: 0
			setPri: 6
			illegalBits: 0
			init:
			setScript: jailerScript
		)
		(self setLocales: 153)
		(self setScript: rm23Script)
	)
)

(instance rm23Script of Script
	(properties)

	(method (doit)
		(cond
			((> (gEgo y:) 160)
				(if (== ((gInventory at: 10) owner:) 23) ; field_kit
					(gEgo get: 10) ; field_kit
					(localproc_0 23 6) ; "You grab your field kit on the way out."
				)
				(if (== ((gInventory at: 0) owner:) 23) ; hand_gun
					(gEgo get: 0) ; hand_gun
					(if (> global107 5)
						(-= global107 5)
						(localproc_0 23 7) ; "As you leave the jail, you pick up your weapon from the jailer and toss him $5.00 for the "coffee fund"."
					else
						(localproc_0 23 8) ; "You check your money clip and say..."
						(localproc_0 23 9) ; "Oh no! I don't even have the $5.00 for the coffee fund!"
						(localproc_0 23 10) ; "The jailer says, "I'll let it go this time, Bonds, but use your head next time.""
					)
				)
				(if (== global100 1)
					(= global158 0)
					(= global159 0)
					(= global100 2)
				)
				(gCurRoom newRoom: 22)
			)
			((and (< (gEgo x:) 200) local1 (not local2))
				(witnessScript changeState: 1)
			)
			((and (> (gEgo x:) 210) local4)
				(witnessScript changeState: 6)
			)
			((and local8 (< (gEgo x:) 210))
				(= local8 0)
				(jailerScript changeState: 4)
			)
			((and (> (gEgo x:) 210) local7 (not local8))
				(= local8 1)
				(jailerScript changeState: 6)
			)
		)
		(= local5
			(and (gEgo inRect: 122 121 163 136) (!= (gEgo loop:) 2))
		)
		(cond
			((> local16 1)
				(-- local16)
			)
			((== local16 1)
				(= local16 0)
				(jailerScript cue:)
			)
			((> local17 0)
				(-- local17)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local11
					(gEgo
						view: 1
						setStep: 3 2
						setLoop: -1
						posn: 239 130
						init:
					)
					(jailerScript changeState: 10)
				else
					(gEgo
						view: 1
						setStep: 3 2
						setLoop: -1
						posn: 239 150
						init:
						setMotion: MoveTo 239 130
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(local12
						(cond
							((Said 'get/shot,mugshot,painting')
								(if (== local15 0)
									(if (== ((gInventory at: 12) owner:) 23) ; new_mug_shot
										(removeableMugShot dispose:)
										(gEgo get: 12) ; new_mug_shot
										(SetScore 2)
									else
										(localproc_0 23 11) ; "You already have that particular photograph."
									)
								else
									(localproc_0 23 12) ; "There are no mug shots in here. There's only the ID photo of the rookie jailer, and you can't take it."
								)
							)
							(
								(Said
									'[look,see,read,turn,go]/end,next,2,(page[<next,second])'
								)
								(if local9
									(localproc_2)
								else
									(localproc_0 23 13) ; "This is the end of the file!"
								)
							)
							((Said 'look/shot,mugshot,painting')
								(if local9
									(localproc_0 23 14) ; "There it is!"
								else
									(localproc_1)
								)
							)
							(
								(Said
									'[look,see,read,turn,go]/back,preceding,1,(page<(preceding,first))'
								)
								(if local10
									(localproc_1)
								else
									(localproc_0 23 15) ; "This is the beginning of the file!"
								)
							)
							(
								(or
									(Said
										'[turn,go,look]/(page<next,third),(3<page)'
									)
									(Said
										'read,look,see,turn/(page[<third]),(3<page)'
									)
								)
								(Print 23 16 #at -1 150) ; "There is no third page in this file."
							)
							(
								(or
									(Said 'exit,close,replace[/file,file]')
									(Said 'drop,give[<back]/file,file')
								)
								(if (== local15 0)
									(mugShot1 posn: 0 0)
									(paperClip posn: 0 0)
									(if (not (gEgo has: 12)) ; new_mug_shot
										(removeableMugShot posn: 0 0)
									)
								else
									(mugShot2 posn: 0 0)
								)
								(folderScript changeState: 2)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<around,at][/chamber,jail]')
								(localproc_0 23 17) ; "This is the Lytton City Jail prisoner receiving area."
							)
							((Said '[<down,at][/floor]')
								(localproc_0 23 18) ; "There's nothing to be found on the jail floor, except floor tiles and waxy build-up."
							)
							((Said '[<up,at][/ceiling,roof]')
								(localproc_0 23 19) ; "Brand new acoustical ceiling, with things that sparkle in it."
							)
							((Said '/jailer,(cop[<correctional])')
								(cond
									((not local8)
										(localproc_0 23 20) ; "He's not here."
									)
									((== global100 0)
										(localproc_0 23 21) ; "It's the jailer on duty. He's NOT a wild and crazy guy."
									)
									(else
										(localproc_0 23 22) ; "The jailer's been very nervous since the escape, and he looks it."
									)
								)
							)
							((Said '/wall')
								(localproc_0 23 23) ; "Solid. No windows. Jail-like color scheme."
							)
							((Said '/file')
								(if local8
									(if (>= global100 1)
										(localproc_0 23 24) ; "Which file do you want to look at?"
									else
										(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
									)
								else
									(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
								)
							)
							((Said '/man')
								(cond
									(local8
										(if (>= global100 1)
											(localproc_0 23 22) ; "The jailer's been very nervous since the escape, and he looks it."
										else
											(localproc_0 23 21) ; "It's the jailer on duty. He's NOT a wild and crazy guy."
										)
									)
									(local2
										(if local5
											(localproc_0 23 27) ; "This scuzzball isn't worth describing, except to say that he's disgusting and surly."
										else
											(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
										)
									)
									(else
										(localproc_0 23 20) ; "He's not here."
									)
								)
							)
							((Said '/convict,witness,saxton')
								(cond
									(
										(and
											(>= global100 1)
											local8
											(not local3)
											(not local4)
										)
										(= local1 1)
										(if local0
											(localproc_0 23 29) ; "Like I told you before..." the jailer says, "just walk into the next room, and I'll call him out."
										else
											(= local0 1)
											(localproc_0 23 30) ; "Yes" he says..."we have one man in custody who saw the whole thing. Saxton...Sherman Saxton is his name."
											(localproc_0 23 31) ; "The correctional officer continues..."Just walk over to the interview area, and I'll call him out.""
											(SetScore 1 69)
										)
									)
									(local2
										(cond
											(local8
												(localproc_0 23 32) ; "He's in the other room."
											)
											(local5
												(localproc_0 23 27) ; "This scuzzball isn't worth describing, except to say that he's disgusting and surly."
											)
											(else
												(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
											)
										)
									)
									(else
										(localproc_0 23 20) ; "He's not here."
									)
								)
							)
						)
					)
					((Said 'talk/angel<death')
						(if local8
							(Print 23 33) ; "You are near the jailer."
						else
							(Print 23 34) ; "You are NOT near the jailer."
						)
					)
					((Said 'talk/woman')
						(localproc_0 23 35) ; "There are no women in here."
					)
					(
						(or
							(Said 'see,show/witness,saxton')
							(Said
								'interrogate,ask/jailer,cop,man/witness,saxton'
							)
						)
						(cond
							((>= global100 1)
								(cond
									((and local8 (not local2) (not local4))
										(= local1 1)
										(if local0
											(localproc_0 23 29) ; "Like I told you before..." the jailer says, "just walk into the next room, and I'll call him out."
										else
											(= local0 1)
											(localproc_0 23 30) ; "Yes" he says..."we have one man in custody who saw the whole thing. Saxton...Sherman Saxton is his name."
											(localproc_0 23 31) ; "The correctional officer continues..."Just walk over to the interview area, and I'll call him out.""
											(SetScore 1 69)
										)
									)
									(local2
										(cond
											(local8
												(localproc_0 23 36) ; "He's in the other room."
											)
											(local5
												(localproc_0 23 37) ; "You want to see the witness? You're looking at him!"
											)
											(else
												(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
											)
										)
									)
									(else
										(localproc_0 23 20) ; "He's not here."
									)
								)
							)
							(local8
								(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					((Said 'interrogate,talk/jailer,cop')
						(if local8
							(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
						else
							(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
						)
					)
					(
						(or
							(Said 'call,ask,talk,interrogate/witness,saxton')
							(Said 'have<do/witness')
							(Said
								'ask,talk,describe/kidnapping,clue,escape,incident'
							)
							(Said
								'interrogate,ask,talk/man,jailer,cop/clue,kidnapping,escape,incident'
							)
						)
						(cond
							(
								(and
									local8
									(>= global100 1)
									(not local3)
									(not local4)
								)
								(= local1 1)
								(if local0
									(localproc_0 23 29) ; "Like I told you before..." the jailer says, "just walk into the next room, and I'll call him out."
								else
									(= local0 1)
									(localproc_0 23 30) ; "Yes" he says..."we have one man in custody who saw the whole thing. Saxton...Sherman Saxton is his name."
									(localproc_0 23 31) ; "The correctional officer continues..."Just walk over to the interview area, and I'll call him out.""
									(SetScore 1 69)
								)
							)
							((>= global100 1)
								(cond
									(local3
										(if local5
											(if (IsFlag 70)
												(localproc_0 23 38) ; "C'mon, man. The dude made himself a knife, held it on the jailer, and pulled off a pretty slick escape. That's it!"
												(= local4 1)
												(= local3 0)
											else
												(SetScore 2 70)
												(witnessTalking play:)
												(localproc_0 23 39) ; "Oh yeah, the escape," he says. "That dude Bains did a number on your little jailer friend."
												(Print 23 40 #at -1 125) ; "Bains jumped your little rookie while being moved. It looked like he was holding some sort of knife to the jailer's throat."
												(Print 23 41 #at -1 125) ; "It looked so easy!" Saxton says, "I mean, he just grabbed the jailer, put a knife to his throat, and sashayed right out of the jail. Unbelievable!"
												(= local4 1)
												(= local3 0)
											)
										else
											(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
										)
									)
									((> (gEgo x:) 210)
										(localproc_0 23 42) ; "I didn't see much myself, but we do have a witness to the incident. One of the prisoners was right there when it went down."
									)
									(local4
										(localproc_0 23 43) ; "Hey man!" Saxton says, "I've told you everything I saw."
									)
									(else
										(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
									)
								)
							)
							(else
								(localproc_0 23 44) ; "I'm not aware of anything like that, Bonds."
							)
						)
					)
					((Said 'yes')
						(if (and local2 (not local8))
							(localproc_0 23 45) ; "Ahh, c'mon. You've got to be kidding."
						else
							(localproc_0 23 46) ; "Yes....what?"
						)
					)
					((Said 'no')
						(if (and local2 (not local8))
							(localproc_0 23 47) ; "Yeah. I didn't think so."
						else
							(localproc_0 23 48) ; "No....what?"
						)
					)
					((Said 'open/door')
						(localproc_0 23 49) ; "The only door you're authorized to open is the one leading back into the garage."
					)
					(
						(or
							(Said 'talk/bains')
							(Said
								'talk,ask[/man,jailer,cop,witness,convict,saxton]/bains'
							)
						)
						(if (< global100 1)
							(localproc_0 23 50) ; "The jailer tells you, "The last person he'd want to see right now is you, Bonds.""
							(Print 23 51 #at -1 125) ; "You'll have your second chance at him in court, Sonny, but for the moment, you'll have to wait. He's not allowed to see anyone, including you."
						else
							(localproc_0 23 52) ; "If you can find him, and you can get close enough to him without getting killed, you might be able to talk to him."
						)
					)
					(
						(or
							(Said '[give,get]/description[<auto]')
							(Said 'give,get/description[<auto]/me')
							(Said 'describe,ask,talk[<about]/auto')
							(Said 'ask/jailer,man,cop/auto')
						)
						(cond
							(local8
								(if (>= global100 1)
									(SetScore 1 110)
									(localproc_0 23 53) ; ""That's easy," he says, "Pate's car is a blue 1986 Corvette with personalized plates that say `WOW'."
								else
									(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
								)
							)
							(local5
								(if local3
									(localproc_0 23 54) ; "I don't know nothing about any car."
								else
									(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
								)
							)
							(else
								(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
							)
						)
					)
					((Said 'talk/jailer,cop[<correctional]')
						(if local8
							(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
						else
							(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
						)
					)
					((Said 'open,unlock/cell,cage')
						(cond
							(local8
								(localproc_0 23 55) ; "Now you know I can't do that...even for you, Sonny."
							)
							(local3
								(localproc_0 23 56) ; "Yeah," Saxton grumbles, "I sure wish you would!"
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					((Said 'interrogate,talk,see/convict')
						(cond
							(local8
								(if (and (not local1) (not local3) (not local4))
									(localproc_0 23 57) ; ""Which prisoner do you wanna talk to?" he says."
									(= local17 50)
								else
									(localproc_0 23 20) ; "He's not here."
								)
							)
							(local2
								(if local5
									(if local4
										(localproc_0 23 43) ; "Hey man!" Saxton says, "I've told you everything I saw."
									else
										(localproc_0 23 58) ; "Hey, I don't know what you want to talk about."
									)
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 59) ; "Where is he?"
							)
						)
					)
					(
						(or
							(Said
								'witness,see,talk,ask/incident,kidnapping,escape'
							)
							(Said
								'tell,talk,interrogate,ask/me,saxton,jailer,convict,witness,man/incident,kidnapping,escape'
							)
							(Said 'witness,see<did/kidnapping,escape,incident')
							(Said '(see<did)<what')
							(Said '(see<did)/anything')
						)
						(if (>= global100 1)
							(cond
								(local5
									(cond
										(local3
											(if (IsFlag 70)
												(localproc_0 23 38) ; "C'mon, man. The dude made himself a knife, held it on the jailer, and pulled off a pretty slick escape. That's it!"
												(= local4 1)
												(= local3 0)
											else
												(SetScore 2 70)
												(witnessTalking play: loop: 2)
												(localproc_0 23 39) ; "Oh yeah, the escape," he says. "That dude Bains did a number on your little jailer friend."
												(Print 23 40 #at -1 125) ; "Bains jumped your little rookie while being moved. It looked like he was holding some sort of knife to the jailer's throat."
												(Print 23 41 #at -1 125) ; "It looked so easy!" Saxton says, "I mean, he just grabbed the jailer, put a knife to his throat, and sashayed right out of the jail. Unbelievable!"
												(= local4 1)
												(= local3 0)
											)
										)
										(local8
											(localproc_0 23 42) ; "I didn't see much myself, but we do have a witness to the incident. One of the prisoners was right there when it went down."
										)
										(local4
											(localproc_0 23 43) ; "Hey man!" Saxton says, "I've told you everything I saw."
										)
										(else
											(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
										)
									)
								)
								(local8
									(localproc_0 23 42) ; "I didn't see much myself, but we do have a witness to the incident. One of the prisoners was right there when it went down."
								)
								(else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
						else
							(localproc_0 23 58) ; "Hey, I don't know what you want to talk about."
						)
					)
					(
						(or
							(Said
								'talk,ask/jailer,cop,witness,saxton,convict,man/knife'
							)
							(Said 'talk,ask/knife')
							(Said '(see[<did])/knife')
						)
						(cond
							(local8
								(if (>= global100 1)
									(localproc_0 23 60) ; "Yeah, that's right!" the jailer says. " I sure don't know where THAT came from!"
								else
									(localproc_0 23 61) ; "The jailer says: "Huh?""
								)
							)
							(local2
								(if local5
									(localproc_0 23 62) ; "Yeah, that's right!" Saxton chuckles. " I sure wish I knew where THAT came from!"
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					(
						(or
							(Said '[interrogate,look,see,get,ask]/bains')
							(Said '[look,see,get,ask]/file<bains')
							(Said 'give,show,get/[me,jailer,cop]/file<bains')
							(Said 'ask[/man,jailer,cop]/file<bains')
						)
						(cond
							(local8
								(cond
									((> local17 0)
										(if (>= global100 1)
											(localproc_0 23 63) ; "He escaped!"
										else
											(localproc_0 23 50) ; "The jailer tells you, "The last person he'd want to see right now is you, Bonds.""
											(Print 23 51 #at -1 125) ; "You'll have your second chance at him in court, Sonny, but for the moment, you'll have to wait. He's not allowed to see anyone, including you."
										)
									)
									((>= global100 1)
										(if
											(or
												(== (mod (++ local13) 2) 1)
												(< local13 2)
											)
											(if (> local13 1)
												(localproc_0 23 64) ; "OK, OK..." the jailer exclaims. "If you want to see his file, I'll get it for you."
											else
												(localproc_0 23 65) ; "Oh, yeah!" the jailer says. "Let me get Bains' file for you. I'm sure you'll want to take a look at it."
											)
											(= local15 0)
											(jailerScript changeState: 7)
										else
											(localproc_0 23 66) ; "Hey, Sonny. You gave it back to me and I put it away. Don't make me go get it again."
										)
									)
									((< global100 1)
										(localproc_0 23 50) ; "The jailer tells you, "The last person he'd want to see right now is you, Bonds.""
										(Print 23 51 #at -1 125) ; "You'll have your second chance at him in court, Sonny, but for the moment, you'll have to wait. He's not allowed to see anyone, including you."
									)
								)
							)
							(local2
								(if local5
									(localproc_0 23 67) ; "I don't know nothin' about the dude, man. Really!"
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					(
						(or
							(Said '[look,see,get,ask]/luis')
							(Said '[look,see,get,ask]/file<luis')
							(Said 'give,show,get/[me,jailer,cop]/file<luis')
							(Said 'ask[/man,jailer,cop]/file<luis')
							(Said 'ask/jailer/!*')
						)
						(cond
							(local8
								(cond
									((> local17 0)
										(localproc_0 23 68) ; "Pate? He's not a prisoner! He's the other jailer!"
									)
									((== global100 0)
										(localproc_0 23 69) ; "You mean Luis Pate, the rookie? He's on duty right now, Bonds."
									)
									((>= global100 1)
										(if
											(or
												(== (mod (++ local14) 2) 1)
												(< local14 2)
											)
											(if (> local14 1)
												(localproc_0 23 64) ; "OK, OK..." the jailer exclaims. "If you want to see his file, I'll get it for you."
											else
												(localproc_0 23 70) ; "Oh, yeah!" the jailer says. "You'll want to look at Pate's file. I'll go get it for you."
											)
											(= local15 1)
											(SetScore 2 117)
											(jailerScript changeState: 7)
										else
											(localproc_0 23 66) ; "Hey, Sonny. You gave it back to me and I put it away. Don't make me go get it again."
										)
									)
								)
							)
							((or local3 local4)
								(if local5
									(localproc_0 23 71) ; "Never heard of anyone by that name, man."
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					((Said 'show,flash/badge')
						(cond
							(local8
								(localproc_0 23 72) ; "OK, OK! I know who you are!"
							)
							(local3
								(if local5
									(localproc_0 23 72) ; "OK, OK! I know who you are!"
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 73) ; "Nobody can see your badge."
							)
						)
					)
					(
						(or
							(Said 'see,look,show,get,ask/file')
							(Said 'have<do/file')
						)
						(if local8
							(if (>= global100 1)
								(localproc_0 23 24) ; "Which file do you want to look at?"
							else
								(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
							)
						else
							(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
						)
					)
					((Said 'interrogate,talk/man')
						(cond
							(local8
								(localproc_0 23 25) ; "The jailer says, "I don't know what you're trying to talk about, Bonds.""
							)
							((and local2 (or local3 local4))
								(if local5
									(localproc_0 23 58) ; "Hey, I don't know what you want to talk about."
								else
									(localproc_0 23 28) ; "Walk right up to him, stare him in the eye, and try again."
								)
							)
							(else
								(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
							)
						)
					)
					((Said '[see,talk]/*')
						(if (> local17 0)
							(localproc_0 23 74) ; "We don't have a prisoner here by that name."
						else
							(event claimed: 0)
						)
					)
					(
						(or
							(Said 'get[<back]/9mm[/jailer,cop]')
							(Said 'give[<back]/9mm')
							(Said 'give[/me]/9mm')
							(Said 'replace/9mm')
							(Said 'ask[/man,jailer,cop]/9mm')
							(Said 'ask/9mm')
						)
						(if local8
							(if (== ((gInventory at: 0) owner:) 23) ; hand_gun
								(jailerScript changeState: 13)
							else
								(localproc_0 23 75) ; "What're you talking about?" says the jailer. "I don't have your gun. I sure hope YOU know where it is!"
							)
						else
							(localproc_0 23 26) ; "The jailer says, "Are you talking to me? I'm over here, Bonds!""
						)
					)
					(
						(or
							(Said 'get[<back]/briefcase[/jailer,cop]')
							(Said 'give[<back]/briefcase')
							(Said 'give[/me]/briefcase')
							(Said 'replace/briefcase')
							(Said 'ask[/man,jailer,cop]/briefcase')
							(Said 'ask/briefcase')
						)
						(if local8
							(if (== ((gInventory at: 10) owner:) 23) ; field_kit
								(localproc_0 23 76) ; "You retrieve your kit."
								(gEgo get: 10) ; field_kit
								(jailerScript changeState: 12)
							else
								(localproc_0 23 77) ; "What are you talking about? I don't have your field kit, Bonds."
							)
						)
					)
					(
						(or
							(Said 'close,replace/file,file')
							(Said 'give[<back]/file,file')
						)
						(localproc_0 23 78) ; "You don't have it."
					)
				)
			)
		)
	)
)

(instance folderScript of Script
	(properties)

	(method (init)
		(User canInput: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jailer hide:)
				(gEgo hide:)
				(witness hide:)
				(self cue:)
			)
			(1
				(= local9 1)
				(= local10 0)
				(localproc_1)
			)
			(2
				(jailer show:)
				(gEgo show:)
				(witness show:)
				(HandsOn)
				(= local11 1)
				(= local12 0)
				(User canControl: 1)
				(gCurRoom drawPic: 23 8)
				(SetMenu 513 112 1)
				(rm23Script changeState: 0)
			)
		)
	)
)

(instance witnessScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(witness setLoop: 0)
			)
			(1
				(= local1 0)
				(= local2 1)
				(witness cycleSpeed: 1 setMotion: MoveTo 153 112 self startUpd:)
			)
			(2
				(witness setLoop: 2 setMotion: MoveTo 153 114 self)
			)
			(3
				(witness setPri: 7 setLoop: 1 setMotion: MoveTo 146 114 self)
			)
			(4
				(witness setLoop: 2 setMotion: MoveTo 142 116 self)
			)
			(5
				(witness stopUpd:)
				(= local3 1)
				(if (IsFlag 70)
					(localproc_0 23 79 83) ; "You're sure keeping me busy, man. I don't know what else I can tell you."
				else
					(localproc_0 23 80 83) ; ""You here to get me out of this joint?" Saxton asks."
				)
			)
			(6
				(= local4 0)
				(witness startUpd: setLoop: 3 setMotion: MoveTo 146 114 self)
			)
			(7
				(witness setLoop: 0 setMotion: MoveTo 153 114 self)
			)
			(8
				(witness setLoop: 3 setMotion: MoveTo 153 112 self)
			)
			(9
				(witness setPri: 6 setLoop: 1 setMotion: MoveTo 69 112 self)
			)
			(10
				(= local2 0)
				(witness setLoop: 0 setMotion: 0 stopUpd:)
			)
		)
	)
)

(instance jailerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jailer setMotion: MoveTo 248 125 self startUpd:)
				(User canInput: 0)
			)
			(1
				(if (== global100 1)
					(Print 23 81 #at -1 120 #draw) ; "Obviously excited, the jailer says..."Bonds! I can't believe what's happened. I can't get over it! We've never had an officer kidnapped before.""
					(Print 23 82 #at -1 120 #draw) ; "Continuing..."Bains took Pate and escaped in Pate's car. I sure hope he's OK. Poor kid...he's just a rookie, you know.""
					(Print 23 83 #at -1 120 #draw) ; "Heck, we just put together the file on Bains this morning, and he's gone already."
					(= local7 1)
					(= global138 0)
					(if (gEgo has: 0) ; hand_gun
						(localproc_0 23 84 83) ; "What a day THIS has been!....Hey, wait just a minute there, Bonds!"
					)
					(self cue:)
				else
					(self cue:)
				)
			)
			(2
				(User canInput: 1)
				(if (gEgo has: 0) ; hand_gun
					(localproc_0 23 85 83) ; "The jailer walks up to you and says, "The bulge under your jacket here...that looks like a gun to me!""
					(localproc_0 23 86 83) ; "C'mon, Bonds!" the jailer demands. "You forgot to put it in the locker outside, didn't you? Stick to the regulations, Sonny!"
					(localproc_0 23 87 83) ; "The jailer relieves you of your Colt automatic and says..."
					(localproc_0 23 88 83) ; "Just contribute five bucks to our coffee fund on your way out, and you can have this back."
					(gEgo put: 0 23) ; hand_gun
					(self cue:)
				else
					(self cue:)
				)
			)
			(3
				(if (gEgo has: 10) ; field_kit
					(Print 23 89 #at -1 120) ; "While I'm at it," the jailer continues, " give me your field kit to put behind the counter. You're not supposed to bring it in here, you know."
					(localproc_0 23 90) ; "You hand your field kit to the jailer."
					(gEgo put: 10 23) ; field_kit
				)
				(if (== ((gInventory at: 0) owner:) 23) ; hand_gun
					(localproc_0 23 91) ; "Now that THAT little piece of business is out of the way...."
				)
				(cond
					((>= global100 2)
						(Print 23 92 #at -1 125 #draw) ; "I hate to be rude, Bonds" he says, "but I'm really busy. Unless you have important business, just show yourself out."
						(= local7 1)
					)
					((< global100 1)
						(localproc_0 23 93 83) ; ""What can I do for you, Bonds?" the jailer asks."
						(= local7 1)
					)
				)
			)
			(4
				(jailer setMotion: MoveTo 275 129 self)
			)
			(5
				(jailer stopUpd:)
			)
			(6
				(jailer setMotion: MoveTo 248 125 startUpd:)
			)
			(7
				(HandsOff)
				(jailer setLoop: 0 setMotion: MoveTo 275 129 startUpd:)
				(= local16 30)
			)
			(8
				(jailer setLoop: 1 setMotion: MoveTo 248 125 self)
			)
			(9
				(localproc_0 23 94 83) ; "Here you go, Bonds. The files have to stay here, so give 'em back before you leave."
				(if (== local15 0)
					(localproc_0 23 95 83) ; "The jailer hands you the file on Jessie Bains."
				else
					(localproc_0 23 96 83) ; "The jailer hands you the file on Luis Pate."
				)
				(= local12 1)
				(SetMenu 513 112 0)
				(folderScript changeState: 0)
			)
			(10
				(HandsOff)
				(localproc_0 23 97) ; "Having reviewed the file, you return it."
				(localproc_0 23 98) ; "The jailer puts the file away."
				(jailer setLoop: 0 setMotion: MoveTo 275 129 startUpd:)
				(= local16 20)
			)
			(11
				(jailer setLoop: -1 setMotion: MoveTo 248 125)
				(HandsOn)
			)
			(12
				(HandsOff)
				(if (== ((gInventory at: 0) owner:) 23) ; hand_gun
					(self cue:)
				else
					(gEgo setMotion: MoveTo 228 127)
					(self changeState: 14)
				)
			)
			(13
				(HandsOff)
				(localproc_0 23 99) ; "OK, Sonny" says the jailer. "Here's your weapon. Don't forget the five bucks for the coffee fund!"
				(localproc_0 23 100) ; "You donate the $5.00 to the coffee fund."
				(if (> global107 5)
					(-= global107 5)
				)
				(if (== ((gInventory at: 10) owner:) 23) ; field_kit
					(localproc_0 23 76) ; "You retrieve your kit."
					(gEgo get: 10) ; field_kit
				)
				(gEgo get: 0 setMotion: MoveTo 228 127 self) ; hand_gun
			)
			(14
				(if (== global100 1)
					(= global100 2)
					(= global158 0)
				)
				(gEgo illegalBits: 0 setMotion: MoveTo 239 160 self)
			)
			(15
				(HandsOn)
				(gEgo illegalBits: $8000)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

