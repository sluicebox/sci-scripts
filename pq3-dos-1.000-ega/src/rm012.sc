;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(if
		(or
			(== ((gInventory at: 7) owner:) gEgo) ; camera
			(== ((gInventory at: 39) owner:) gEgo) ; scraper
			(== ((gInventory at: 40) owner:) gEgo) ; toothpick
			(== ((gInventory at: 42) owner:) gEgo) ; sampleEnv
		)
		(return 1)
	)
)

(instance rm012 of PQRoom
	(properties
		picture 12
		east -1
		south -1
		west -1
	)

	(method (init)
		(= gUseSortedFeatures 0)
		(super init:)
		(trunk x: 140 y: 160 marked: 0 init: close:)
		(bSound play:)
		(sfx1 init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 118 0 0 319 0 319 131 278 116 294 97 269 86 290 56 274 51 249 79 232 74 207 92 176 82 164 75 120 60 110 63 100 72 68 95 66 104 45 118 22 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 179 134 71 95 121 68 225 102
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 145 171 36 128 81 101 182 139
					yourself:
				)
			setRegions: 891 894 ; station, elevator
		)
		(gunLockerDoor init: hide:)
		(gunLockerProp init: hide:)
		(door1 init:)
		(door2 init:)
		(eviDoor init:)
		(policeSign init:)
		(lightSwitch init:)
		(pCarDoor approachVerbs: 3 init:) ; Do
		(uCarDoor approachVerbs: 3 init:) ; Do
		(pCarTrunk approachVerbs: 3 init:) ; Do
		(uCarTrunk approachVerbs: 3 init:) ; Do
		(gunLocker init:)
		(uCar1 init:)
		(uCar2 init:)
		(uCar3 init:)
		(car1 init:)
		(car2 init:)
		(car3 init:)
		(gAddToPics add: uCar1 uCar2 uCar3 car1 car2 car3 doit:)
		(garageRoom init:)
		(LoadMany rsVIEW 1 5)
		(if (and (>= gDay 2) (!= gPrevRoomNum 10))
			(= global134 1)
		)
		(gEgo view: (if (> gDay 1) 5 else 1) setStep: 3 2)
		(switch gPrevRoomNum
			(13
				(gEgo posn: 270 69)
				(door1 posn: 249 70)
				(door2 posn: 277 79)
				(HandsOff)
				(self setScript: fromBooking)
			)
			(14
				(gEgo posn: 181 65)
				(eviDoor cel: 4)
				(self setScript: fromEvidence)
			)
			(10
				(HandsOff)
				(if (> gDay 1)
					(gEgo
						normal: 0
						view: 17
						loop: 4
						cel: 0
						posn: 94 147
						setPri: 14
					)
					((= local1 uCarDoor) setPri: 15)
				else
					(gEgo
						normal: 0
						view: 16
						loop: 4
						cel: 0
						posn: 130 113
						setPri: 7
					)
					((= local1 pCarDoor) setPri: 9)
				)
				(if (and (IsFlag 85) (== global134 1))
					(pat posn: 135 121 setCycle: Walk init:)
				)
				(if (not (IsFlag 85))
					(= local3 1)
				)
				(self setScript: getOutCar)
			)
			(25
				(HandsOff)
				(if
					(OneOf
						(gEgo view:)
						0
						1
						3
						8
						10
						11
						12
						16
						124
						125
						127
						165
						315
						333
					)
					(gEgo normal: 0 view: 16 loop: 4 cel: 0 posn: 94 147)
					((= local1 uCarDoor) setPri: 15)
				else
					(gEgo
						normal: 0
						view: 17
						loop: 4
						cel: 0
						posn: 130 113
						setPri: 7
					)
					((= local1 pCarDoor) setPri: 9)
				)
				(self setScript: getOutCar)
			)
			(else
				(HandsOff)
				(gEgo setPri: 1 posn: 87 56)
				(self setScript: global110)
			)
		)
		(gEgo init:)
		(Load rsSCRIPT 699)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(HandsOff)
				(self setScript: enterBooking)
			)
			((and (IsFlag 5) (not (gCast contains: suspect)))
				(HandsOff)
				(self setScript: getNut)
			)
			((and (IsFlag 16) (not (gCast contains: drunk)))
				(HandsOff)
				(self setScript: getDrunk)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(SetFlag 85)
		(super dispose:)
		(DisposeScript 881)
		(DisposeScript 894)
		(DisposeScript 699)
	)
)

(instance enterBooking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 ignoreActors: 1)
				(sfx1 number: 121 play:)
				(door1 setMotion: MoveTo 249 70)
				(door2 setMotion: MoveTo 277 79 self)
			)
			(1
				(door1 stopUpd:)
				(door2 stopUpd:)
				(if (or (IsFlag 5) (IsFlag 16))
					(gEgo setMotion: PolyPath 262 92 self)
				else
					(gEgo ignoreActors: 0 setMotion: PolyPath 270 69 self)
					(+= state 2)
				)
			)
			(2
				(Face gEgo pCarDoor)
				(Say gEgo 12 0 108) ; "Come on. This way."
				(if (IsFlag 5)
					(suspect setMotion: MoveTo 280 61 self)
				else
					(drunk
						setPri: -1
						setLoop: 2
						setMotion: PolyPath 280 61 self
					)
				)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo ignoreActors: 0 setMotion: PolyPath 270 69 self)
			)
			(4
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance fromBooking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 246 96 self)
			)
			(2
				(sfx1 number: 122 play:)
				(door1 setMotion: MoveTo 263 76 self)
				(door2 setMotion: MoveTo 264 76 self)
			)
			(3)
			(4
				(door1 stopUpd:)
				(door2 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lockerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 228 82 self)
			)
			(1
				(gunLockerProp show:)
				(gunLockerDoor
					cel: (if (== ((gInventory at: 1) owner:) 12) 0 else 1) ; gun
					show:
				)
				(= cycles 1)
			)
			(2
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterEvidence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 173 77 self)
			)
			(1
				(sfx1 number: 907 loop: 1 play:)
				(eviDoor setCycle: End self)
			)
			(2
				(eviDoor stopUpd:)
				(gEgo setMotion: MoveTo 181 65 self)
			)
			(3
				(gCurRoom newRoom: 14)
			)
		)
	)
)

(instance fromEvidence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 165 86 self)
			)
			(2
				(eviDoor setCycle: Beg self)
			)
			(3
				(sfx1 number: 908 loop: 1 play:)
				(eviDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== global134 1)
						(== local1 uCarDoor)
						(not local3)
						(>= gDay 2)
					)
					(if (== gPrevRoomNum 10)
						(self setScript: patEnterCar2 self)
					else
						(pat setCycle: Walk setPri: 1 posn: 87 56 init:)
						(self setScript: patEnterCar self)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if (and (== global134 1) (== local1 uCarDoor) (>= gDay 2))
					(Face pat gEgo)
				)
				(sfx1 number: 900 loop: 1 play:)
				(local1 setCycle: End self)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(switch local1
							(pCarDoor 122)
							(else 85)
						)
						(switch local1
							(pCarDoor 115)
							(else 149)
						)
						self
				)
			)
			(3
				(gEgo
					normal: 0
					view:
						(if
							(OneOf
								(gEgo view:)
								0
								1
								3
								8
								10
								11
								12
								16
								124
								125
								127
								165
								315
								333
							)
							16
						else
							17
						)
					loop: 1
					cel: 0
					posn: (+ (gEgo x:) 6) (- (gEgo y:) 2)
					setCycle: End self
				)
			)
			(4
				(local1
					setPri:
						(switch local1
							(pCarDoor 9)
							(else 15)
						)
					setCycle: Beg self
				)
			)
			(5
				(sfx1 number: 901 loop: 1 play: self)
			)
			(6
				(if local2
					(gCurRoom newRoom: 10)
				else
					(gCurRoom newRoom: 25)
				)
			)
		)
	)
)

(instance getOutCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(sfx1 number: 900 loop: 1 play:)
				(local1 setCycle: End self)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normal: 1
					view: (if (> gDay 1) 5 else 1)
					setCycle: Walk
					setPri: -1
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo (+ (gEgo x:) 2) (+ (gEgo y:) 7) self
				)
			)
			(4
				(local1
					setPri: (if (== local1 uCarDoor) 10 else 7)
					setCycle: Beg self
				)
			)
			(5
				(sfx1 number: 901 loop: 1 play:)
				(if (and (IsFlag 85) (== global134 1) (!= gPrevRoomNum 25))
					(self setScript: patExitCar self)
				else
					(= cycles 1)
				)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getNut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 185 85 self)
			)
			(1
				(sfx1 number: 900 loop: 1 play:)
				(gEgo loop: 4)
				(suspect setCycle: End self init:)
			)
			(2
				(suspect
					view: 310
					setLoop: -1
					setCycle: Walk
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					posn: (+ (suspect x:) 6) (suspect y:)
					ignoreActors: 1
					setMotion: MoveTo 208 84 self
				)
			)
			(3
				(= global134 0)
				(suspect loop: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getDrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 172 83 self)
			)
			(1
				(sfx1 number: 900 loop: 1 play:)
				(gEgo loop: 4)
				(drunk setCycle: End self init:)
			)
			(2
				(drunk
					view: 204
					setLoop: 2
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setStep: 3 2
					setCycle: Walk
					setMotion: MoveTo 195 84 self
				)
			)
			(3
				(drunk setPri: 4)
				(= global134 0)
				(drunk loop: 4 ignoreActors: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance patEnterCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx1 number: 919 loop: 1 play:)
				(global112 setCycle: End self)
			)
			(1
				(pat setMotion: MoveTo 108 72 self)
			)
			(2
				(global112 setCycle: Beg self)
			)
			(3
				(sfx1 number: 920 loop: 1 play:)
				(= save1 1)
				(global112 stopUpd:)
				(if (not (= local4 (Random 0 3)))
					(Say pat 12 1) ; "Wait for me, Sonny."
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat setPri: -1 setMotion: PolyPath 135 121 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance patEnterCar2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pat setCycle: Walk init:)
				(= save1 1)
				(if (not (= local4 (Random 0 3)))
					(Say pat 12 1) ; "Wait for me, Sonny."
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat setMotion: PolyPath 135 121 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance patExitCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
				(door1 startUpd:)
				(door2 startUpd:)
				(eviDoor startUpd:)
			)
			(1
				(= save1 1)
				(Say pat 12 2) ; "I'll catch up with you. Got to run to my car."
				(= seconds 4)
			)
			(2
				(door1 stopUpd:)
				(door2 stopUpd:)
				(eviDoor stopUpd:)
				(local1 stopUpd:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat setPri: -1 setMotion: PolyPath 265 240 self)
			)
			(3
				(if (== gDay 2)
					(SetFlag 229)
				)
				(pat dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance suspect of Actor
	(properties
		x 176
		y 93
		description {suspect}
		lookStr {He has a wild look in his eye.}
		view 200
	)
)

(instance drunk of Actor
	(properties
		x 176
		y 93
		description {suspect}
		lookStr {He is still wobbling.}
		view 203
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 12 3) ; "This is not the appropiate place to search a suspect."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door1 of Actor
	(properties
		x 263
		y 76
		description {Booking Doors}
		lookStr {The automatic doors lead to Prisoner Booking and the Jail.}
		view 202
		signal 22529
		cycleSpeed 9
		illegalBits 0
		moveSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 12 4) ; "These doors are sensor activated."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door2 of Actor
	(properties
		x 264
		y 76
		description {Booking Doors}
		lookStr {The automatic doors lead to Prisoner Booking and the Jail.}
		view 202
		cel 1
		signal 22529
		cycleSpeed 9
		illegalBits 0
		moveSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 12 4) ; "These doors are sensor activated."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eviDoor of Prop
	(properties
		x 167
		y 21
		description {Evidence Doors}
		lookStr {That door leads to Evidence Lockup and Lab Analysis.}
		view 202
		loop 1
		signal 16385
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((trunk showing:) 0)
					((not (IsFlag 18))
						(Print 12 5) ; "The door is locked. I guess the Evidence Officer must be out to lunch."
					)
					((or (IsFlag 5) (IsFlag 16))
						(Print 12 6) ; "You really should do something with the prisoner first."
					)
					((localproc_0)
						(Print 12 7) ; "You need to put the field equipment back into the trunk first."
					)
					(else
						(HandsOff)
						(gCurRoom setScript: enterEvidence)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunLocker of Feature
	(properties
		x 220
		y 45
		description {Gun Locker}
		onMeCheck 256
		lookStr {The lockers are for storing your weapons before entering the jail.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not (trunk showing:))
					(HandsOff)
					(gCurRoom setScript: lockerScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunLockerDoor of Prop
	(properties
		x 145
		y 30
		description {Locker Door}
		view 201
		loop 1
		cel 1
		priority 14
		signal 20497
	)

	(method (doit)
		(if (and (not (& (gEgo onControl: 1) $4000)) local0)
			(if (== ((gInventory at: 1) owner:) 12) ; gun
				(gEgo get: 13) ; gunKey
			)
			(= local0 0)
			(gunLockerDoor hide:)
			(gunLockerProp hide:)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((gInventory at: 1) owner:) 12) ; gun
					(Print 12 8) ; "Your gun is in that locker."
				else
					(Print 12 9) ; "A locker door."
				)
			)
			(3 ; Do
				(switch (self cel:)
					(0
						(Print 12 10) ; "It is locked."
					)
					(1
						(self cel: 2 forceUpd:)
						(sfx1 number: 905 loop: 1 play:)
						(Animate (gCast elements:) 0)
						(Print 12 11) ; "You open the locker."
					)
					(2
						(sfx1 number: 906 loop: 1 play:)
						(self cel: 1 forceUpd:)
						(Print 12 12) ; "You close the locker."
					)
					(3
						(Print 12 13) ; "You take your gun."
						(gEgo put: 13 12) ; gunKey
						(gEgo get: 1) ; gun
						(self cel: 2 forceUpd:)
						(SetScore 113 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(13 ; gunKey
						(sfx1 number: 905 loop: 1 play:)
						(self cel: 3 forceUpd:)
						(Print 12 14) ; "You unlock the locker."
						(gEgo put: 13 12) ; gunKey
					)
					(1 ; gun
						(if (== (self cel:) 2)
							(gEgo get: 13) ; gunKey
							(gEgo put: 1 12) ; gun
							(self cel: 0 forceUpd:)
							(sfx1 number: 906 loop: 1 play:)
							(Animate (gCast elements:) 0)
							(Print 12 15) ; "You put your gun in the locker, lock the door, and take the key."
							(SetScore 109 2)
							(gunLockerProp hide:)
							(gunLockerDoor hide:)
							(= local0 0)
						else
							(Print 12 16) ; "Why don't open it first?"
						)
					)
					(16 ; nightStick
						(Print 12 17) ; "It's too long to fit in the gun locker."
					)
					(else
						(Print 12 18) ; "There's no regulation against carrying that into the jail."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunLockerProp of Prop
	(properties
		x 161
		y 95
		description {Locker Door}
		lookStr {The lockers are for storing your weapons before entering the jail.}
		view 201
		priority 13
		signal 20497
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 12 19) ; "That locker is already taken."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; gunKey
						(Print 12 20) ; "Your key doesn't open that locker."
					)
					(1 ; gun
						(Print 12 21) ; "Why don't you open it first?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance policeSign of Feature
	(properties
		x 305
		y 85
		description {sign}
		onMeCheck 32
		lookStr {The sign reads 'Lytton County Police Department'.}
	)
)

(instance garageRoom of Feature
	(properties
		sightAngle 360
		lookStr {You're in the underground garage at the Lytton County Police Department's new building.}
	)
)

(instance car1 of PicView
	(properties
		x 97
		y 101
		description {Patrol Car}
		lookStr {The marked patrol car is used by uniformed officers on duty.}
		view 209
		signal 16384
	)
)

(instance car2 of PicView
	(properties
		x 130
		y 121
		description {Patrol Car}
		lookStr {The marked patrol car is used by uniformed officers on duty.}
		view 209
		cel 1
		priority 7
		signal 16384
	)
)

(instance car3 of PicView
	(properties
		x 177
		y 121
		description {Patrol Car}
		lookStr {The marked patrol car is used by uniformed officers on duty.}
		view 209
		cel 2
		priority 7
		signal 16384
	)
)

(instance pCarDoor of Prop
	(properties
		x 113
		y 89
		description {patrol car door}
		approachX 132
		approachY 125
		_approachVerbs 3
		lookStr {The marked patrol car is used by uniformed officers on duty.}
		view 209
		loop 1
		priority 7
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(= local1 self)
				(cond
					((or (IsFlag 5) (IsFlag 16))
						(Print 12 6) ; "You really should do something with the prisoner first."
					)
					(
						(not
							(OneOf
								(gEgo view:)
								0
								1
								3
								8
								10
								11
								12
								16
								124
								125
								127
								165
								315
								333
							)
						)
						(= local2 0)
						(HandsOff)
						(gCurRoom setScript: getInCar)
					)
					((localproc_0)
						(Print 12 22) ; "You need to put your equipment back in the trunk."
					)
					(
						(and
							(== gDay 1)
							(or
								(not (IsFlag 55))
								(and (IsFlag 207) (not (IsFlag 206)))
							)
						)
						(Print 12 23) ; "Now where do you think you are going???"
					)
					(else
						(= local2 1)
						(HandsOff)
						(gCurRoom setScript: getInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCarTrunk of Feature
	(properties
		description {patrol car trunk}
		onMeCheck 2048
		approachX 206
		approachY 122
		_approachVerbs 3
		lookStr {The marked patrol car is used by uniformed officers on duty.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((or (IsFlag 5) (IsFlag 16))
						(Print 12 6) ; "You really should do something with the prisoner first."
					)
					(
						(not
							(OneOf
								(gEgo view:)
								0
								1
								3
								8
								10
								11
								12
								16
								124
								125
								127
								165
								315
								333
							)
						)
						(Print 12 24) ; "You're trying to be inconspicuous. Leave the marked car for uniformed officers."
					)
					(else
						(trunk marked: 1 open:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uCar1 of PicView
	(properties
		x 62
		y 135
		description {Unmarked Car}
		lookStr {The unmarked department car is used by non-uniformed officers on duty.}
		view 209
		loop 2
		signal 16384
	)
)

(instance uCar2 of PicView
	(properties
		x 95
		y 155
		description {Unmarked Car}
		lookStr {The unmarked department car is used by non-uniformed officers on duty.}
		view 209
		loop 2
		cel 1
		priority 10
		signal 16384
	)
)

(instance uCar3 of PicView
	(properties
		x 142
		y 155
		description {Unmarked Car}
		lookStr {The unmarked department car is used by non-uniformed officers on duty.}
		view 209
		loop 2
		cel 2
		priority 10
		signal 16384
	)
)

(instance uCarDoor of Prop
	(properties
		x 75
		y 128
		description {unmarked car door}
		approachX 96
		approachY 159
		_approachVerbs 3
		lookStr {The unmarked department car is used by non-uniformed officers on duty.}
		view 209
		loop 3
		priority 10
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(= local1 self)
				(cond
					((or (IsFlag 5) (IsFlag 16))
						(Print 12 6) ; "You really should do something with the prisoner first."
					)
					(
						(OneOf
							(gEgo view:)
							0
							1
							3
							8
							10
							11
							12
							16
							124
							125
							127
							165
							315
							333
						)
						(= local2 0)
						(HandsOff)
						(gCurRoom setScript: getInCar)
					)
					((localproc_0)
						(Print 12 22) ; "You need to put your equipment back in the trunk."
					)
					((not (IsFlag 85))
						(Print 12 25) ; "Don't you think you should check in at Homicide first?"
					)
					(else
						(HandsOff)
						(= local2 1)
						(gCurRoom setScript: getInCar)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uCarTrunk of Feature
	(properties
		x 152
		y 134
		description {unmarked car trunk}
		onMeCheck 4096
		approachX 171
		approachY 159
		_approachVerbs 3
		lookStr {The unmarked department car is used by non-uniformed officers on duty.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((or (IsFlag 5) (IsFlag 16))
						(Print 12 6) ; "You really should do something with the prisoner first."
					)
					(
						(OneOf
							(gEgo view:)
							0
							1
							3
							8
							10
							11
							12
							16
							124
							125
							127
							165
							315
							333
						)
						(Print 12 26) ; "The unmarked car is reserved for officers in plain clothes."
					)
					(else
						(trunk marked: 0)
						(trunk open:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 264
		y 76
		description {Pat}
		lookStr {Pat Morales, your partner.}
		view 20
	)
)

(instance bSound of Sound
	(properties
		flags 1
		number 120
		loop -1
	)
)

(instance sfx1 of Sound
	(properties
		flags 1
	)
)

(instance lightSwitch of Feature
	(properties
		x 220
		y 45
		description {Gun Locker}
		onMeCheck 16
		lookStr {It's the light switch for the garage.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 12 27) ; "You need one of those funny-looking keys."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

