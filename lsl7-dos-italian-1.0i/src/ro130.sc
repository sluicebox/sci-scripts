;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use TPSound)
(use oHandsOnWhenCued)
(use NewUser)
(use PushButton)
(use soFlashCyberSniff)
(use Str)
(use Talker)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	ro130 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(if (not (= temp2 (MakeMessageText 0 0 2 1 15 1)))
		(= temp2 (Str with: {Leisure Suit Larry\nin\nLove For Sail!}))
	)
	(oCredits hide: setString: temp2)
	(oCredits
		posn:
			(= temp0 (/ (- 640 (MulDiv (oCredits nWidth:) 3 2)) 2))
			(= temp1 (/ (- 480 (MulDiv (oCredits nHeight:) 3 2)) 2))
		setScalePercent: 150
		show:
	)
	(oCreditBL
		hide:
		setString: temp2
		posn: (- temp0 2) temp1
		setScalePercent: 150
		show:
	)
	(oCreditBT
		hide:
		setString: temp2
		posn: temp0 (- temp1 2)
		setScalePercent: 150
		show:
	)
	(oCreditBR
		hide:
		setString: temp2
		posn: (+ temp0 2) temp1
		setScalePercent: 150
		show:
	)
	(oCreditBB
		hide:
		setString: temp2
		posn: temp0 (+ temp1 2)
		setScalePercent: 150
		show:
	)
	(temp2 dispose:)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3)
	(oCredits hide: setString: param1)
	(= temp2 (MulDiv (oCredits nWidth:) 3 2))
	(= temp3 (MulDiv (oCredits nHeight:) 3 2))
	(cond
		((> temp2 560)
			(= temp0 (/ (- 640 temp2) 2))
		)
		((> (+ (= temp0 (Random 0 560)) temp2) 600)
			(= temp0 (- 600 temp2))
		)
		((< temp0 40)
			(= temp0 40)
		)
	)
	(cond
		((> (+ (= temp1 (Random 0 400)) temp3) 440)
			(= temp1 (- 440 temp3))
		)
		((< temp1 40)
			(= temp1 40)
		)
	)
	(oCredits posn: temp0 temp1 setScalePercent: 150 show:)
	(oCreditBL
		hide:
		setString: param1
		posn: (- temp0 2) temp1
		setScalePercent: 150
		show:
	)
	(oCreditBT
		hide:
		setString: param1
		posn: temp0 (- temp1 2)
		setScalePercent: 150
		show:
	)
	(oCreditBR
		hide:
		setString: param1
		posn: (+ temp0 2) temp1
		setScalePercent: 150
		show:
	)
	(oCreditBB
		hide:
		setString: param1
		posn: temp0 (+ temp1 2)
		setScalePercent: 150
		show:
	)
)

(procedure (localproc_2)
	(oCredits setString:)
	(oCreditBL setString:)
	(oCreditBT setString:)
	(oCreditBR setString:)
	(oCreditBB setString:)
)

(instance ro130 of L7Room
	(properties
		style 12
		picture 13000
	)

	(method (init)
		(gGame handsOff:)
		(super init:)
		(= global330 toLarryTalker)
		(= global332 toThyghTalker)
		(poGangwayCrowd init: setCycle: Fwd)
		(poShipCrowd init: setCycle: Fwd)
		(poWaves init:)
		(poLiftCrate init: setScript: soLiftCrate)
		(voCrowd init:)
		(poFlags init: setCycle: Fwd)
		(poTorin init: setScript: soTorin)
		(poGuy init: setCycle: Fwd)
		(poOnNOff init: setScript: soOnNOff)
		(aoStroller init:)
		(aoWalker init:)
		(oCredits init: setString:)
		(oCreditBL init: setString:)
		(oCreditBT init: setString:)
		(oCreditBR init: setString:)
		(oCreditBB init: setString:)
		(if (== global325 1)
			(Load rsVIEW 13075)
		)
		(self setScript: soTitleScreen)
	)

	(method (dispose)
		(= global330 0)
		(= global332 0)
		(super dispose: &rest)
	)
)

(instance soTitleScreen of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 3])
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gOSound1 playSound: 13001)
				(Load 140 10190) ; WAVE
				(= ticks 120)
			)
			(2
				(if (== global325 1)
					(voTitle init:)
				else
					(localproc_0)
				)
				(gOSound1 playSound: 10190 self)
			)
			(3
				(if (== global325 1)
					(voTitle dispose:)
				else
					(localproc_2)
				)
				(Load rsMESSAGE 15)
				(= local5 global227)
				(proc64031_0 100)
				(gOMusic1 stop: setMusic: 13000)
				(= cycles 3)
			)
			(4
				(gOEventHandler registerGlobalHandler: oEventHandler)
				(++ local0)
				(if (= temp0 (MakeMessageText 0 0 3 local0 15 1))
					(localproc_1 temp0)
					(= ticks (Max 240 (/ (* 30 (temp0 size:)) 10)))
					(temp0 dispose:)
					(= temp0 0)
				else
					(localproc_2)
					(gOEventHandler unregisterGlobalHandler: oEventHandler)
					(gCurRoom setScript: soWelcomeAboard)
				)
			)
			(5
				(localproc_2)
				(= ticks 20)
			)
			(6
				(self changeState: (- state 2))
			)
		)
	)
)

(instance soWelcomeAboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOMusic1 fade: local5 6 3 0)
				(proc64031_0 local5)
				(poGangwayCrowd dispose:)
				(poShipCrowd dispose:)
				(poWaves dispose:)
				(poLiftCrate dispose:)
				(voCrowd dispose:)
				(poFlags dispose:)
				(poTorin dispose:)
				(poLiftCrate dispose:)
				(poGuy dispose:)
				(poOnNOff dispose:)
				(aoStroller dispose:)
				(aoWalker dispose:)
				(gCurRoom style: 0 drawPic: 13300)
				(Palette 1 133) ; PalLoad
				(poBugEyeLarry init:)
				(poFullThygh init:)
				(poFullThyghArm init: hide:)
				(poWheelchair init:)
				(poMrBoning init:)
				(= ticks 60)
			)
			(1
				(poMrBoning
					view: 13311
					loop: 1
					cel: 0
					x: 453
					y: 467
					setCycle: End self
				)
			)
			(2
				(poFullThyghArm show:)
				(poWheelchairOut init: setCycle: End self)
				(poWheelchair dispose:)
				(poMrBoning dispose:)
			)
			(3
				(poWheelchairOut dispose:)
				(poBugEyeLarry
					view: 13302
					loop: 2
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(Load rsPIC 13310)
			)
			(4
				(poFullThygh dispose:)
				(poFullThyghArm dispose:)
				(poBugEyeLarry dispose:)
				(gCurRoom drawPic: 13310)
				(= local1 0)
				(= local2 0)
				(toLarryTalker view: 13300 x: 340 y: 322)
				(gMessager say: 0 0 0 1 self 133) ; "Oooh, hello there, boat babes! My name is Larry; Larry Laffer!"
			)
			(5
				(= local1 1)
				(= local2 1)
				(toLarryTalker dispose:)
				(gCurRoom drawPic: 13320)
				(poLarry1 view: 13320 loop: 0 cel: 0 x: 322 y: 480 init:)
				(poLarry2
					view: 13320
					loop: 1
					cel: 0
					x: 322
					y: 480
					cycleSpeed: 17
					setPri: (+ (poLarry1 priority:) 5)
					setCycle: Fwd
					init:
				)
				(= local3 1)
				(= local4 0)
				(toThyghTalker view: 13310 x: 322 y: 480)
				(gMessager say: 0 0 0 2 self 133) ; "Welcome aboard the PMS Bouncy, Laffer."
			)
			(6
				(gCurRoom drawPic: 13330)
				(poLarry2 dispose:)
				(poLarry1 hide:)
				(= local4 1)
				(toThyghTalker dispose:)
				(voDummyBust view: 13330 loop: 0 cel: 0 x: 296 y: 264 init:)
				(voDummyMouth view: 13330 loop: 1 cel: 0 x: 296 y: 264 init:)
				(= local4 0)
				(= local3 0)
				(toThyghTalker view: 13330 x: 296 y: 264)
				(voDummyMouth hide:)
				(voDummyBust hide:)
				(gMessager say: 0 0 0 3 self 133) ; "I'm Captain Thygh!"
			)
			(7
				(Load rsVIEW 13350)
				(Load rsPIC 13340)
				(Load 140 13300) ; WAVE
				(= ticks 10)
			)
			(8
				(gCurRoom drawPic: 13310)
				(Load rsPIC 34100)
				(= local4 1)
				(toThyghTalker dispose:)
				(= local2 0)
				(toLarryTalker view: 13340 x: 214 y: 480)
				(gMessager say: 0 0 0 4 self 133) ; "(STAGE WHISPER) Before this cruise is over, she'll be fallin' all over me!"
			)
			(9
				(gOSound1 playSound: 13300)
				(= ticks 30)
			)
			(10
				(poLarry1
					view: 13350
					loop: 0
					cel: 0
					x: 214
					y: 480
					cycleSpeed: 6
					show:
					setCycle: End self
					doit:
				)
				(= local2 1)
				(toLarryTalker dispose:)
			)
			(11
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 34100)
				(Palette 1 999) ; PalLoad
				(Palette 1 341) ; PalLoad
				(= global330 toLarryTalker1)
				(= global340 toPurser)
				(poLarry1 view: 60100 loop: 8 cel: 7 posn: 308 294 init: doit:)
				(poPurser init:)
				(voWallPhone init:)
				(voDeskPhone init:)
				(voAnnouncer init:)
				(FrameOut)
				(gOMusic1 setMusic: 34000)
				(= ticks 120)
			)
			(12
				(gMessager say: 1 0 2 0 self 341) ; "Here's your keycard, Mr. Laffer. There's been a slight problem with your room."
				(gEgo get: ((ScriptID 64037 0) get: 54)) ; oInvHandler, ioKeyCard
				(gEgo get: ((ScriptID 64037 0) get: 24)) ; oInvHandler, ioMap
			)
			(13
				(= global330 0)
				(= global340 0)
				(gCurRoom newRoom: 340) ; ro340
				(self dispose:)
			)
		)
	)
)

(instance soLiftCrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 3500)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soOnNOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 1000)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(client loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soTorin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 600)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance voDummyBust of View
	(properties)
)

(instance voDummyMouth of View
	(properties)
)

(instance poLarry1 of Prop
	(properties)
)

(instance poLarry2 of Prop
	(properties)
)

(instance poPurser of Prop
	(properties
		priority 300
		x 203
		y 126
		view 34100
		fixPriority 1
	)
)

(instance poGangwayCrowd of Prop
	(properties
		x 87
		y 253
		view 13000
	)
)

(instance poShipCrowd of Prop
	(properties
		x 68
		y 371
		loop 1
		view 13000
	)
)

(instance poWaves of Prop
	(properties
		priority 5
		x 639
		y 469
		cycleSpeed 10
		view 13001
		fixPriority 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance poLiftCrate of Prop
	(properties
		x 420
		y 120
		loop 1
		view 13001
	)
)

(instance voCrowd of View
	(properties
		x 639
		y 479
		loop 2
		view 13001
	)
)

(instance poFlags of Prop
	(properties
		priority 300
		cycleSpeed 10
		loop 9
		view 13001
		fixPriority 1
	)
)

(instance poTorin of Prop
	(properties
		x 367
		y 467
		cycleSpeed 8
		loop 8
		view 13001
	)
)

(instance poGuy of Prop
	(properties
		x 334
		y 470
		loop 7
		view 13001
	)
)

(instance poOnNOff of Prop
	(properties
		y 479
		cycleSpeed 9
		loop 3
		view 13001
	)
)

(instance aoStroller of Actor
	(properties
		x 269
		y 449
		loop 6
		view 13001
	)

	(method (init)
		(super init:)
		(self
			setLoop: 6 1
			setStep: 1 1
			setSpeed: 15
			setScaler: Scaler 100 76 468 421
			setCycle: Walk
			setMotion: MoveTo 38 416
		)
	)
)

(instance aoWalker of Actor
	(properties
		x 32
		y 390
		loop 5
		view 13001
	)

	(method (init)
		(super init:)
		(self
			setLoop: 5 1
			setPri: 500
			setStep: 2 1
			setSpeed: 15
			setScaler: Scaler 100 73 408 379
			setCycle: Walk
			setMotion: MoveTo 97 378 self
		)
	)
)

(instance poFullThygh of Prop
	(properties
		priority 3
		x 453
		y 467
		view 13301
		fixPriority 1
	)
)

(instance poFullThyghArm of Prop
	(properties
		priority 5
		x 453
		y 467
		cel 1
		view 13301
		fixPriority 1
	)
)

(instance poWheelchair of Prop
	(properties
		priority 2
		x 453
		y 467
		view 13311
		fixPriority 1
	)
)

(instance poMrBoning of Prop
	(properties
		priority 4
		x 453
		y 467
		cycleSpeed 9
		loop 1
		view 13311
		fixPriority 1
	)
)

(instance poWheelchairOut of Prop
	(properties
		priority 500
		x 453
		y 467
		view 13321
		fixPriority 1
	)
)

(instance poBugEyeLarry of Prop
	(properties
		priority 1
		x 453
		y 467
		loop 2
		view 13302
		fixPriority 1
	)
)

(instance voWallPhone of View
	(properties
		priority 330
		x 468
		y 260
		view 34150
		fixPriority 1
	)
)

(instance voDeskPhone of View
	(properties
		priority 270
		x 245
		y 189
		view 34105
		fixPriority 1
	)
)

(instance voAnnouncer of View
	(properties
		x 373
		y 197
		view 34104
	)
)

(instance voTitle of View
	(properties
		priority 500
		x 317
		y 298
		view 13075
		fixPriority 1
	)
)

(instance toLarryTalker of Talker
	(properties
		x 248
		y 322
		view 13300
	)

	(method (init)
		(if local1
			(super init: poLarryMouth poLarryBust poLarryEyes)
		else
			(super init: poLarryMouth poLarryBust 0)
		)
	)

	(method (dispose)
		(if local2
			(super dispose: 1)
		else
			(super dispose: 0)
		)
	)
)

(instance poLarryMouth of Prop
	(properties
		loop 1
		view 13300
	)

	(method (init)
		(self view: (toLarryTalker view:))
		(self posn: (toLarryTalker x:) (toLarryTalker y:))
		(self setPri: (+ (poLarryBust priority:) 5))
		(super init: &rest)
	)
)

(instance poLarryBust of Prop
	(properties
		view 13300
	)

	(method (init)
		(self view: (toLarryTalker view:))
		(self posn: (toLarryTalker x:) (toLarryTalker y:))
		(self setPri: 400)
		(super init: &rest)
	)
)

(instance poLarryEyes of Prop
	(properties
		loop 2
		view 13300
	)

	(method (init)
		(self view: (toLarryTalker view:))
		(self posn: (toLarryTalker x:) (toLarryTalker y:))
		(self setPri: 410)
		(super init: &rest)
		(self setCycle: Blink 10)
		(self cycleSpeed: 6)
	)
)

(instance toThyghTalker of Talker
	(properties
		x 296
		y 264
		view 13330
	)

	(method (init)
		(if local3
			(super init: poThyghMouth poThyghBust poThyghEyes)
		else
			(super init: poThyghMouth poThyghBust 0)
		)
	)

	(method (dispose)
		(if local4
			(super dispose: 1)
		else
			(super dispose: 0)
		)
	)
)

(instance poThyghMouth of Prop
	(properties
		loop 1
		view 13330
	)

	(method (init)
		(self view: (toThyghTalker view:))
		(self loop: (+ (toThyghTalker loop:) 1))
		(self posn: (toThyghTalker x:) (toThyghTalker y:))
		(self setPri: (+ (poThyghBust priority:) 5))
		(super init: &rest)
	)
)

(instance poThyghBust of Prop
	(properties
		view 13330
	)

	(method (init)
		(self view: (toThyghTalker view:))
		(self loop: (toThyghTalker loop:))
		(self posn: (toThyghTalker x:) (toThyghTalker y:))
		(self setPri: 400)
		(super init: &rest)
	)
)

(instance poThyghEyes of Prop
	(properties
		loop 1
		view 13330
	)

	(method (init)
		(self view: (toThyghTalker view:))
		(self loop: (+ (toThyghTalker loop:) 2))
		(self posn: (toThyghTalker x:) (toThyghTalker y:))
		(self setPri: (+ (poThyghBust priority:) 10))
		(super init: &rest)
		(self setCycle: Blink 10)
		(self cycleSpeed: 6)
	)
)

(instance toPurser of Talker
	(properties)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(super init: poPurserMouth voPurserBust)
		(poPurser hide:)
	)

	(method (dispose)
		(poPurser show:)
		(super dispose:)
	)
)

(instance poPurserMouth of Prop
	(properties
		loop 1
		view 34102
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self setPri: (+ (poPurser priority:) 1))
		(super init: &rest)
	)
)

(instance voPurserBust of View
	(properties
		view 34102
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self setPri: (poPurser priority:))
		(super init: &rest)
		(poPurserEyebrows init:)
	)

	(method (dispose)
		(poPurserEyebrows dispose:)
		(super dispose: &rest)
	)
)

(instance poPurserEyebrows of Prop
	(properties
		loop 2
		view 34102
	)

	(method (init)
		(= x (poPurser x:))
		(= y (poPurser y:))
		(self cel: (Random 0 2) setPri: (+ (poPurser priority:) 2))
		(super init: &rest)
		(self setScript: soEyebrows)
	)

	(method (dispose)
		(self setScript: 0)
		(super dispose: &rest)
	)
)

(instance soEyebrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 50 100))
			)
			(1
				(switch (client cel:)
					(0
						(client cel: (Random 1 2))
					)
					(1
						(if (Random 1 2)
							(client cel: 0)
						else
							(client cel: 2)
						)
					)
					(else
						(client cel: (Random 0 1))
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance toLarryTalker1 of Talker
	(properties)

	(method (init)
		(super init: poTalkMouth voTalkBody)
		(poLarry1 hide:)
	)

	(method (dispose)
		(poLarry1 show:)
		(super dispose: &rest)
	)
)

(instance poTalkMouth of Prop
	(properties
		loop 3
		view 60113
	)

	(method (init)
		(= x (poLarry1 x:))
		(= y (poLarry1 y:))
		(self setPri: (+ (poLarry1 priority:) 1))
		(self
			scaleSignal: 1
			scaleX: (poLarry1 scaleX:)
			scaleY: (poLarry1 scaleY:)
			maxScale: (poLarry1 maxScale:)
		)
		(super init: &rest)
	)
)

(instance voTalkBody of View
	(properties
		loop 1
		view 60113
	)

	(method (init)
		(= x (poLarry1 x:))
		(= y (poLarry1 y:))
		(self setPri: (+ (poLarry1 priority:) 1))
		(self
			scaleSignal: 1
			scaleX: (poLarry1 scaleX:)
			scaleY: (poLarry1 scaleY:)
			maxScale: (poLarry1 maxScale:)
		)
		(super init: &rest)
	)
)

(instance oCredits of TextItem
	(properties
		priority 600
		fixPriority 1
		font 7
		fore 72
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBL of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBT of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBR of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oCreditBB of TextItem
	(properties
		priority 595
		fixPriority 1
		font 7
		maxWidth 560
	)

	(method (init)
		(= back skip)
		(super init: &rest)
	)
)

(instance oEventHandler of EventCode
	(properties)

	(method (handleEvent event)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(event claimed: 1)
			(gOEventHandler unregisterGlobalHandler: self)
			(localproc_2)
			(gCurRoom setScript: soWelcomeAboard)
		)
		(event claimed:)
	)
)

