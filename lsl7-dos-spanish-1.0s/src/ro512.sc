;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 512)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	ro512 0
)

(instance ro512 of L7Room
	(properties
		picture 51500
	)

	(method (init)
		(Load rsVIEW 51205)
		(super init:)
		(Palette 1 515) ; PalLoad
		(= global335 toDewmi)
		(poDewmi init:)
		(poDewmiEyes init:)
		(gGame handsOff:)
		(self setScript: soCartoon)
	)
)

(instance soCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 40)
			)
			(2
				(gMessager sayRange: 0 0 1 1 4 self 511) ; "Well, that does it, Larry. You're just too damned good for me."
			)
			(3
				(gOSound1 playSound: 31011 self)
			)
			(4
				(= global335 0)
				(= global330 toLarry)
				(gCurRoom drawPic: 51300)
				(Palette 1 513) ; PalLoad
				(poDewmiEyes dispose:)
				(poDewmi hide:)
				(poLarry init:)
				((= register (poLarryMouth new:))
					init:
					setPri: (+ (poLarry priority:) 1)
				)
				(FrameOut)
				(gMessager sayRange: 0 0 1 5 7 self 511) ; "How 'bout a drink, Larry?"
			)
			(5
				(= global330 toLarry2)
				(gCurRoom drawPic: 51000)
				(Palette 1 510) ; PalLoad
				(register dispose:)
				(poLarry
					view: 51004
					loop: 0
					cel: 0
					setPri: 6
					posn: 288 130
					doit:
				)
				(poLarryMouth view: 51004 loop: 1)
				(voLarryHead init:)
				(voDiceCup init:)
				(voClothes init:)
				(voDrinks init:)
				(voBottles init:)
				(poOcean init:)
				(poFountain init:)
				(poDewmi view: 51005 loop: 2 cel: 0 posn: 150 232 show:)
				(poDewmiArm init: setCycle: End)
				(FrameOut)
				(gMessager sayRange: 0 0 1 8 9 self 511) ; "I guess you're right."
			)
			(6
				(gCurRoom drawPic: 51200)
				(Palette 1 512) ; PalLoad
				(poLarry hide:)
				(voLarryHead hide:)
				(voDiceCup hide:)
				(voClothes hide:)
				(voDrinks dispose:)
				(voBottles hide:)
				(poDewmi hide:)
				(poOcean setScript: 0 hide:)
				(poFountain hide:)
				(poDewmiArm
					view: 51205
					loop: 0
					cel: 0
					posn: 324 198
					doit:
					setCycle: CT 21 1 self
				)
				(poPoison init: hide:)
				(FrameOut)
				(gMessager say: 0 0 1 10 0 511) ; "This oughta fix him!"
			)
			(7
				(= ticks 30)
			)
			(8
				(poDewmiArm setCycle: End self 31)
			)
			(9
				(gOSound1 playSound: 51216)
				(poPoison show: setCycle: End self)
			)
			(10
				(gCurRoom drawPic: 51000)
				(Palette 1 510) ; PalLoad
				(= global330 0)
				(poDewmiArm dispose:)
				(poPoison dispose:)
				(poLarry show:)
				(voLarryHead show:)
				(voDiceCup show:)
				(voClothes show:)
				(voBottles show:)
				(poOcean show: setScript: soMotion)
				(poFountain show:)
				(poDewmi loop: 4 cel: 0 posn: 149 214 show:)
				(FrameOut)
				(gMessager say: 0 0 1 11 self 511) ; "Here you are, Larry."
			)
			(11
				(gOMusic1 fadeOut:)
				(gCurRoom drawPic: -1)
				(poOcean setScript: 0)
				(gCast eachElementDo: #dispose)
				(PlayVMD 0 {10.vmd}) ; Open
				(if (< global294 1600)
					(PlayVMD 1 0 0 21 18 0 10000) ; Put
				else
					(PlayVMD 1 0 0 1) ; Put
				)
				(PlayVMD 14 1) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(12
				(gMessager say: 0 0 1 12 self 511) ; "Once again, Larry, you snatch defeat from the jaws of victory!"
			)
			(13
				(gEgo put: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
				(CopyWinningWallpaper 3)
				(gCurRoom newRoom: 551) ; ro551
				((ScriptID 64017 0) set: 261) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nCenterY 132
		nRange 12
	)
)

(instance voDiceCup of View
	(properties
		x 288
		y 130
		loop 2
		view 51004
	)
)

(instance voClothes of View
	(properties
		priority 6
		x 288
		y 130
		loop 3
		view 51004
		fixPriority 1
	)
)

(instance voDrinks of View
	(properties
		x 51
		y 130
		loop 2
		view 51010
	)
)

(instance voBottles of View
	(properties
		x 70
		y 130
		loop 1
		view 51010
	)
)

(instance poPoison of Prop
	(properties
		x 450
		y 348
		loop 1
		view 51205
	)
)

(instance poOcean of Prop
	(properties
		priority 1
		x 106
		y 132
		view 51099
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance poFountain of Prop
	(properties
		priority 600
		x -5
		y 257
		view 51098
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance toDewmi of Talker
	(properties)

	(method (init)
		(super init: poDewmiMouth)
	)
)

(instance poDewmiMouth of Prop
	(properties
		loop 1
		view 51510
	)

	(method (init)
		(= x (poDewmi x:))
		(= y (poDewmi y:))
		(self setPri: (+ (poDewmi priority:) 1))
		(super init: &rest)
	)
)

(instance poDewmi of Prop
	(properties
		x 166
		y 526
		view 51510
	)
)

(instance poDewmiEyes of Prop
	(properties
		loop 2
		view 51510
	)

	(method (init)
		(= x (poDewmi x:))
		(= y (poDewmi y:))
		(self setPri: (+ (poDewmi priority:) 2) setCycle: Blink 80)
		(super init: &rest)
	)
)

(instance poDewmiArm of Prop
	(properties
		loop 3
		view 51005
	)

	(method (init)
		(= x (poDewmi x:))
		(= y (poDewmi y:))
		(self setPri: (+ (poDewmi priority:) 1))
		(super init: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(super init: poLarryMouth)
	)
)

(instance poLarry of Prop
	(properties
		x 334
		y 311
		view 51305
	)
)

(instance poLarryMouth of Prop
	(properties
		loop 1
		view 51305
	)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 2))
		(super init: &rest)
	)
)

(instance toLarry2 of Talker
	(properties)

	(method (init)
		(super init: poLarryMouth)
		(voLarryHead hide:)
	)

	(method (dispose)
		(voLarryHead show:)
		(super dispose: &rest)
	)
)

(instance voLarryHead of View
	(properties
		loop 1
		view 51004
	)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)
)

