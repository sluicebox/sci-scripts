;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
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
	rm10 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
	[local9 4]
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	[local25 22]
	[local47 22]
	local69
	local70
	local71
	local72
	local73
	local74
	local75
	local76
	local77
	local78
)

(procedure (localproc_0 param1)
	(= local3 (- 207 (* local4 28)))
	((= [local5 param1] (Prop new:))
		posn: local3 127
		setPri: 9
		loop: (Random 1 2)
		view: 73
		cycleSpeed: 1
		init:
		stopUpd:
	)
	((View new:)
		posn: local3 98
		setPri: 9
		loop: 0
		cel: (Random 0 3)
		view: 73
		init:
		addToPic:
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= temp0 (param1 loop:))
	(DirLoop param1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(if (== argc 3)
		(DirLoop
			param2
			(GetAngle (param2 x:) (param2 y:) (param1 x:) (param1 y:))
		)
	)
	(if (!= temp0 (param1 loop:))
		(param1 forceUpd:)
	)
)

(instance shot of Sound
	(properties)
)

(instance leftArm of Prop
	(properties
		view 70
		loop 1
		priority 12
		signal 26640
	)

	(method (doit)
		(self posn: (gEgo x:) (gEgo y:))
	)
)

(instance rightArm of Prop
	(properties
		view 70
		loop 1
		cel 1
		priority 12
		signal 26640
	)

	(method (doit)
		(self posn: (gEgo x:) (gEgo y:))
	)
)

(instance rm10 of Rm
	(properties
		picture 10
		style 1
	)

	(method (init)
		(super init:)
		(= local77 1)
		(NormalEgo)
		(HandsOn)
		(Load rsVIEW 1)
		(Load rsVIEW 72)
		(Load rsVIEW 0)
		(Load rsVIEW 58)
		(Load rsVIEW 73)
		(Load rsSOUND 41)
		(= local74 0)
		(= local75 0)
		(= global212 3)
		(= global211 1)
		(self setScript: rm10Script)
	)
)

(instance door of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== (gEgo onControl: 1) 4096) (< state 3))
				(= state 3)
				(local0 setMotion: MoveTo 270 137 self)
			)
			((and (!= (gEgo onControl: 1) 4096) (== state 4))
				(= state 1)
				(local0 setMotion: MoveTo 242 137 self)
			)
		)
	)

	(method (cue)
		(client stopUpd:)
		(++ state)
	)
)

(instance rm10Script of Script
	(properties)

	(method (doit)
		(cond
			((< (gEgo y:) 137)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(cond
			((& $0040 (gEgo onControl:))
				(gCurRoom newRoom: 2)
			)
			((and (== (gEgo onControl: 1) 16384) (== (gEgo loop:) 3))
				(self changeState: 3)
			)
			((!= (self state:) 3)
				(self changeState: 1)
			)
		)
		(if (not (< global110 30))
			(if (== local13 30)
				(= local4 (Random 0 3))
				(if (!= (gCast indexOf: [local5 local4]) -1)
					(= local13 (Random 1 12))
					(shooterScript changeState: 0)
				)
			else
				(++ local13)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= [local25 1] 0)
				(= [local25 2] -2)
				(= [local25 3] 2)
				(= [local25 4] 0)
				(= [local25 5] 0)
				(= [local25 6] -1)
				(= [local25 7] 1)
				(= [local25 8] 0)
				(= [local25 9] 0)
				(= [local25 10] -1)
				(= [local25 11] 1)
				(= [local25 12] -2)
				(= [local25 13] 2)
				(= [local25 14] -1)
				(= [local25 15] 1)
				(= [local25 16] -1)
				(= [local25 17] 1)
				(= [local25 18] -2)
				(= [local25 19] 2)
				(= [local25 20] 1)
				(= [local25 21] -1)
				(= [local47 1] 0)
				(= [local47 2] -1)
				(= [local47 3] 1)
				(= [local47 4] -1)
				(= [local47 5] 1)
				(= [local47 6] -1)
				(= [local47 7] 1)
				(= [local47 8] -2)
				(= [local47 9] 2)
				(= [local47 10] 1)
				(= [local47 11] -1)
				(= [local47 12] 0)
				(= [local47 13] 0)
				(= [local47 14] 2)
				(= [local47 15] -2)
				(= [local47 16] 0)
				(= [local47 17] 0)
				(= [local47 18] 1)
				(= [local47 19] -1)
				(= [local47 20] 2)
				(= [local47 21] -2)
				((= local0 (Act new:))
					view: 58
					setCycle: 0
					setCel: 0
					yStep: 1
					xStep: 1
					illegalBits: 0
					posn: 242 137
					init:
					stopUpd:
					setScript: door
				)
				(attendant view: 72 loop: 1 cel: 0 posn: 161 156 stopUpd: init:)
				(= local1 0)
				(gEgo
					posn: 20 145
					setMotion: MoveTo 161 140
					setCycle: Walk
					init:
				)
				(for ((= local4 0)) (<= local4 3) ((+= local4 1))
					(cond
						((not local77)
							(if [local9 local4]
								(localproc_0 local4)
							)
						)
						((== (Random 1 2) 1)
							(localproc_0 local4)
							(= [local9 local4] 1)
						)
					)
				)
				(= local77 0)
			)
			(1
				(= local1 0)
			)
			(2
				(if (== local1 0)
					(Print 10 0) ; "Hello, Sonny. Can I help you?"
				)
				(= local1 1)
			)
			(3
				(if
					(or
						(and
							(!= (gCast indexOf: [local5 0]) -1)
							(< (gEgo distanceTo: [local5 0]) 20)
						)
						(and
							(!= (gCast indexOf: [local5 1]) -1)
							(< (gEgo distanceTo: [local5 1]) 20)
						)
						(and
							(!= (gCast indexOf: [local5 2]) -1)
							(< (gEgo distanceTo: [local5 2]) 20)
						)
						(and
							(!= (gCast indexOf: [local5 3]) -1)
							(< (gEgo distanceTo: [local5 3]) 20)
						)
					)
					(Print 10 1) ; "You hear Officer Mills' voice boom from the PA system..."
					(Print 10 2) ; "Bonds, find a booth and stop bothering the other officers!"
					(gEgo
						setMotion:
							MoveTo
							(if (== (Random 1 2) 1) 320 else 0)
							(gEgo y:)
					)
				else
					(= local2 (gEgo x:))
					(++ global210)
					(rm10 setScript: boothScript)
				)
			)
			(4
				(rightArm dispose:)
				(leftArm dispose:)
				(= global204 0)
				(gEgo
					view: 0
					setCycle: Walk
					setStep: 3 2
					setMotion: 0
					setLoop: -1
					illegalBits: $8000
					ignoreActors: 0
					setPri: -1
					posn: local2 130
					init:
				)
				(= local1 0)
				(if (== local75 1)
					(Print 10 3) ; "As you walk out from the booth, you take off your ear protectors."
					(= local75 0)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,chamber,range]')
								(Print 10 4) ; "This is the shooting range. Each officer is expected to maintain a proficient level in weapons training."
								(Print 10 5) ; "You see the weapons officer, Ken Mills, standing behind the equipment counter."
							)
							((Said '/counter,bookcase,coatrack')
								(Print 10 6) ; "The equipment counter holds ear protectors and additional ammunition."
							)
							((Said '/glass')
								(cond
									(
										(and
											(>= (gEgo x:) 47)
											(>= (gEgo y:) 137)
											(== (gEgo loop:) 3)
										)
										(Print 10 7) ; "Looking through the glass, you see five shooting booths."
									)
									((<= (gEgo y:) 135)
										(Print 10 8) ; "Looking through the glass, you see the weapons officer behind the counter."
									)
									(else
										(event claimed: 0)
									)
								)
							)
							((or (Said '/cop[<weapons]') (Said '/man,ken,ken'))
								(Print 10 9) ; "Weapons officer, Ken Mills, stands behind the equipment counter."
							)
							((Said '/bullseye')
								(Print 10 10) ; "You can't see the target very well from here."
							)
							((Said '/*')
								(if (gEgo inRect: 152 153 210 158)
									(Print 10 11) ; "Mills says, "Bonds, I'm in charge here. Move out!""
								else
									(event claimed: 0)
								)
							)
						)
					)
					((Said 'talk/man,cop,ken')
						(cond
							((< (gEgo y:) 139)
								(Print 10 12) ; "They can't hear you ."
							)
							((gEgo inRect: 152 153 210 158)
								(Print 10 13) ; "Officer Mills says, "Bonds, you don't belong behind here.""
							)
							(local74
								(Print 10 14) ; "I'm here to help," Mills says, "but I don't have time for small talk."
							)
							(else
								(switch (Random 0 2)
									(0
										(Print 10 15) ; "The weapons officer, Ken Mills, says, "What's the game plan, fella?""
									)
									(1
										(Print 10 16) ; ""What can I do for you?" asks Ken."
									)
									(2
										(Print 10 17) ; "Hey Sonny!" Mills says, "What do you need?"
									)
								)
								(= local74 1)
							)
						)
					)
					(
						(or
							(Said 'ask,use/range[<shooting]')
							(Said 'use/booth[<shooting]')
							(Said 'fire/range,bullseye')
							(Said 'bullseye/fire')
						)
						(if (== (gEgo onControl: 1) 8192)
							(Print 10 18) ; "Weapons officer Mills says, "Before you shoot, I need to check the trigger pull on your weapon.""
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((or (Said 'give/9mm') (Said 'show/9mm'))
						(if (== (gEgo onControl: 1) 8192)
							(if (gEgo has: 0) ; hand_gun
								(Print 10 19) ; "Ken takes your weapon and checks the trigger pull. He then hands it back to you and says..."
								(Print 10 20) ; "OK Bonds. Pick any open booth and obey all safety regulations while in the range."
								(Print 10 21) ; "Mills continues, "When you're ready, you can fire at will, and don't forget to see me for a new supply of ammo before leaving.""
							else
								(proc0_13) ; "You don't have your gun."
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said '(hand<in),exit,replace,give/ep[<ear]')
						(cond
							((not (gEgo has: 15)) ; ear_protectors
								(proc0_9) ; "You don't have it."
							)
							((!= (gEgo onControl: 1) 8192)
								(proc0_7) ; "You're not close enough."
							)
							(else
								(Print 10 22) ; "Thank you."
								(PutItem 15) ; ear_protectors
							)
						)
					)
					((or (Said 'get/ep[<ear]') (Said 'ask/ep[<ear]'))
						(if (== (gEgo onControl: 1) 8192)
							(if (== (gEgo has: 15) 0) ; ear_protectors
								(Print 10 23) ; "Here you are," Ken says,"one pair of ear protectors. Just return them when you're through."
								(gEgo get: 15) ; ear_protectors
								(SetScore 2 66)
							else
								(Print 10 24) ; "You have them."
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					(
						(or
							(Said 'get,replace,exchange,ask/ammo,clip')
							(Said 'ask//ammo,clip')
						)
						(cond
							((!= (gEgo onControl: 1) 8192)
								(Print 10 25) ; "You are not close enough to the weapons officer."
							)
							((and (not (gEgo has: 1)) (not global207)) ; extra_ammo_clips
								(Print 10 26) ; "You don't have any ammo clips with you."
							)
							((and (not (gEgo has: 1)) global207) ; extra_ammo_clips
								(if [global215 global207]
									(Print 10 27) ; "Ken says, "Use up your old ammo first.""
								else
									(Print 10 28) ; "Ok, Bonds," says Mills, "here's one full clip of fresh ammo."
									(SetScore 2 68)
									(= [global215 global207] 7)
								)
							)
							((== [global215 1] [global215 2] 0)
								(Print 10 29) ; "Ok, Bonds," says Mills, "Here's two full clips of fresh ammo."
								(SetScore 2 68)
								(= [global215 1] 7)
								(= [global215 2] 7)
								(= global207 0)
							)
							((or (not [global215 1]) (not [global215 2]))
								(Print 10 28) ; "Ok, Bonds," says Mills, "here's one full clip of fresh ammo."
								(SetScore 2 68)
								(if (not [global215 global207])
									(= global207 0)
								)
								(if (== [global215 1] 0)
									(= [global215 1] 7)
								else
									(= [global215 2] 7)
								)
							)
							(else
								(Print 10 27) ; "Ken says, "Use up your old ammo first.""
							)
						)
					)
					(
						(or
							(Said 'wear/ep[<ear]')
							(Said 'drop/ep[<ear]')
							(Said 'use/ep[<ear]')
							(Said 'drop[<in]/ep')
						)
						(if (gEgo has: 15) ; ear_protectors
							(Print 10 30) ; "You should put on the ear protectors when you enter the booth."
						else
							(Print 10 31) ; "You don't have them."
						)
					)
					((or (Said 'get<off/ep[<ear]') (Said 'remove/ep[<ear]'))
						(if (== local75 0)
							(Print 10 32) ; "You're not wearing ear protectors."
						else
							(Print 10 33) ; "OK"
							(= local75 0)
						)
					)
				)
			)
		)
	)
)

(instance shooterScript of Script
	(properties)

	(method (init)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				([local5 local4] setCycle: Beg self)
			)
			(1
				([local5 local4] stopUpd:)
			)
		)
	)
)

(instance boothScript of Script
	(properties)

	(method (doit)
		(cond
			((<= (gEgo y:) 130)
				(if (gEgo mover:)
					((gEgo mover:) init: gEgo ((gEgo mover:) x:) 130)
				)
			)
			((and (>= (gEgo y:) 250) (gEgo mover:))
				((gEgo mover:) init: gEgo ((gEgo mover:) x:) 250)
			)
		)
		(cond
			((<= (gEgo x:) 94)
				(if (gEgo mover:)
					((gEgo mover:) init: gEgo 94 ((gEgo mover:) y:))
				)
			)
			((and (>= (gEgo x:) 222) (gEgo mover:))
				((gEgo mover:) init: gEgo 222 ((gEgo mover:) y:))
			)
		)
		(if (and (not (gEgo has: 0)) (<= (gEgo y:) 245)) ; hand_gun
			(gEgo setMotion: MoveTo (gEgo x:) 245)
		)
		(super doit:)
	)

	(method (changeState newState)
		(= local78 1)
		(switch (= state newState)
			(0
				(= global204 0)
				(if (not local73)
					(Load rsVIEW 70)
					(Load rsPIC 11)
					(gCurRoom drawPic: 11)
					(gCast eachElementDo: #dispose)
					(gCast eachElementDo: #delete)
					(= local16 0)
					(= local69 (Random 1 21))
					(gEgo
						setPri: 12
						posn: 160 (if (not global204) 242 else 150)
						view: 70
						setStep: 1 1
						setMotion: 0
						illegalBits: 0
						init:
						ignoreHorizon:
						ignoreActors:
						setCel: 0
						setLoop: 0
					)
					(rightArm init: signal: 26640 doit:)
					(leftArm init: signal: 26640 doit:)
					((= local14 (Prop new:))
						view: 70
						posn: 159 59
						setLoop: 2
						cycleSpeed: 3
						cel: 4
						setPri: 4
						init:
						stopUpd:
					)
					(if (>= local2 107)
						((View new:)
							view: 70
							posn: 97 59
							loop: 2
							cel: 4
							setPri: 4
							init:
							addToPic:
						)
					)
					(if (<= local2 195)
						((View new:)
							view: 70
							posn: 225 59
							loop: 2
							cel: 4
							setPri: 4
							init:
							addToPic:
						)
					)
					((= local17 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local18 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local19 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local20 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local21 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local22 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					((= local23 (View new:))
						view: 70
						posn: 160 70
						setLoop: 3
						setCel: 0
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
				else
					(= local73 0)
				)
				(= local78 0)
			)
			(1
				(HandsOff)
				(if (not local75)
					(shot number: 41 play:)
				)
				(gEgo setCel: 255 setCycle: End self)
				([local17 local16]
					posn:
						(+
							(- (/ (* (gEgo x:) 5) 2) 237)
							global103
							[local25 local69]
						)
						(+
							(- (/ (* (gEgo y:) 8) 3) 285)
							global104
							[local47 local69]
						)
				)
				(++ local16)
				(= local76 0)
				(-- [global215 global207])
				(if (== local75 0)
					(++ global209)
				)
				(if (== local69 21)
					(= local69 1)
				else
					(++ local69)
				)
			)
			(2
				(HandsOn)
				(gEgo setCel: 0)
				(if (> (gEgo y:) 208)
					(Print 10 34 #time 5 #draw) ; "You experience excruciating pain."
					(Print 10 35 #time 6 #draw) ; "As you pass out from loss of blood, you realize your error."
					(EgoDead 10 36) ; "A foot is a terrible thing to waste. Next time, draw your weapon fully before firing it."
				)
				(if (and (== [global215 global207] 6) (== local75 0))
					(Print 10 37 #draw) ; "You should protect your ears."
				)
				(if
					(or
						(and
							(>= global210 3)
							(== [global215 global207] 4)
							(== local75 0)
						)
						(== global209 6)
					)
					(RedrawCast)
					(EgoDead 10 38) ; "FORGIVE ME FOR SHOUTING, BUT FAILURE TO USE EAR PROTECTORS HAS CAUSED SEVERE HEARING IMPAIRMENT. YOUR MEAGER DISABILITY PENSION IS SORRY COMPENSATION FOR THE CONSTANT RINGING IN YOUR EARS."
				)
				(= local78 0)
			)
			(3
				(HandsOff)
				(gEgo
					yStep: (if (< global110 30) 8 else 4)
					setCel: 0
					setMotion: MoveTo 160 150 self
				)
			)
			(4
				(gEgo setStep: 1 1)
				(HandsOn)
				(= global204 1)
				(= local78 0)
			)
			(5
				(HandsOff)
				(gEgo
					yStep: (if (< global110 30) 8 else 4)
					setMotion: MoveTo 160 245 self
					setCel: 0
				)
			)
			(6
				(gEgo setStep: 1 1)
				(HandsOn)
				(= global204 0)
				(= local78 0)
			)
			(7
				(local14 startUpd: setCycle: Beg self)
			)
			(8
				(local14 cel: 0 stopUpd:)
				(if local16
					(for ((= local24 0)) (< local24 local16) ((++ local24))
						(if
							(and
								(< 132 ([local17 local24] x:) 190)
								(< 48 ([local17 local24] y:) 130)
							)
							(++ local15)
							([local17 local24] setPri: 11)
						)
					)
					(if (and (<= -6 global103 6) (<= -4 global104 4))
						(SetScore 5 67)
						(= global166 1)
					)
				)
				(= local78 0)
			)
			(9
				(Print 10 39 #draw) ; "You replace the old target with a new one from the shelf below the counter."
				(for ((= local24 0)) (< local24 7) ((++ local24))
					([local17 local24] setPri: 0 stopUpd:)
				)
				(= local15 0)
				(= local16 0)
				(= local69 (Random 1 21))
				(= local78 0)
			)
			(10
				(= local15 0)
				(= local16 0)
				(= local69 (Random 1 21))
				(= local78 0)
				(local14 setCycle: End self)
			)
			(11
				(local14 stopUpd:)
				(User canControl: 1 canInput: 1)
				(= local78 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 40])
		(if (event claimed:)
			(return)
		)
		(if (>= (gEgo y:) 240)
			(= global204 0)
		else
			(= global204 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(= temp0 (event message:))
				(event claimed: 1)
				(cond
					((== temp0 KEY_F10)
						(cond
							(global106 1)
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							((!= (gEgo yStep:) 1)
								(Print 10 40) ; "Practice your quick-draw later, Sonny; this is TARGET practice!"
							)
							((not [global215 global207])
								(Print 10 41 #time 2) ; "CLICK!"
							)
							((> local16 6)
								(Print 10 42) ; "You had better bring the target up before it's so full of holes you can't tell them apart."
							)
							((and (!= (local14 cel:) 4) (<= (gEgo y:) 208))
								(Print 10 43) ; "No fair! ANYBODY could hit it at this distance."
							)
							((not local78)
								(boothScript changeState: 1)
							)
						)
					)
					((== temp0 KEY_F8)
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							(local78
								(return)
							)
							(global204
								(self changeState: 5)
							)
							(else
								(self changeState: 3)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evSAID
				(cond
					((Said 'look[<at,around][/!*,booth,chamber]')
						(Print 10 44) ; "A shelf beneath the table holds extra targets. The target is positioned by the buttons on the left wall."
					)
					((Said 'look/bookcase')
						(Print 10 45) ; "The shelf has extra targets on it."
					)
					((Said 'hoist/9mm')
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							(global204
								(Print 10 46) ; "Your gun is raised."
							)
							(local78
								(Print 10 47) ; "Wait a while."
							)
							(else
								(= global204 1)
								(self changeState: 3)
							)
						)
					)
					((Said 'lower/9mm')
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							(local78
								(Print 10 47) ; "Wait a while."
							)
							(global204
								(= global204 0)
								(self changeState: 5)
							)
							(else
								(Print 10 48) ; "Your gun is lowered."
							)
						)
					)
					((Said 'look/bullseye,hole')
						(cond
							((== (local14 cel:) 4)
								(Print 10 49) ; "The target is too far away."
							)
							((not local16)
								(Print 10 50) ; "The target shows the accepted "kill" areas of the torso."
							)
							(local76
								(Print 10 51) ; "You should replace the target and shoot again."
							)
							((not local15)
								(Print 10 52) ; "You missed the target completely, so you cannot tell how good your gun is sighted."
							)
							((and (<= -6 global103 6) (<= -4 global104 4))
								(Print 10 53) ; "Your sights are properly aligned."
							)
							((< global104 -4)
								(Print
									(Format ; "Your gun is shooting high%s."
										@temp1
										10
										54
										(cond
											((> global103 6) { and to the right})
											((< global103 -6) { and to the left})
											(else {})
										)
									)
								)
							)
							((> global104 4)
								(Print
									(Format ; "Your gun is shooting low%s."
										@temp1
										10
										55
										(cond
											((> global103 6) { and to the right})
											((< global103 -6) { and to the left})
											(else {})
										)
									)
								)
							)
							(else
								(Print
									(Format ; "Your gun is shooting to the %s."
										@temp1
										10
										56
										(cond
											((> global103 6) {right})
											((< global103 6) {left})
										)
									)
								)
							)
						)
					)
					((Said 'look/button,wall')
						(Print 10 57) ; "There are two buttons on the wall of the booth. One is labeled 'VIEW', and the other is labeled 'BACK'."
					)
					((or (Said 'press/view,(button<view)') (Said 'view'))
						(cond
							(global204
								(Print 10 58) ; "With what? The barrel of your gun? Lower your weapon first."
							)
							(local78
								(Print 10 47) ; "Wait a while."
							)
							((== (local14 cel:) 4)
								(self changeState: 7)
							)
							(else
								(Print 10 59) ; "This is as close as the target gets."
							)
						)
					)
					(
						(or
							(Said 'press<back[/button]')
							(Said 'press/button<back')
							(Said '/back')
						)
						(cond
							((== (local14 cel:) 4)
								(Print 10 60) ; "The target is as far back as it will go."
							)
							(global204
								(Print 10 61) ; "Lower your weapon first."
							)
							((and (> local16 0) local15)
								(Print 10 62) ; "You had better replace the old target with a new one first."
							)
							(local78
								(Print 10 47) ; "Wait a while."
							)
							(else
								(self changeState: 10)
							)
						)
					)
					((Said 'press/button')
						(Print 10 63) ; "Which button do you want to push?"
					)
					(
						(or
							(Said 'get,change,replace/bullseye')
							(Said '/bullseye<new')
						)
						(cond
							((== (local14 cel:) 4)
								(Print 10 64) ; "You can't change the target while it is back there."
							)
							(global204
								(Print 10 61) ; "Lower your weapon first."
							)
							(local78
								(Print 10 47) ; "Wait a while."
							)
							(else
								(self changeState: 9)
							)
						)
					)
					((Said 'adjust/bullseye')
						(Print 10 65) ; "That would make it too easy."
					)
					((Said 'adjust/sight,9mm,windage,elevation')
						(if (not global204)
							(if (gEgo has: 0) ; hand_gun
								(User canControl: 0)
								(= local76 1)
								(rm10 setScript: sightScript)
							else
								(proc0_13) ; "You don't have your gun."
							)
						else
							(Print 10 66) ; "Lower your gun first."
						)
					)
					((Said 'exit,(walk<out)[/booth,chamber,range]')
						(if local78
							(Print 10 47) ; "Wait a while."
						else
							(gCurRoom drawPic: 10)
							(gCast eachElementDo: #dispose)
							(gCast eachElementDo: #delete)
							(rm10 setScript: rm10Script)
							(rm10Script changeState: 4)
						)
					)
					(
						(or
							(Said '(drop<on),wear,use/ep[<ear]')
							(Said 'drop[<in]/ep')
						)
						(cond
							((not (gEgo has: 15)) ; ear_protectors
								(proc0_9) ; "You don't have it."
							)
							(local75
								(Print 10 67) ; "You are wearing them."
							)
							(global204
								(Print 10 61) ; "Lower your weapon first."
							)
							(else
								(= global210 0)
								(Print 10 33) ; "OK"
								(= local75 1)
							)
						)
					)
					((Said '(get<off),remove/ep[<ear]')
						(cond
							((not local75)
								(Print 10 68) ; "You are not wearing ear protectors."
							)
							((<= (gEgo y:) 236)
								(Print 10 61) ; "Lower your weapon first."
							)
							(else
								(Print 10 33) ; "OK"
								(= local75 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance sightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((= local70 (View new:))
					view: 70
					loop: 4
					cel: 0
					posn: 160 150
					init:
				)
				((= local71 (Prop new:))
					view: 70
					loop: 5
					cel: 0
					posn: 175 144
					setPri: 0
					init:
				)
				((= local72 (Prop new:))
					view: 70
					loop: 6
					cel: 0
					setPri: 0
					posn: 146 108
					init:
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(switch (= local24 (event message:))
					(JOY_UP
						(local72
							cel:
								(if (== (local72 cel:) 0)
									(local72 lastCel:)
								else
									(- (local72 cel:) 1)
								)
							setPri: 15
						)
						(local71 setPri: 0)
						(-- global104)
					)
					(JOY_RIGHT
						(local71
							cel:
								(if (== (local71 cel:) (local71 lastCel:))
									0
								else
									(+ (local71 cel:) 1)
								)
							setPri: 15
						)
						(local72 setPri: 0)
						(++ global103)
					)
					(JOY_DOWN
						(local72
							cel:
								(if (== (local72 cel:) (- (NumCels local72) 1))
									0
								else
									(+ (local72 cel:) 1)
								)
							setPri: 12
						)
						(local71 setPri: 0)
						(++ global104)
					)
					(JOY_LEFT
						(local71
							cel:
								(if (== (local71 cel:) 0)
									(- (NumCels local71) 1)
								else
									(- (local71 cel:) 1)
								)
							setPri: 12
						)
						(local72 setPri: 0)
						(-- global103)
					)
				)
			)
			(evKEYBOARD
				(= local73 1)
				(local70 dispose:)
				(local71 dispose:)
				(local72 dispose:)
				(rm10 setScript: boothScript)
				(event claimed: 1)
				(HandsOn)
			)
		)
	)
)

(instance attendant of Prop
	(properties)

	(method (doit)
		(if (< global110 30)
			(return)
		)
		(if (gEgo inRect: 100 139 220 160)
			(localproc_1 self gEgo)
		)
	)
)

