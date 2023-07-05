;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm057 0
)

(local
	local0
	local1
)

(instance rm057 of PQRoom
	(properties
		picture 57
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 219 77 207 71 166 86 150 83 80 103 83 114 78 124 36 134 49 164 75 152 83 137 85 124 108 126 124 144 129 162 213 161 288 120 227 81 319 0 319 189 0 189 0 0 303 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 196 87 234 114 164 139 129 114
					yourself:
				)
		)
		(mSound play:)
		(LoadMany rsSOUND 937 707)
		(shadow init:)
		(stairs init:)
		(shelves init:)
		(table init:)
		(barrels init:)
		(theRoom init:)
		(if ((gInventory at: 1) state:) ; gun
			(gEgo
				normal: 0
				view: 605
				setLoop: 1
				setStep: 3 2
				posn: 242 56
				init:
			)
		else
			(gEgo
				normal: 0
				view: 605
				setLoop: 0
				setStep: 3 2
				posn: 242 56
				init:
			)
		)
		(HandsOff)
		(self setScript: downStairs)
		(super init:)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $0004)
				(gCurRoom newRoom: 56)
			)
			((and (not local0) (& temp0 $0001))
				(= local0 1)
			)
			((and local0 (& temp0 $0002) (not (gCast contains: badGuy)))
				(badGuy init: setScript: crookScript)
			)
			((and (gEgo normal:) ((gInventory at: 1) state:)) ; gun
				(HandsOff)
				(gCurRoom setScript: drawGunScript)
			)
			(
				(and
					(not (gEgo normal:))
					(not ((gInventory at: 1) state:)) ; gun
					(not local1)
				)
				(HandsOff)
				(gCurRoom setScript: holsterGunScript)
			)
		)
		(super doit:)
	)
)

(instance drawGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 589
					loop: (gEgo cel:)
					setCycle: Walk
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance holsterGunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
				(gEgo normal: 1 view: 4 setCycle: Walk)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance downStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shadow setCycle: End)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo posn: 231 64 cel: 0 setCycle: End self)
			)
			(2
				(if ((gInventory at: 1) state:) ; gun
					(gEgo
						view: 589
						setCycle: Walk
						setLoop: -1
						loop: 1
						posn: 222 78
					)
				else
					(gEgo
						normal: 1
						view: 4
						setCycle: Walk
						setLoop: -1
						loop: 1
						posn: 222 78
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drawScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(gEgo
					normal: 0
					view: 9
					loop: 5
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(2
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance crookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX hold: 1 play:)
				(User canControl: 0)
				(gEgo setMotion: 0)
				(Face gEgo badGuy self)
			)
			(1
				(badGuy setCycle: End self)
			)
			(2
				(gunShotSound play:)
				(bulletHole setCycle: End init:)
				(if ((gInventory at: 1) state:) ; gun
					(= cycles 10)
				else
					(= cycles 1)
				)
			)
			(3
				(= local1 1)
				(badGuy loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(badGuy cel: 4)
				(gunShotSound play:)
				(= cycles 1)
			)
			(5
				(HandsOff)
				(gEgo
					normal: 0
					view: 605
					loop: 3
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(badGuy setCycle: End)
				(= seconds 5)
			)
			(6
				(sFX release:)
				(= seconds 4)
			)
			(7
				(EgoDead 4) ; "A good police officer is ALWAYS prepared. You'll do better next time."
			)
			(8
				(EgoDead 4) ; "A good police officer is ALWAYS prepared. You'll do better next time."
			)
		)
	)
)

(instance shootBadGuy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 605
					loop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 6 1 self
				)
			)
			(1
				(gunShotSound play:)
				(gEgo setCycle: End)
				(badGuy loop: 2 cel: 4 setCycle: End self)
				(hisGun init:)
			)
			(2
				(sFX release:)
				(gEgo
					normal: 1
					view: 4
					setCycle: Walk
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: PolyPath 222 88
				)
				(pat setCycle: Walk setMotion: PolyPath 224 80 self init:)
				(shadow setCycle: End)
			)
			(3
				(Face gEgo badGuy)
				(SetScore 194 10)
				(pInset init:)
				(Say pInset 57 0) ; "You shot him! Hold on while I check his vital signs."
				(= seconds 5)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pInset dispose:)
				(pat setMotion: PolyPath (+ (hisGun x:) 10) (hisGun y:) self)
			)
			(5
				(hisGun dispose:)
				(pat view: 608 loop: 0 cel: 0 setCycle: CT 10 1 self)
			)
			(6
				(pInset init:)
				(Say pInset 57 1) ; "I'd like to say it was fun, Bonds, but you've been a real pain in my ass, you male pig."
				(= seconds 6)
				(if (IsFlag 48)
					(backup init:)
				)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pInset dispose:)
				(if (IsFlag 48)
					(backup setCycle: End self)
				else
					(pat setCycle: End self)
					(gunShotSound play:)
				)
			)
			(8
				(if (IsFlag 48)
					(pat loop: 1 cel: 0 setCycle: End self)
					(gunShotSound play:)
				else
					(gEgo
						normal: 0
						view: 605
						loop: 3
						cel: 0
						cycleSpeed: 8
						setCycle: End self
					)
				)
			)
			(9
				(mSound stop:)
				(if (IsFlag 48)
					(backup cel: 2 setCycle: Beg)
					(Say backup 57 2) ; "I'm Detective Hooks, Internal Affairs.  We've been keeping an eye on her since your report.  Lucky I was here."
					(= seconds 6)
				else
					(EgoDead 5) ; "If you can't smell a rotten egg when it's sitting right next to you, how do you expect to catch criminals you don't even know?"
				)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 57 3 #at 30 10) ; "Congratulations! You've not only solved your murder case, but you've also found and incapacitated a dangerous cult that was processing crack. Now all that's left to fight is the paperwork. You almost welcome the routine of it all. There IS such a thing as too much excitement."
				(= seconds 15)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(= global134 0)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance bulletHole of Prop
	(properties
		x 218
		y 49
		view 609
		loop 1
		signal 16385
	)
)

(instance hisGun of Prop
	(properties
		x 84
		y 115
		view 606
		loop 3
		signal 16385
	)
)

(instance shadow of Prop
	(properties
		x 218
		y 40
		view 609
		cel 5
		cycleSpeed 9
	)
)

(instance badGuy of Prop
	(properties
		x 71
		y 135
		view 606
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(HandsOff)
						(if ((gInventory at: 1) state:) ; gun
							(self setScript: 0)
							(gCurRoom setScript: shootBadGuy)
						else
							(gEgo setScript: drawScript)
						)
					)
					(else
						(Print 57 4) ; "That will really stop him."
					)
				)
			)
			(3 ; Do
				(Print 57 5) ; "You think you're superman?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 252
		y 53
		view 22
		cycleSpeed 8
		moveSpeed 8
	)
)

(instance backup of Prop
	(properties
		x 233
		y 69
		view 607
		cycleSpeed 8
	)
)

(instance pInset of View
	(properties
		x 262
		y 120
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(pShirt posn: (+ (self x:) 2) (+ (self y:) 62) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(pMouth dispose:)
		(pShirt dispose:)
	)
)

(instance pMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance pShirt of View
	(properties
		description {pat}
		view 27
		cel 1
		priority 15
		signal 16401
	)
)

(instance sInset of View ; UNUSED
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
		(sShirt dispose:)
	)
)

(instance sMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance sFX of Sound
	(properties
		flags 1
		number 707
	)
)

(instance gunShotSound of Sound
	(properties
		number 937
	)
)

(instance mSound of Sound
	(properties
		flags 1
		number 530
		loop -1
	)
)

(instance stairs of Feature
	(properties
		onMeCheck 1024
		lookStr {The stairs lead back up to the living room}
	)
)

(instance shelves of Feature
	(properties
		onMeCheck 8192
		lookStr {The shelves have various supplies.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 6) ; "You don't want to disturb the evidence."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		onMeCheck 16384
		lookStr {The table is covered with varies tools to make drugs.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 6) ; "You don't want to disturb the evidence."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrels of Feature
	(properties
		onMeCheck 4096
		lookStr {The barrels contain chemicals to make drugs.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 57 6) ; "You don't want to disturb the evidence."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		lookStr {The basement is a seedy looking place, with all the aroma of a drug lab.}
	)
)

