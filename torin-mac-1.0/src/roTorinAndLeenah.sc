;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30300)
(include sci.sh)
(use Main)
(use oInterface)
(use oHandsOnWhenCued)
(use TPSound)
(use SoTwinkle)
(use CueMe)
(use n64896)
(use Talker)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	roTorinAndLeenah 0
)

(local
	nZoomStart = 128
	nZoomAmt = 1
	nZoomEnd = 64
	nZoomDelay = 16
	nXShiftAmt = 1
	shiftActors
	boogleX
	boogleY
	torinX
	torinY
	leenahX
	leenahY
	hideSmetanaTalker
	wf0x = 21
	wf0y = 267
	wf1x = 120
	wf1y = 314
	wf2x = 196
	wf2y = 249
	wf3x = 239
	wf3y = 211
	wf4x = 294
	wf4y = 247
	wf5x = 353
	wf5y = 252
	wf6x = 453
	wf6y = 249
	wf7x = 608
	wf7y = 250
	wf8x = 526
	wf8y = 212
)

(procedure (WaterFalls initOrDispose)
	(if (== initOrDispose 1)
		(poWaterfall0 dispose:)
		(poWaterfall1 dispose:)
		(poWaterfall2 dispose:)
		(poWaterfall4 dispose:)
		(poWaterfall6 dispose:)
		(poWaterfall8 dispose:)
		(if (not (SlowVideo))
			(poWaterfall3 dispose:)
			(poWaterfall5 dispose:)
			(poWaterfall7 dispose:)
		)
	else
		(poWaterfall0 posn: wf0x wf0y setScale: 0 init:)
		(poWaterfall1 posn: wf1x wf1y setScale: 0 init:)
		(poWaterfall2 posn: wf2x wf2y setScale: 0 init:)
		(poWaterfall4 posn: wf4x wf4y setScale: 0 init:)
		(poWaterfall6 posn: wf6x wf6y setScale: 0 init:)
		(poWaterfall8 posn: wf8x wf8y setScale: 0 init:)
		(if (not (SlowVideo))
			(poWaterfall3 posn: wf3x wf3y setScale: 0 init:)
			(poWaterfall5 posn: wf5x wf5y setScale: 0 init:)
			(poWaterfall7 posn: wf7x wf7y setScale: 0 init:)
		)
	)
)

(instance voIntroScene of View
	(properties
		view 30309
	)
)

(instance poPixelSmetana of Prop
	(properties
		x 319
		y 316
		view 30304
		loop 1
	)
)

(instance poSmetanaBody of Prop
	(properties
		x 338
		y 168
		priority 168
		fixPriority 168
		view 30201
		loop 1
	)
)

(instance toSmetana of Talker
	(properties
		x 338
		y 168
		view 30201
		loop 1
		priority 169
	)

	(method (init)
		(super init: &rest)
		(if hideSmetanaTalker
			(mouth hide:)
		)
		(poSmetanaBody hide:)
	)

	(method (dispose)
		(super dispose:)
		(if (not hideSmetanaTalker)
			(poSmetanaBody show:)
		)
	)
)

(instance poBoogle of Prop
	(properties
		x 106
		y 326
		view 30301
		loop 1
	)
)

(instance poLeenah of Actor
	(properties
		x 187
		y 304
		view 30350
	)
)

(instance poLeenahBust of Prop
	(properties
		x 150
		y 316
		priority 10
		fixPriority 1
		view 30308
	)
)

(instance poLeenahLips of Prop
	(properties
		x 150
		y 316
		priority 11
		fixPriority 1
		view 30308
		loop 1
	)
)

(instance poLeenahEyes of Prop
	(properties
		x 150
		y 316
		priority 11
		fixPriority 1
		view 30308
		loop 2
	)
)

(instance toLeenah of Talker
	(properties
		x 150
		y 316
		view 30308
		loop 1
		priority 12
	)

	(method (init)
		(super init: &rest)
		(poLeenahLips hide:)
	)

	(method (dispose)
		(super dispose: &rest)
		(poLeenahLips show:)
	)
)

(instance poTorin of Prop
	(properties
		x 131
		y 276
		view 30302
		loop 1
	)
)

(instance poTorinBust of Prop
	(properties
		x 150
		y 316
		priority 10
		fixPriority 1
		view 60110
	)
)

(instance poTorinLips of Prop
	(properties
		x 150
		y 316
		priority 11
		fixPriority 1
		view 60110
		loop 1
	)
)

(instance poTorinEyes of Prop
	(properties
		x 150
		y 316
		priority 11
		fixPriority 1
		view 60110
		loop 2
	)
)

(instance toTorin of Talker
	(properties
		x 150
		y 316
		view 60110
		loop 1
		priority 12
	)

	(method (init)
		(super init: &rest)
		(poTorinLips hide:)
	)

	(method (dispose)
		(super dispose: &rest)
		(poTorinLips show:)
	)
)

(instance soBoogle of Script
	(properties)

	(method (changeState newState &tmp newX)
		(switch (= state newState)
			(0
				(goSound1 preload: 60011)
				(poBoogle setCycle: ForwardCounter 2 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(poBoogle setCel: 0 setLoop: 2 setCycle: CT 9 1 self)
			)
			(3
				(goSound1 playSound: 60011)
				(poBoogle setCycle: End self)
			)
			(4
				(gEgo get: ((ScriptID 64001 1) get: 5)) ; oBoogleHandler, ioBoogleRedCross
				(poBoogle dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLeenah of Script
	(properties)

	(method (changeState newState &tmp newX)
		(switch (= state newState)
			(0
				(poLeenah setCycle: End self)
				(self setScript: soBoogle self)
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soZoomAndPan of Script
	(properties)

	(method (changeState newState &tmp newX)
		(switch (= state newState)
			(0
				(= nZoomStart 128)
				(= nZoomEnd 64)
				(= nZoomAmt 1)
				(= nXShiftAmt 8)
				(if (SlowVideo)
					(= nZoomAmt 2)
					(= nXShiftAmt 16)
				)
				(= torinX 262)
				(= torinY 552)
				(= leenahX 374)
				(= leenahY 608)
				(= boogleX 212)
				(= boogleY 644)
				(= shiftActors 0)
				(voIntroScene
					x: -315
					setScale:
					maxScale: 128
					scaleX: nZoomStart
					scaleY: nZoomStart
					init:
				)
				(= ticks nZoomDelay)
			)
			(1
				(-= nZoomStart nZoomAmt)
				(= nZoomStart (Max nZoomStart nZoomEnd))
				(if (> (= newX (+ (voIntroScene x:) nXShiftAmt)) 0)
					(if (not shiftActors)
						(poTorin
							posn:
								(MulDiv torinX nZoomStart 128)
								(MulDiv torinY nZoomStart 128)
							init:
						)
						(poLeenah
							posn:
								(MulDiv torinX nZoomStart 128)
								(MulDiv torinY nZoomStart 128)
							init:
						)
						(poBoogle
							posn:
								(MulDiv torinX nZoomStart 128)
								(MulDiv torinY nZoomStart 128)
							init:
						)
						(= shiftActors 1)
					)
					(= newX 0)
				)
				(if shiftActors
					(poTorin
						posn:
							(MulDiv torinX nZoomStart 128)
							(MulDiv torinY nZoomStart 128)
					)
					(poLeenah
						posn:
							(MulDiv leenahX nZoomStart 128)
							(MulDiv leenahY nZoomStart 128)
					)
					(poBoogle
						posn:
							(MulDiv boogleX nZoomStart 128)
							(MulDiv boogleY nZoomStart 128)
					)
					(if (and (not (poLeenah cycler:)) (<= nZoomStart 70))
						(self setScript: soLeenah self)
					)
				)
				(voIntroScene x: newX scaleX: nZoomStart scaleY: nZoomStart)
				(if (== newX -45)
					(-- nXShiftAmt)
				)
				(= ticks nZoomDelay)
				(if (> nZoomStart nZoomEnd)
					(-- state)
				)
			)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soLine3Leenah of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeenah
					view: 30352
					posn: 447 309
					setLoop: 0
					setCel: 0
					init:
					setCycle: End self
				)
			)
			(1
				(poLeenah setLoop: 1 setCel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance soEyesGoUpEyesGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorinEyes cel: 0)
				(= ticks 130)
			)
			(1
				(poTorinEyes cel: 1)
				(= ticks 75)
			)
			(2
				(poTorinEyes cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance soLine3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 30301 drawPic: 30301)
				(poTorin
					view: 30307
					posn: 162 310
					setLoop: 1
					init:
					setCycle: CT 12 1 self
				)
				(self setScript: soLine3Leenah)
			)
			(1
				(poTorin dispose:)
				(= gtTorin toTorin)
				(poTorinBust
					view: 30307
					loop: 6
					cel: 0
					posn: 212 182
					init:
					setPri: 316
				)
				(poTorinLips
					view: 30307
					loop: 7
					cel: 0
					posn: 212 182
					init:
					setPri: 318
				)
				(poTorinEyes
					view: 30307
					loop: 8
					cel: 0
					posn: 212 182
					init:
					setPri: 317
				)
				(toTorin view: 30307 loop: 7 cel: 0 x: 212 y: 182 priority: 319)
				(gMessager say: 0 0 0 3 self) ; "(TRYING A COMPLIMENT) Oh, I think you're anything but normal."
				(self setScript: soEyesGoUpEyesGoDown self)
			)
			(2)
			(3
				(poLeenah dispose:)
				(poTorinBust dispose:)
				(poTorinEyes dispose:)
				(poTorinLips dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLine4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 30303 drawPic: 30303)
				(= gtLeenah toLeenah)
				(poLeenahBust
					view: 30308
					loop: 0
					cel: 0
					posn: 311 281
					init:
					setPri: 281
				)
				(poLeenahEyes
					view: 30308
					loop: 2
					cel: 0
					posn: 249 107
					init:
					setPri: 284
				)
				(poLeenahLips
					view: 30308
					loop: 1
					cel: 0
					posn: 268 177
					init:
					setPri: 282
				)
				(toLeenah
					view: 30308
					loop: 1
					cel: 0
					x: 268
					y: 177
					priority: 283
				)
				(= ticks 1)
			)
			(1
				(gMessager say: 0 0 0 4 self) ; "(MISUNDERSTANDING) What?! (HURT) Torin!!"
				(= ticks 40)
			)
			(2
				(poLeenahEyes cel: 1)
				(UpdateScreenItem poLeenahEyes)
				(if ticks
					(= ticks 1)
				)
			)
			(3
				(= gtLeenah 0)
				(poLeenahBust dispose:)
				(poLeenahEyes dispose:)
				(poLeenahLips dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soBigBlink of SoTwinkle
	(properties
		minCycle 8
		maxCycle 12
		minDelay 45
		maxDelay 120
	)
)

(instance soLine5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 30302 drawPic: 30302)
				(= gtTorin toTorin)
				(poTorinBust
					view: 60110
					loop: 0
					cel: 0
					posn: 192 266
					init:
					setPri: 315
				)
				(poTorinLips
					view: 60110
					loop: 1
					cel: 0
					posn: 192 266
					init:
					setPri: 316
				)
				(poTorinEyes
					view: 60110
					loop: 2
					cel: 0
					posn: 192 266
					init:
					setPri: 316
					setScript: soBigBlink
				)
				(toTorin view: 60110 loop: 1 cel: 0 x: 192 y: 266 priority: 317)
				(gMessager say: 0 0 0 5 self) ; "Huh? No, no, what I meant was, you're far above normal, you're beautiful... wonderful... perfect!"
			)
			(1
				(= gtTorin 0)
				(poTorinBust dispose:)
				(poTorinEyes dispose:)
				(poTorinLips dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLeenahLine6and7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeenahBust setCycle: End self)
			)
			(1
				(= ticks 90)
			)
			(2
				(poLeenahBust setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soArmsGoUpArmsGoDown of Script
	(properties)

	(method (dispose)
		(poTorinEyes setCycle: 0 cel: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorinEyes setCycle: End self)
			)
			(1
				(= ticks 140)
			)
			(2
				(poTorinEyes setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soLine6and7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 30301 drawPic: 30301)
				(= gtLeenah toLeenah)
				(poLeenahBust
					view: 30306
					loop: 2
					cel: 0
					posn: 351 315
					init:
					setPri: 315
				)
				(poLeenahLips
					view: 30306
					loop: 0
					cel: 0
					posn: 351 315
					init:
					setPri: 316
				)
				(toLeenah
					view: 30306
					loop: 0
					cel: 0
					x: 351
					y: 315
					priority: 317
				)
				(= gtTorin toTorin)
				(poTorinBust
					view: 30307
					loop: 2
					cel: 0
					posn: 169 184
					init:
					setPri: 316
				)
				(poTorinLips
					view: 30307
					loop: 3
					cel: 0
					posn: 169 184
					init:
					setPri: 318
				)
				(toTorin view: 30307 loop: 3 cel: 0 x: 169 y: 184 priority: 319)
				(poTorinEyes
					view: 30307
					loop: 4
					cel: 0
					posn: 169 184
					init:
					setPri: 317
				)
				(gMessager say: 0 0 0 6 self) ; "Oh, Torin. (PAUSES) But my parents must be worried sick."
				(self setScript: soLeenahLine6and7 self)
			)
			(1)
			(2
				(gMessager say: 0 0 0 7 self) ; "Well, yeah, they are. They really want you to return home. And my parents... they're still in danger."
				(self setScript: soArmsGoUpArmsGoDown self)
			)
			(3)
			(4
				(= gtTorin 0)
				(poTorinBust dispose:)
				(poTorinEyes dispose:)
				(poTorinLips dispose:)
				(= gtLeenah 0)
				(poLeenahBust dispose:)
				(poLeenahLips dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLeenahReactLine10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 15)
			)
			(1
				(poLeenah setCycle: CT 2 1 self)
			)
			(2
				(= ticks 30)
			)
			(3
				(poLeenah setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soLine12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 15)
			)
			(1
				(poTorin setCel: 0 setLoop: 3 setCycle: CT 6 1 self)
			)
			(2
				(poLeenah setCycle: CT 2 1 self)
				(poTorin setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soLine8to13 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsPIC 30304)
				(gCurRoom picture: 30305 drawPic: 30305)
				(WaterFalls 0)
				(poLeenah view: 30351 setLoop: 2 posn: 187 304 init:)
				(poLeenah setCel: (poLeenah lastCel:) setCycle: Beg self)
				(poTorin
					view: 30302
					setLoop: 1
					setCel: 0
					posn: 131 276
					init:
					setCycle: CT 6 1 self
				)
				(gMessager say: 0 0 0 8 self) ; "(simultaneously) I must go back / I must go on."
			)
			(1)
			(2)
			(3
				(poTorin setCycle: Beg self)
				(gMessager say: 0 0 0 10 self) ; "(simultaneously) You're right. / You're right."
				(self setScript: soLeenahReactLine10 self)
			)
			(4)
			(5)
			(6
				(gMessager say: 0 0 0 12 self) ; "But, will I see you again?"
				(self setScript: soLine12 self)
			)
			(7)
			(8
				(gMessager say: 0 0 0 13 self) ; "(QUIETLY) You must!"
				(poLeenah setCycle: Beg self)
			)
			(9)
			(10
				(self dispose:)
			)
		)
	)
)

(instance soTandLReactLine14 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 80)
			)
			(1
				(poLeenah setCycle: End self)
				(poTorin setCycle: Beg self)
			)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soSmetanaEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 0 14 self) ; "Excuse me, you two. Will you be staying for dinner? If so, I'd better send out several hunting parties!"
				(poPixelSmetana setCycle: End self)
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soLine14 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gtSmetana toSmetana)
				(= hideSmetanaTalker 1)
				(poPixelSmetana init: setCel: 0 setCycle: CT 9 1 self)
			)
			(1
				(poSmetanaBody init: hide: setScript: soSmetanaEnter self)
				(self setScript: soTandLReactLine14 self)
			)
			(2
				(if (poSmetanaBody script:)
					(WaterFalls 1)
					(poLeenah dispose:)
					(poTorin dispose:)
					(gCurRoom picture: 30304 drawPic: 30304)
					(if (toSmetana mouth:)
						((toSmetana mouth:) show:)
					)
					(= hideSmetanaTalker 0)
					(poPixelSmetana hide:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= gtSmetana 0)
		(poLeenah dispose:)
		(poTorin dispose:)
		(poSmetanaBody dispose:)
		(super dispose:)
	)
)

(instance soTorinLine15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin
					view: 30302
					setLoop: 4
					setCel: 0
					posn: 131 276
					init:
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(poTorin setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(poTorin cycleSpeed: (gGame nGameSpeed:))
				(self dispose:)
			)
		)
	)
)

(instance soTorinUpright of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 60)
			)
			(2
				(poTorin setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTorinUpDownArms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setCel: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(poTorin setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soLine15to17 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WaterFalls 0)
				(gCurRoom picture: 30305 drawPic: 30305)
				(poLeenah view: 30351 setLoop: 1 setCel: 0 posn: 187 304 init:)
				(poPixelSmetana show:)
				(gMessager say: 0 0 0 15 self) ; "No, we've gotta leave immediately. We have to begin our search for a phenocryst."
				(self setScript: soTorinLine15 self)
			)
			(1)
			(2
				(gMessager say: 0 0 0 16 self) ; "Oh, no need. I know right where one is. But, it's pretty far away!"
				(poLeenah setCycle: End self)
				(self setScript: soTorinUpright self)
			)
			(3)
			(4)
			(5
				(poLeenah setCycle: Beg self)
				(gMessager say: 0 0 0 17 self) ; "What? I can't believe it. Does it work?"
				(self setScript: soTorinUpDownArms self)
			)
			(6)
			(7)
			(8
				(poTorin dispose:)
				(poLeenah dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLine18 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPixelSmetana hide:)
				(WaterFalls 1)
				(gCurRoom picture: 30304 drawPic: 30304)
				(= gtSmetana toSmetana)
				(poSmetanaBody init:)
				(gMessager say: 0 0 0 18 self) ; "Weeelllll...it might. You see, it hasn't been used in some time."
			)
			(1
				(= gtSmetana 0)
				(poSmetanaBody dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setCycle: End self)
			)
			(1
				(poTorin dispose:)
				(gEgo
					normalize:
					setScalePercent: 42
					posn: (+ 9 (poTorin x:)) (- (poTorin y:) 2)
					init:
				)
				(self dispose:)
			)
		)
	)
)

(instance soLeenahGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeenah setCycle: End self)
			)
			(1
				(poLeenah
					view: 30303
					posn: 158 276
					setScalePercent: 45
					setLoop: 1
					setCel: 0
				)
				(self dispose:)
			)
		)
	)
)

(instance soLeenahWalkOuttaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeenah
					setLoop: 0
					setStep: 3 1
					setSpeed: 10
					setCycle: Fwd
					setMotion: MoveTo 305 295 self
				)
			)
			(1
				(poLeenah setCycle: 0 setMotion: 0)
				(self dispose:)
			)
		)
	)
)

(instance soWalkOuttaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 190)
				(poLeenah view: 30351 setLoop: 1 setCel: 0 init:)
				(poTorin setLoop: 3 setCel: 0 init:)
				(gMessager say: 0 0 0 19 self) ; "Somehow, I could have guessed that. Let's go, Leenah."
			)
			(1
				(self setScript: soTorinGetUp self)
				(poLeenah setScript: soLeenahGetUp self)
			)
			(2)
			(3
				(gEgo setSpeed: 17 setLoop: 4 1 setMotion: MoveTo 278 310)
				(self setScript: soLeenahWalkOuttaHere)
				(= ticks 1)
			)
			(4
				(= ticks 90)
			)
			(5
				(ActivateGameInventory)
				(self dispose:)
			)
		)
	)
)

(instance soLine19 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPixelSmetana show:)
				(WaterFalls 0)
				(gCurRoom picture: 30305 drawPic: 30305)
				(self setScript: soWalkOuttaHere self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soRunAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soZoomAndPan self)
				(gMessager sayRange: 0 0 0 1 2 self) ; "Everyone in Escarpa said we should meet. But I never dared dream we really would."
			)
			(1)
			(2
				(voIntroScene dispose:)
				(poLeenah dispose:)
				(poTorin dispose:)
				(self setScript: soLine3 self)
			)
			(3
				(self setScript: soLine4 self)
			)
			(4
				(self setScript: soLine5 self)
			)
			(5
				(self setScript: soLine6and7 self)
			)
			(6
				(self setScript: soLine8to13 self)
			)
			(7
				(self setScript: soLine14 self)
			)
			(8
				(self setScript: soLine15to17 self)
			)
			(9
				(self setScript: soLine18 self)
			)
			(10
				(self setScript: soLine19 self)
			)
			(11
				(FadeToBlack 1 10 self)
			)
			(12
				(self dispose:)
				(gCurRoom newRoom: 30400) ; roStarPuzzle
			)
		)
	)
)

(instance oRoomMusic of TPSound
	(properties)
)

(instance coMusicDone of CueMe
	(properties)

	(method (cue)
		(oRoomMusic playSound: 30302)
	)
)

(instance roTorinAndLeenah of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(oRoomMusic newSound: 30300 play: gMusicVol coMusicDone)
		(gCurRoom setScript: soRunAnim)
	)
)

(instance poWaterfall0 of Prop
	(properties
		x 21
		y 267
		priority 1
		fixPriority 1
		view 30305
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall1 of Prop
	(properties
		x 120
		y 314
		priority 1
		fixPriority 1
		view 30305
		loop 1
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall2 of Prop
	(properties
		x 196
		y 249
		priority 1
		fixPriority 1
		view 30305
		loop 2
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall3 of Prop
	(properties
		x 239
		y 211
		priority 1
		fixPriority 1
		view 30305
		loop 3
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall4 of Prop
	(properties
		x 294
		y 247
		priority 1
		fixPriority 1
		view 30305
		loop 4
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall5 of Prop
	(properties
		x 353
		y 252
		priority 1
		fixPriority 1
		view 30305
		loop 5
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall6 of Prop
	(properties
		x 453
		y 249
		priority 1
		fixPriority 1
		view 30305
		loop 6
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall7 of Prop
	(properties
		x 608
		y 250
		priority 1
		fixPriority 1
		view 30305
		loop 7
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

(instance poWaterfall8 of Prop
	(properties
		x 526
		y 212
		priority 1
		fixPriority 1
		view 30305
		loop 8
	)

	(method (init &tmp speed)
		(= cycleSpeed (Random 9 13))
		(super init: &rest setCycle: Fwd)
	)
)

