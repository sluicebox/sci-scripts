;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use MiracleGro)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm015 0
)

(instance rm015 of PQRoom
	(properties
		picture 15
	)

	(method (init)
		(LoadMany rsVIEW 148 145 151)
		(if (== gDay 1)
			(LoadMany rsVIEW 124 125 2 3)
		else
			(LoadMany rsVIEW 6 126 123 7)
		)
		(if (OneOf gDay 3 6)
			(LoadMany rsVIEW 146 147 150 25)
		)
		(Load rsSCRIPT 883)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 156 178 156 178 120 232 120 228 113 141 113 138 120 146 120 146 156 3 156 3 162 319 162 319 189 0 189 0 0 319 0
					yourself:
				)
			setRegions: 894 ; elevator
		)
		(if (>= global105 18)
			(nightWin init:)
		)
		(storageDoor init:)
		(fireHydrant init:)
		(smokeDetectors init:)
		(mensSign init:)
		(womensSign init:)
		(mensEntrance init:)
		(womensEntrance init:)
		(rm15window init:)
		(carpet init:)
		(lightSwitches init:)
		(hallwayRoom init:)
		(switch gPrevRoomNum
			(16
				(gEgo view: 124 setStep: 5 1 posn: 305 158)
				(self posn: 259 158 setScript: (ScriptID 896 1)) ; sWI
			)
			(17
				(gEgo view: 2 posn: 237 117)
				(self posn: 195 117 setScript: (ScriptID 896 1)) ; sWI
			)
			(18
				(gEgo view: 124 loop: 2 setStep: 5 1 posn: 50 140 setPri: 1)
				((gEgo head:) cel: 2)
				(if (== ((gInventory at: 12) owner:) 17) ; toiletPaper
					((gInventory at: 12) owner: 0) ; toiletPaper
				)
				(HandsOff)
				(self setScript: global111)
			)
			(24
				(gEgo view: 124 loop: 2 setStep: 5 1 posn: 50 140 setPri: 1)
				((gEgo head:) cel: 2)
				(if (== ((gInventory at: 12) owner:) 17) ; toiletPaper
					((gInventory at: 12) owner: 0) ; toiletPaper
				)
				(HandsOff)
				(self setScript: global111)
			)
			(12
				(gEgo view: 124 loop: 2 setStep: 5 1 posn: 50 140 setPri: 1)
				((gEgo head:) cel: 2)
				(if (== ((gInventory at: 12) owner:) 17) ; toiletPaper
					((gInventory at: 12) owner: 0) ; toiletPaper
				)
				(HandsOff)
				(self setScript: global111)
			)
			(else
				(gEgo view: 124 posn: 171 151)
			)
		)
		(cond
			((and (> gDay 1) (== gPrevRoomNum 17))
				(gEgo view: 6)
			)
			((> gDay 1)
				(gEgo view: 123)
			)
		)
		(gEgo init:)
		(if (OneOf gDay 3 6)
			(if (!= global109 1)
				(janitor
					cycleSpeed: 9
					setScript: sweeping
					ignoreActors: 1
					init:
				)
				(janMusic play:)
			)
			(cart init:)
		)
		(egoBluGro
			init:
				egoBluViews
				124
				125
				2
				2
				3
				1
				2
				2
				125
				124
				1
				5
				1
				2
				123
				126
				6
				2
				3
				1
				2
				6
				126
				123
				1
				5
				1
				2
			color: 2
			who: gEgo
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(not (& (= temp0 (gEgo onControl: 0)) $4000))
					(gCast contains: storageInset)
				)
				(storageInset dispose:)
				(flashBat dispose:)
				(flares dispose:)
				(storageDoor setScript: closeDoor)
			)
			((& ((egoBluGro who:) onControl: 1) (egoBluGro color:))
				(egoBluGro doit:)
			)
			(script 0)
			((& temp0 $0080)
				(gCurRoom posn: 305 155 setScript: (ScriptID 896 2) 0 16) ; sWO
			)
			((& temp0 $0008)
				(cond
					((OneOf gDay 1 2 4 5 7)
						(HandsOff)
						(gCurRoom setScript: womanAttacks)
					)
					((and (gCast contains: janitor) (OneOf gDay 3 6))
						(HandsOff)
						(gCurRoom setScript: noEntrance)
					)
					((not (gCast contains: janitor))
						(gCurRoom posn: 237 115 setScript: (ScriptID 896 2) 0 17) ; sWO
					)
					(else
						(gCurRoom posn: 237 115 setScript: (ScriptID 896 2) 0 17) ; sWO
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(egoBluGro dispose:)
		(DisposeScript 892)
		(super dispose:)
		(DisposeScript 894)
	)
)

(instance egoBluGro of MiracleGro
	(properties)
)

(instance egoBluViews of List
	(properties)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(storageDoor setCycle: Beg self)
			)
			(1
				(closeDoorSnd play:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance noEntrance of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(janitor setScript: 0 setCycle: 0)
				(= cycles 1)
			)
			(1
				(janInset init:)
				(= save1 1)
				(Say janInset 15 0) ; "Where the heck you goin', Sarge? This here's the ladies room! Men's is right next door."
				(= seconds 7)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo
					loop: 1
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
				(janInset dispose:)
			)
			(3
				(HandsOn)
				(janitor setScript: sweeping)
				(self dispose:)
			)
		)
	)
)

(instance sweeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(janitor setCycle: Fwd)
				(= cycles 60)
			)
			(1
				(janitor cel: (Random 0 3) setCycle: 0)
				(= cycles 30)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance openCloset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 147 117 self)
			)
			(1
				(openDoorSnd play:)
				(storageDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 134 117 self)
			)
			(3
				(flashBat
					cel: (if (== ((gInventory at: 14) owner:) 15) 0 else 1) ; battery
					init:
				)
				(flares
					cel: (if (== ((gInventory at: 15) owner:) 15) 0 else 1) ; flares
					init:
				)
				(storageInset init:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance womanAttacks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 6 setMotion: PolyPath 234 117 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(slap play:)
				(= cycles 2)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (> gDay 1)
					(gEgo view: 148 setLoop: 2)
				else
					(gEgo view: 148 setLoop: 1)
				)
				(gEgo
					cel: 0
					x: 223
					y: 117
					normal: 0
					setCycle: Walk
					setMotion: PolyPath 169 120 self
				)
				(Print 15 1 #dispose #at 40 120) ; "Whew, that lady ought to be in professional boxing!  Guess you went in at the wrong time."
			)
			(5
				(= seconds 3)
				(braLady init:)
				(gEgo setPri: -1)
			)
			(6
				(braLady setCycle: CT 10 1 self)
			)
			(7
				(Print 15 2 #dispose #at 40 120) ; "You men are all alike! Only one thing on your filthy minds! Freakin' pervert!"
				(if (> gDay 1)
					(NormalEgo 6 0)
				else
					(NormalEgo 2 0)
				)
				(braLady setCycle: CT 7 -1 self)
			)
			(8
				(braLady setCycle: End self)
			)
			(9
				(= cycles 30)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance janitorRandomTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(janitor setScript: 0 setCycle: 0)
				(= cycles 1)
			)
			(1
				(janInset init:)
				(= save1 1)
				(switch (Random 0 3)
					(0
						(Say janInset 15 3) ; "Hey, Sarge! Nice day, ain't it? Sure as heck would like ta be fishin'!"
					)
					(1
						(Say janInset 15 4) ; "Ya know, there's a great little lake just outsida town that's chock fulla bass."
					)
					(2
						(Say janInset 15 5) ; "Maybe y'all'd like ta go fishin' with me sometime."
					)
					(3
						(Say janInset 15 6) ; "Well, gotta get back ta work. Take care now, y'hear?"
					)
				)
				(= seconds 6)
			)
			(2
				(janInset dispose:)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(janitor setScript: sweeping)
				(self dispose:)
			)
		)
	)
)

(instance janitorFixToilet of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(janitor setScript: 0 setCycle: 0)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(iEgo init:)
				(Say iEgo 15 7) ; "Mr. Stump, the toilet in the men's locker room is overflowing."
				(= seconds 7)
			)
			(2
				(= save1 1)
				(Say iEgo 15 8) ; "Think maybe you can take care of that for me? It's a real mess."
				(= seconds 7)
			)
			(3
				(iEgo dispose:)
				(= cycles 1)
			)
			(4
				(= save1 1)
				(janInset init:)
				(Say janInset 15 9) ; "Well, I sure can! Heck, I'll get right on it, Sarge."
				(= seconds 6)
			)
			(5
				(janInset dispose:)
				(if
					(and
						(> (gEgo x:) (janitor x:))
						(> (gEgo y:) (janitor y:))
					)
					(gEgo setMotion: PolyPath 110 160 self)
				else
					(= cycles 1)
				)
			)
			(6
				(gEgo loop: 0)
				(janitor
					view: 146
					loop: 0
					cel: 0
					x: (+ (janitor x:) 4)
					y: (- (janitor y:) 3)
					setPri: 11
					ignoreActors: 1
					setCycle: End self
				)
			)
			(7
				(janitor
					view: 146
					x: (+ (janitor x:) 11)
					y: (+ (janitor y:) 18)
					setLoop: 1
					cycleSpeed: 9
					moveSpeed: 3
					ignoreActors: 0
					setPri: -1
					setCycle: SyncWalk
					setMotion: MoveTo 310 155 self
				)
			)
			(8
				(janMusic fade:)
				(SetScore 173 3)
				(proc0_17 20)
				(janitor dispose:)
				(= global109 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance storageDoor of Prop
	(properties
		x 133
		y 113
		description {Storage Door}
		view 145
		priority 6
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 10) ; "That's the door to the storage closet."
			)
			(3 ; Do
				(if (not cel)
					(HandsOff)
					(gCurRoom setScript: openCloset)
				else
					(Print 15 11) ; "The door's already open."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance storageInset of Prop
	(properties
		x 249
		y 180
		description {storage closet}
		view 151
		priority 14
		signal 16401
	)

	(method (facingMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 12) ; "The closet is cluttered with boxes."
			)
			(3 ; Do
				(Print 15 13) ; "There's nothing you need in that box."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flares of Prop
	(properties
		x 269
		y 159
		description {flares}
		view 151
		loop 2
		priority 15
		signal 16401
	)

	(method (facingMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 14) ; "There's a box of road flares in the closet."
			)
			(3 ; Do
				(switch cel
					(0
						(gEgo get: 15) ; flares
						(Print 15 15) ; "You take some flares."
						(self cel: 1 forceUpd:)
						(SetScore 223 3)
					)
					(else
						(Print 15 16) ; "You already have plenty of flares."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBat of Prop
	(properties
		x 235
		y 110
		description {Batteries}
		view 151
		loop 1
		priority 15
		signal 16401
	)

	(method (facingMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 17) ; "There's an open box of batteries in the closet."
			)
			(3 ; Do
				(switch cel
					(0
						(gEgo get: 14) ; battery
						(Print 15 18) ; "You take some batteries from the box."
						(self cel: 1 forceUpd:)
						(SetScore 101 5)
					)
					(else
						(Print 15 19) ; "You already have plenty of batteries."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance janitor of Actor
	(properties
		x 208
		y 140
		description {janitor}
		view 147
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 20) ; "Mr. Stumps, the janitor, is good-natured and hard-working."
			)
			(3 ; Do
				(Print 15 21) ; "Mr. Stumps is friendly, but he's not THAT friendly."
			)
			(5 ; Talk
				(if (not (IsFlag 212))
					(Print 15 22) ; "The janitor looks friendly enough, so you strike up a conversation."
					(SetFlag 212)
				)
				(HandsOff)
				(if (and (== gDay 6) (== ((gInventory at: 12) owner:) 17)) ; toiletPaper
					(gCurRoom setScript: janitorFixToilet)
				else
					(gCurRoom setScript: janitorRandomTalk)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cart of View
	(properties
		x 239
		y 143
		view 147
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 23) ; "That's Mr. Stumps' janitorial cart."
			)
			(3 ; Do
				(Print 15 24) ; "Looking for a new career?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance janInset of View
	(properties
		x 72
		y 185
		view 150
	)

	(method (init)
		(janEyes
			x: (+ (self x:) 16)
			y: (- (self y:) 69)
			init:
			setScript: janEyesBlink
		)
		(janMouth
			x: (+ (self x:) 2)
			y: (- (self y:) 68)
			init:
			cycleSpeed: 9
			setCycle: RandCycle
		)
		(super init:)
	)

	(method (dispose)
		(janEyes setScript: 0 dispose:)
		(janMouth dispose:)
		(super dispose:)
	)
)

(instance janEyes of Actor
	(properties
		view 150
		loop 2
		cel 2
		priority 15
		signal 16
	)
)

(instance janMouth of Actor
	(properties
		view 150
		loop 1
		priority 15
		signal 16
	)
)

(instance janEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(janEyes cel: 1)
				(= cycles 2)
			)
			(2
				(janEyes cel: 2)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance iEgo of View
	(properties
		x 261
		y 99
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(iEgoMouth x: (iEgo x:) y: (iEgo y:) setCycle: RandCycle init:)
		(if (> gDay 1)
			(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoClothes dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 16
	)
)

(instance iEgoEyes of Prop
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
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance braLady of Prop
	(properties
		x 216
		y 88
		view 148
		cycleSpeed 10
	)
)

(instance fireHydrant of Feature
	(properties
		x 120
		y 92
		description {fire hydrant}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 25) ; "It's a fire extinguisher."
			)
			(3 ; Do
				(Print 15 26) ; "But... there's no fire."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smokeDetectors of Feature
	(properties
		x 169
		y 52
		description {smoke detectors}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 27) ; "The smoke detectors help protect the building from fire."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mensSign of Feature
	(properties
		x 310
		y 76
		description {men's sign}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 28) ; "The sign reads 'Men'."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance womensSign of Feature
	(properties
		x 232
		y 79
		description {women's sign}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 29) ; "The sign reads 'Women'."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mensEntrance of Feature
	(properties
		x 274
		y 101
		description {the entrance}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 30) ; "That's the entrance to the men's locker room."
			)
			(3 ; Do
				(Print 15 31) ; "Just walk in."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance womensEntrance of Feature
	(properties
		x 218
		y 89
		description {the entrance}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 32) ; "That's the entrance to the women's locker room."
			)
			(3 ; Do
				(Print 15 31) ; "Just walk in."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nightWin of Prop
	(properties
		x 170
		y 89
		description {the window}
		view 145
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 33) ; "The window overlooks scenic downtown Lytton."
			)
			(3 ; Do
				(Print 15 34) ; "You don't need to open the window."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rm15window of Feature
	(properties
		x 168
		y 80
		nsTop 72
		nsLeft 150
		nsBottom 90
		nsRight 188
		description {the window}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 33) ; "The window overlooks scenic downtown Lytton."
			)
			(3 ; Do
				(Print 15 34) ; "You don't need to open the window."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carpet of Feature
	(properties
		x 168
		y 80
		description {the carpet}
		onMeCheck 16422
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 35) ; "The floor's color is policeman blue."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lightSwitches of Feature
	(properties
		x 238
		y 84
		description {light switch}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 36) ; "That's a light switch."
			)
			(3 ; Do
				(Print 15 37) ; "The lights are left on during the day."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallwayRoom of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 15 38) ; "You're standing in the first floor hallway of the Lytton County Police Department."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance janMusic of Sound
	(properties
		flags 1
		number 150
		loop -1
	)
)

(instance openDoorSnd of Sound
	(properties
		number 907
	)
)

(instance closeDoorSnd of Sound
	(properties
		number 908
	)
)

(instance slap of Sound
	(properties
		number 152
	)
)

