;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 266)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	celirock 0
)

(synonyms
	(celie chair person woman)
)

(local
	local0
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 40 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance cBlock of Blk
	(properties
		top 101
		left 260
		bottom 103
		right 290
	)
)

(instance celirock of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(LoadMany rsVIEW 480 901)
		(= global208 2)
		(if global135
			(LoadMany rsMESSAGE 243 283)
			(= [global377 1] 283)
		else
			(LoadMany rsMESSAGE 243 228)
			(= [global377 1] 228)
		)
		(Celie cycleSpeed: 1 setCycle: Fwd init:)
		(chair init: hide:)
		(myMusic number: 33 loop: -1 play:)
		(gEgo observeBlocks: cBlock)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(= global213 2)
		(cond
			((Said 'look/darning')
				(Print 266 0) ; "Celie's darning her socks."
			)
			((Said 'get/darning')
				(Print 266 1) ; "Those are not your socks!"
			)
			((Said 'show,give/necklace')
				(if (gEgo has: 0) ; necklace
					(if (< (gEgo distanceTo: Celie) 40)
						(Say 1 266 2) ; "My necklace! I wuz wunderin' where it got to! Well, Missy Laura. Why don' you come in an' visit wid me awhile?"
						(gEgo put: 0) ; necklace
						(= global135 1)
						(= temp0 7)
						(for ((= temp1 0)) (< temp1 7) ((++ temp1))
							(= [global225 temp0] 0)
							(++ temp0)
						)
						(self setScript: enter)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'listen/celie')
				(Print 266 3) ; "Celie's not saying anything."
			)
			((Said 'talk/celie')
				(if global135
					(switch local0
						(0
							(Say 1 266 4) ; "Hey, Missy Laura! What're you doin' out here; jus' takin' a walk?"
						)
						(1
							(Say 1 266 5) ; "It's a turrible sultry night, ain't it? Strange, though...I feel an awful chill in mah bones. Dem chickens are so steered up, it'll be a week fo' I git anymo' eggs!"
						)
						(2
							(Say 1 266 6) ; "You watch yourse'f, chile; wanderin' 'round in the dark. I'd hate to see you git hurt."
						)
						(3
							(Say 1 266 7) ; "I don' know why, but I'm a'feelin' kinda anxious. I cain't pinpoint it, though; I jus' feel things ain't right 'round here."
						)
						(4
							(Say 1 266 8) ; "Oh, well. I gotta shake these bad feelin's. You run along, chile, and let me finish these here socks so's I can git to bed."
						)
						(5
							(Say 1 266 9) ; "(Yawn) Yeah, I am kinda tired. You go on now, hear?"
						)
						(else
							(Print 266 10) ; "Celie doesn't answer you anymore as she's trying to finish her darning."
						)
					)
				else
					(switch local0
						(0
							(Say 1 266 11) ; "I tol' you befo' I don' have nothin' to say!"
						)
						(1
							(Say 1 266 12) ; "Run along now! Let me finish my darnin'."
						)
						(2
							(Say 1 266 13) ; "I don' wanna talk!"
						)
						(3
							(Print 266 14) ; "To your annoyance, Celie refuses to answer you, and instead begins to hum softly to herself while darning her socks."
						)
						(else
							(Print 266 15) ; "Celie is humming softly to herself and doesn't answer."
						)
					)
				)
				(++ local0)
			)
		)
	)
)

(instance enter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0001))
					(gEgo setMotion: MoveTo 218 100 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Celie loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 3)
				(chair show:)
				(Celie
					view: 480
					posn: 250 102
					setCycle: Walk
					setMotion: MoveTo 240 97 self
				)
			)
			(3
				(LookAt Celie global373)
				(global373 setCycle: End self)
			)
			(4
				(Celie
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 240 91 self
				)
			)
			(5
				(gCurRoom newRoom: 59)
				(client setScript: 0)
			)
		)
	)
)

(instance Celie of Act
	(properties
		y 102
		x 270
		view 484
		loop 2
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0002)))
				(event claimed: 1)
				(DoLook {celie})
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event 3) (Said 'look/celie'))
				)
				(event claimed: 1)
				(Print 266 16) ; "Celie sits outside in her old rocking chair, darning some socks."
			)
		)
	)
)

(instance frontDoor of Prop ; UNUSED
	(properties
		y 93
		x 227
		view 106
		priority 5
	)
)

(instance chair of Prop
	(properties
		y 102
		x 270
		view 484
		loop 1
		cel 1
	)
)

(instance myMusic of Sound
	(properties)
)

