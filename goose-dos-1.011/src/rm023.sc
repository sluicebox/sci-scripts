;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm023 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm023 of Rm
	(properties
		picture 23
		style 0
		horizon 100
		picAngle 70
		vanishingY -99
	)

	(method (init)
		(Load rsVIEW 72)
		(Load rsVIEW 216)
		(Load rsVIEW 45)
		(Load rsVIEW 72)
		(Load rsVIEW 133)
		(Load rsVIEW 39)
		(Load rsSOUND 41)
		(Load rsSOUND 13)
		(Load rsSOUND 2)
		(Load rsSOUND 47)
		(super init:)
		(= global125 -1)
		(= local2 (DoSound sndCHECK_DRIVER))
		(switch gPrevRoomNum
			(16
				(gEgo
					x: (+ (/ (* (- (gEgo x:) 51) 32) 19) 1)
					y: (+ horizon 4)
				)
			)
			(22
				(gEgo y: (+ (/ (* (- (gEgo y:) 110) 85) 78) 103))
			)
			(24
				(gEgo x: 289)
				(if (< (gEgo y:) 175)
					(gEgo
						setPri: -1
						y: (+ (/ (* (- (gEgo y:) 121) 45) 20) 101)
					)
				)
			)
			(30
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 40) 53) 1) y: 185)
			)
			(31
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 77) 95) 241) y: 185)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(gAddToPics add: tree eachElementDo: #init doit:)
		(proc0_10)
		(if (not [global675 23])
			(boPeep init:)
			(if (= local1 (proc0_11 45))
				(= [global675 23] 1)
				(gGlobalMGSound loop: 0 stop:)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(boPeep setScript: rhymeScript)
			else
				(boPeep setScript: cryScript)
			)
		else
			(boPeepDone init:)
			(sheepDone init:)
			(= local3 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 9)
						(== local4 1)
						(== (musicScript state:) 5)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if
					(and
						(== (rhymeScript state:) 9)
						(== local4 1)
						(== (musicScript state:) 5)
					)
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if
					(and
						(== (rhymeScript state:) 9)
						(== local4 1)
						(== (musicScript state:) 5)
					)
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local3 1)
						(proc0_16 event 122 99 145 133)
					)
					(LookAt boPeep)
					(boPeep setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 2)
				(if (and (== global208 0) (== local3 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 24)
			)
			((== (gEgo edgeHit:) 1)
				(if (and (== global208 0) (== local3 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 16)
			)
			((== (gEgo edgeHit:) 4)
				(if (and (== global208 0) (== local3 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 22)
			)
			((== (gEgo edgeHit:) 3)
				(if (and (== global208 0) (== local3 2))
					(gGlobalMGSound play:)
				)
				(if (< (gEgo x:) 241)
					(gCurRoom newRoom: 30)
				else
					(gCurRoom newRoom: 31)
				)
			)
		)
		(super doit:)
		(if (> (gEgo distanceTo: boPeep) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 23])
				(not global108)
				(< (gEgo distanceTo: boPeep) 30)
			)
			(= global108 1)
			(LookAt boPeep)
			(boPeep setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crySound stop:)
				(= global103 1)
				(if (not local3)
					(= local3 1)
				)
				(HandsOff)
				(boPeep setLoop: 5 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(StrCpy @global270)
				(Display
					{Boo hoo!\nI've lost\nmy sheep.}
					dsWIDTH
					80
					dsCOORD
					151
					39
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 priority: 7 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(boPeep setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(boPeep setLoop: 0 setCycle: Fwd setScript: cryScript)
				(= global103 0)
				(if (and (== global208 0) (== local3 2))
					(gGlobalMGSound play:)
				)
				(= local3 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global131
					(self cue:)
				else
					(proc0_18)
					(= seconds 2)
				)
			)
			(1
				(= global209 1)
				(= global103 1)
				(= local3 1)
				(HandsOff)
				(boPeep
					setLoop: 1
					setCel: (if (< (local1 x:) (boPeep x:)) 0 else 4)
					stopUpd:
				)
				(if global131
					(proc0_18)
				)
				(sheep init: setScript: musicScript)
				(gEgo illegalBits: 0 setMotion: MoveTo 175 160 self)
			)
			(2
				(boPeep setCel: (if (== (boPeep cel:) 4) 3 else 1))
			)
			(3
				(gEgo setLoop: 3 stopUpd:)
				(boPeep setCel: 2)
				(if global131
					(sheep setMotion: MoveTo 140 110 self)
				else
					(sheep setMotion: MoveTo 160 110 self)
				)
			)
			(4
				(cond
					(global131
						(if (== (sheep loop:) 1)
							(boPeep setCel: 1)
							(sheep setMotion: MoveTo 50 110 self)
						else
							(boPeep setCel: 3)
							(sheep setMotion: MoveTo 270 110 self)
						)
					)
					((== (sheep loop:) 1)
						(boPeep setCel: 1)
						(sheep setMotion: MoveTo 80 110 self)
					)
					(else
						(boPeep setCel: 3)
						(sheep setMotion: MoveTo 240 110 self)
					)
				)
			)
			(5
				(boPeep setCel: (if (== (boPeep cel:) 1) 0 else 4))
				(sheep setMotion: MoveTo 170 110 self)
			)
			(6
				(if global131
					(sheep setMotion: MoveTo 220 140 self)
				else
					(sheep setMotion: MoveTo 190 130 self)
				)
			)
			(7
				(boPeep setLoop: 2 setCel: 0)
				(sheep
					ignoreControl: 0
					cycleSpeed: 0
					setMotion: MoveTo 135 130 self
				)
			)
			(8
				(boPeep setCel: 1)
				(= seconds 1)
			)
			(9
				(boPeep setLoop: 3 setCycle: Fwd cycleSpeed: 4)
				(sheep
					setAvoider: 0
					view: 72
					setLoop: 4
					setCycle: Fwd
					cycleSpeed: 6
				)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(10
				(gGame setSpeed: global206)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(gEgo setMotion: MoveTo 140 170)
					(proc0_14 140 170)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local4 1)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 13
		priority 10
	)
)

(instance tree of PV
	(properties
		y 75
		x 194
		view 216
	)
)

(instance boPeep of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 72 setLoop: 0 posn: 134 123 setCycle: Fwd cycleSpeed: 3)
	)
)

(instance boPeepDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 72 setLoop: 3 setCel: 0 posn: 134 123 stopUpd:)
	)
)

(instance sheepDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 72 setLoop: 4 setCel: 0 posn: 135 130 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 133
			setLoop: 4
			setCel: 0
			posn: 191 68
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 190 90 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 5
			bottom: 77
			right: 229
			type: 4
			title: {Little Bo Peep}
			back: 3
		)
	)
)

(instance gotItSound of Sound ; UNUSED
	(properties
		number 2
		priority 10
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
			)
			(1
				(rhymeBox init:)
				(rhymeBox open:)
				(Display
					{Little Bo Peep has lost her sheep}
					dsWIDTH
					300
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2
				(Display
					{And can't tell where to find them;}
					dsWIDTH
					300
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(Display
					{Leave them alone, and they'll}
					dsWIDTH
					300
					dsCOORD
					5
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
				(Display {     come home,} dsWIDTH 300 dsCOORD 5 41 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(4
				(Display
					{And bring their tails behind them.}
					dsWIDTH
					300
					dsCOORD
					5
					53
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance cryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 2)
				(gGlobalMGSound stop:)
				(crySound play: self)
			)
			(1
				(= local3 0)
				(= seconds 3)
			)
			(2
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
	)
)

(instance crySound of Sound
	(properties
		number 47
		priority 4
	)
)

(instance sheep of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			posn: (local1 x:) (local1 y:)
			setCycle: Walk
			cycleSpeed: 0
			illegalBits: -32768
			setAvoider: Avoid
			ignoreActors: 0
			setStep: (if global131 2 else 3) (if global131 3 else 4)
			setMotion: MoveTo (if (< x (boPeep x:)) 90 else 195) 110 rhymeScript
		)
	)
)

