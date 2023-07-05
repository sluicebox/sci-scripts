;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 885)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use RandCycle)
(use PolyPath)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	drunk 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance drunk of Rgn
	(properties)

	(method (init)
		(LoadMany rsVIEW 328 25 329 204 326 327 330 331 334)
		(thePlate init:)
		(suspect posn: -100 100 init: stopUpd:)
		(theCar init:)
		(gAddToPics add: thePlate theCar doit:)
		(SetFlag 14)
		(cond
			((== ((gInventory at: 2) owner:) 885) ; handcuff
				(= local1 1)
				(= local2 2)
				(= local3 1)
				(suspect
					view: 204
					setLoop: 2
					setPri: -1
					posn: 250 129
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo moveSpeed:)
				)
				(puke init:)
				(drunkMusic play:)
			)
			((== global113 699)
				(= local2 1)
			)
		)
		(= local0 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(= global113 599)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((and (== global114 500) (not (IsFlag 16)))
				(= global114 0)
				(HandsOff)
				(gCurRoom setScript: drunkInCar)
			)
		)
	)
)

(instance drunkScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 214 138 self)
			)
			(1
				(Face gEgo theCar self)
			)
			(2
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 885 0) ; "Sir, you seem to be driving a bit erratically.  I need to see your driver's license."
				(= seconds 6)
			)
			(3
				(= save1 1)
				(sonnyInset dispose:)
				(Print 885 1 #dispose #at 20 20) ; "As he fumbles through his wallet trying to find his license, you think to yourself..."
				(= seconds 6)
			)
			(4
				(= save1 1)
				(Print 885 2 #dispose #at 20 20) ; "It's obvious by looking, this man is inebriated."
				(= seconds 5)
			)
			(5
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 885 3) ; "Have you been drinking, sir?"
				(= seconds 4)
			)
			(6
				(= save1 1)
				(sonnyInset dispose:)
				(dInset init:)
				(Say dInset 885 4) ; "Juss acouple"
				(= seconds 3)
			)
			(7
				(= save1 1)
				(Say dInset 885 5) ; "Shhaayy *hiccup* Occifer, whaddaya shhaayy we polissshhh off abodola bourbon to-togethherr?"
				(= seconds 8)
			)
			(8
				(= save1 1)
				(suspectMouth cel: 0 setCycle: 0)
				(Print 885 6 #dispose #at 20 20) ; "You think to yourself... "If I continue inhaling the pollution this man is exhaling, my lungs will be worse off than the ozone layer.""
				(= seconds 10)
			)
			(9
				(= local2 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(= global113 699)
				(self dispose:)
			)
		)
	)
)

(instance drunk2Script of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 119 2)
				(= save1 1)
				(dInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 885 7) ; "Would you please step out of the car, sir, and perform a field sobriety test?"
				(= seconds 8)
			)
			(1
				(= save1 1)
				(sonnyInset dispose:)
				(dInset init:)
				(Say dInset 885 8) ; "What..*hic* .. ever you shhaayy ocifer."
				(= seconds 4)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(dInset dispose:)
				(gEgo setMotion: PolyPath 312 135)
				(drunkMusic play:)
				(openCarDoor play:)
				(suspect
					view: 326
					loop: 0
					cel: 0
					posn: 173 120
					cycleSpeed: (gEgo moveSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					ignoreActors: 1
					setCycle: End self
					init:
				)
			)
			(3
				(closeCarDoor play:)
				(suspect
					view: 327
					setLoop: 2
					posn: 185 130
					setCycle: SyncWalk
					setMotion: PolyPath 265 115 self
				)
			)
			(4
				(suspect setLoop: 1 setMotion: MoveTo 290 133 self)
			)
			(5
				(Face gEgo suspect)
				(suspect
					view: 329
					loop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: Fwd
					ignoreActors: 0
				)
				(= save1 1)
				(suspectEye dispose:)
				(dInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 885 9) ; "Sir! I want you to follow my finger with your eyes from side to side without moving your head."
				(= seconds 5)
			)
			(6
				(= save1 1)
				(sonnyInset dispose:)
				(Print 885 10 #dispose #at 10 10) ; ""Okay" he says."
				(dInset loop: 3 posn: 260 143 init:)
				(suspectMouth dispose:)
				(suspectEye init:)
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(finger init:)
				(gTheIconBar enable: 2)
				(User canInput: 1)
			)
			(8
				(= save1 1)
				(dInset dispose:)
				(finger dispose:)
				(suspectEye dispose:)
				(Print 885 11 #dispose #at 20 20) ; "Holy smokes!" you think to yourself, "this poor guy is plowed!"
				(= seconds 6)
			)
			(9
				(= save1 1)
				(Print 885 12 #dispose #at 20 20) ; "Obviously, this man is too drunk to be driving."
				(= seconds 4)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(suspect
					view: 329
					loop: 0
					cel: 0
					cycleSpeed: (gEgo cycleSpeed:)
					setCycle: CT 12 1 self
				)
				(pukeSound play:)
			)
			(11
				(gEgo normal: 0 view: 330 loop: 0)
				(suspect setCycle: End self)
			)
			(12
				(puke init:)
				(gEgo loop: 1 setCycle: End self)
			)
			(13
				(Print 885 13 #time 2) ; "YUCK!"
				(suspect setLoop: 2 cycleSpeed: 10 setCycle: Fwd)
				(gEgo normal: 1 view: 1 loop: 5 setCycle: Walk)
				(= gUseSortedFeatures local0)
				(= local3 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fingerMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (suspectEye cel:) 4)
					(suspectEye cycleSpeed: 6 setCycle: CelOsc 3 4 6 self)
				else
					(suspectEye cycleSpeed: 6 setCycle: CelOsc 0 1 6 self)
				)
			)
			(1
				(if (== local5 4)
					(drunk2Script cycles: 1)
				)
				(self dispose:)
			)
		)
	)
)

(class CelOsc of Cycle
	(properties
		howManyCycles -1
		endCel 0
		startCel 0
	)

	(method (init param1 param2 param3 param4 param5)
		(= startCel param2)
		(= endCel param3)
		(if (>= argc 2)
			(= howManyCycles param4)
			(if (>= argc 3)
				(= caller param5)
			)
		)
		(super init: param1)
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) endCel) (< temp0 startCel))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(if howManyCycles
			(client cel: (self nextCel:))
			(if (> howManyCycles 0)
				(-- howManyCycles)
			)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

(instance cuffHim of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(dInset dispose:)
				(if (!= (suspect view:) 331)
					(suspect
						view: 327
						setLoop: 0
						setCycle: Walk
						cycleSpeed: 8
						setPri: 11
						setMotion: MoveTo 256 129 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(= save1 1)
				(dInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 885 14) ; "Sir, I have to take you into custody for driving under the influence."
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(if (!= (suspect view:) 331)
					(suspect
						view: 331
						posn: 249 127
						setCycle: End self
						setPri: 13
						cel: 6
						loop: 1
					)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo ignoreActors: 1 setMotion: PolyPath 265 121 self)
			)
			(4
				(gEgo setMotion: MoveTo 259 130 self)
			)
			(5
				(Face gEgo suspect self)
			)
			(6
				(gEgo hide:)
				(suspect
					view: 331
					setLoop: 2
					cel: 0
					setCycle: CT 4 1 self
					posn: 250 129
					cycleSpeed: 10
				)
			)
			(7
				(handcuffSound play:)
				(= cycles 1)
			)
			(8
				(suspect setCycle: End self)
			)
			(9
				(gEgo posn: 259 124 loop: 2 ignoreActors: 1 show:)
				(suspect
					view: 204
					setLoop: 2
					setPri: -1
					cycleSpeed: (gEgo moveSpeed:)
				)
				(SetFlag 45)
				(gEgo put: 2 885) ; handcuff
				(SetScore 120 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance searchDrunk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 1
					view: 1
					loop: 5
					setCycle: Walk
					setMotion: PolyPath 312 135 self
				)
			)
			(1
				(= save1 1)
				(dInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 885 15) ; "Please place your hands on the hood of the car."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(suspect
					view: 327
					setLoop: 0
					setCycle: Walk
					setPri: 11
					cycleSpeed: 8
					moveSpeed: 8
					setMotion: MoveTo 256 129 self
				)
			)
			(3
				(suspect
					view: 331
					posn: 249 127
					setCycle: End self
					setPri: 13
					cel: 6
					loop: 1
				)
			)
			(4
				(gEgo setMotion: PolyPath 265 121 self)
			)
			(5
				(gEgo normal: 0 view: 331 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(gEgo normal: 1 view: 1 loop: 5 setCycle: Walk)
				(SetScore 121 5)
				(SetFlag 14)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drunkInCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 305 145 self)
			)
			(1
				(= save1 1)
				(dInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 885 16) ; "Please step over to the patrol car."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(suspect
					view: 204
					setLoop: 1
					cycleSpeed: (gEgo moveSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setCycle: Walk
					setMotion: MoveTo 295 135 self
				)
			)
			(3
				(gEgo setLoop: 5 setMotion: PolyPath 124 191)
				(suspect setPri: 15 setLoop: 0 setMotion: PolyPath 116 210 self)
			)
			(4
				(suspect setMotion: PolyPath 96 210 self)
			)
			(5
				(gEgo setLoop: -1)
				(openCarDoor play:)
				(global110 setPri: 14 setCycle: End self)
			)
			(6
				(suspect setLoop: 2 setMotion: PolyPath 116 210 self)
			)
			(7
				(suspect setMotion: MoveTo 110 210 self)
			)
			(8
				(suspect view: 334 cel: 0 y: 243 z: 43 setCycle: End self)
			)
			(9
				(global110 setPri: 15 setCycle: Beg self)
				(suspect setPri: 14)
			)
			(10
				(closeCarDoor play:)
				(gEgo setMotion: MoveTo 182 187 self)
			)
			(11
				(global110 setPri: 14)
				(= global113 0)
				(= global134 3)
				(SetFlag 16)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance markScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 885 17) ; "Sir... based on the test I've given you (and the puke all over my shoes)..."
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say sonnyInset 885 18) ; "... it is obvious that you are intoxicated and in no condition to drive. I'm going to have to place you under arrest."
				(= seconds 8)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dInset of View
	(properties
		x 267
		y 37
		view 328
		priority 15
		signal 16401
	)

	(method (dispose)
		(finger dispose:)
		(suspectMouth dispose:)
		(suspectEye dispose:)
		(super dispose:)
	)

	(method (init)
		(suspectMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(self stopUpd: 1)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (== local2 1)
					(HandsOff)
					(gCurRoom setScript: drunk2Script)
					(= local2 2)
				else
					(Print 885 19) ; "The drunk just sways in front of you."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suspectMouth of Prop
	(properties
		view 328
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (== local2 1)
					(HandsOff)
					(= local2 2)
					(gCurRoom setScript: drunk2Script)
				else
					(Print 885 20) ; "The intoxicated gentleman just weaves in front of you."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suspectEye of Prop
	(properties
		x 264
		y 93
		view 328
		loop 2
		cel 2
		priority 15
		signal 16400
	)
)

(instance finger of Actor
	(properties
		x 264
		y 200
		z 60
		view 328
		loop 4
		priority 15
		signal 18449
		xStep 2
	)

	(method (doit)
		(if (and (not (gEgo inRect: 302 124 317 138)) (not (& signal $0080)))
			(self hide:)
			(dInset hide:)
			(suspectEye hide:)
		)
		(if (and (gEgo inRect: 302 124 317 138) (& signal $0080))
			(self show:)
			(dInset show:)
			(suspectEye show:)
		)
		(if
			(and
				(not script)
				(InRect
					(+ (dInset nsLeft:) 10)
					(dInset nsTop:)
					(- (dInset nsRight:) 12)
					(dInset nsBottom:)
					gMouseX
					gMouseY
				)
			)
			(gGame setCursor: 69)
			(self x: gMouseX)
			(cond
				((< (finger x:) 225)
					(suspectEye cel: 4)
					(if (!= local4 2)
						(= local4 2)
						(++ local5)
						(self setScript: fingerMove)
					)
				)
				((< (finger x:) 252)
					(suspectEye cel: 3)
				)
				((> (finger x:) 295)
					(suspectEye cel: 0)
					(if (!= local4 1)
						(= local4 1)
						(++ local5)
						(self setScript: fingerMove)
					)
				)
				((> (finger x:) 266)
					(suspectEye cel: 1)
				)
				(else
					(suspectEye cel: 2)
				)
			)
		else
			(gGame setCursor: 20)
		)
		(super doit:)
	)
)

(instance theCar of PicView
	(properties
		x 209
		y 161
		description {car}
		lookStr {The suspect's car.}
		view 335
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(cond
					((== local2 0)
						(HandsOff)
						(gCurRoom setScript: drunkScript)
					)
					((== local2 1)
						(= local2 2)
						(HandsOff)
						(gCurRoom setScript: drunk2Script)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePlate of PicView
	(properties
		x 164
		y 249
		z 100
		description {plate}
		lookStr {The plate reads - 01923}
		view 335
		cel 1
		priority 2
		signal 16400
	)
)

(instance suspect of Actor
	(properties
		lookStr {He looks to be having a little trouble walking.}
		view 326
	)

	(method (doit)
		(super doit:)
		(if (and (== view 329) (== loop 2))
			(if (< y (gEgo y:))
				(self setPri: (- (gEgo priority:) 1))
			else
				(self setPri: (+ (gEgo priority:) 1))
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== view 334)
						(Print 885 21) ; "He's sitting quietly in the patrol car."
					)
					((== view 331)
						(Print 885 22) ; "It's a good thing he has a car to lean on."
					)
					(else
						(Print lookStr)
					)
				)
			)
			(3 ; Do
				(cond
					((IsFlag 16) 0)
					((== ((gInventory at: 2) owner:) 885) ; handcuff
						(HandsOff)
						(gCurRoom setScript: drunkInCar)
					)
					((not local1)
						(HandsOff)
						(= local1 1)
						(gCurRoom setScript: searchDrunk)
					)
					((== ((gInventory at: 2) owner:) 13) ; handcuff
						(Print 885 23) ; "Damn" you think to yourself, "I left my cuffs back at the Booking Office."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(2 ; handcuff
						(HandsOff)
						(gCurRoom setScript: cuffHim)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(if (== local5 4)
					(= local5 0)
					(HandsOff)
					(gCurRoom setScript: markScript)
				else
					(Print 885 24) ; "Don't bother. He's too incoherent."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sonnyMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
		(sonnyEyes setScript: 0 dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance puke of Prop
	(properties
		x 312
		y 133
		lookStr {Yuck!}
		view 329
		loop 1
		priority 1
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 885 25) ; "You're one sick puppy, Bonds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drunkMusic of Sound
	(properties
		number 292
		loop -1
	)
)

(instance pukeSound of Sound
	(properties
		number 297
	)
)

(instance handcuffSound of Sound
	(properties
		number 918
	)
)

(instance openCarDoor of Sound
	(properties
		number 900
	)
)

(instance closeCarDoor of Sound
	(properties
		number 901
	)
)

