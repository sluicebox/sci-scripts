;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Styler)
(use Str)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
	Chaplain 1
	Roger 2
)

(local
	local0 = 7
	local1 = 1
	local2 = 1
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 &tmp temp0)) ; UNUSED

(instance rm410 of SQRoom
	(properties
		noun 13
		picture 410
		exitStyle 0
	)

	(method (init)
		(= global175 2)
		(= local5 (gEgo moveSpeed:))
		(= local4 (Str newWith: 200 {}))
		(gEgo
			view: 413
			posn: 78 130
			setLoop: 0
			setCel: 0
			setScaler: Scaler 100 83 126 95
			cycleSpeed: local0
			get: 41 ; Eulogy
			put: 28 ; Dead_Fish
			get: 29 ; Dead_Fish2
			init:
		)
		(gEgo state: (& (gEgo state:) $fffd))
		(super init:)
		(gGSound1 number: 410 setLoop: -1 play: setVol: 127)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 138 319 138 319 121 296 115 287 105 291 95 319 95 319 70 306 69 288 69 287 78 271 78 270 71 239 74 205 73 203 77 190 77 187 72 157 65 151 74 134 74 135 58 116 48 103 58 80 58 83 50 96 50 98 46 92 46 90 43 59 44 57 46 32 49 31 60 2 60 2 95 94 95 95 110 89 119 61 120 49 125 24 125 0 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 268 122 253 119 253 113 265 110 271 110 281 113 281 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 252 108 238 108 233 104 234 100 241 99 251 99 258 102 257 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 223 102 210 102 205 98 205 95 213 93 221 93 226 96 226 99
					yourself:
				)
		)
		(cond
			((and (== gPrevRoomNum 460) (or (== global119 0) (== global119 410)))
				(gEgo posn: 39 131 setHeading: 270)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: sExitThruComPost)
			)
		)
		(holoControls init:)
		(compost init:)
		(tubeTop init:)
		(tubeBottom init:)
		(tree1 init:)
		(tree2 init:)
		(sky1 init:)
		(sky2 init:)
		(blueFlower init:)
		(yellowFlower init:)
		(digger init:)
		(chaplain init:)
		(ratBoy init:)
		(kielbasa init:)
		(dorff init:)
		(extras init:)
		(extra1 init:)
		(extra2 init:)
		(coffin init:)
		(self setScript: sFuneral)
		(Styler changeDivisions: 200)
		(Load rsVIEW 411)
		(Load rsVIEW 4110)
		(Load rsVIEW 4112)
		(Load rsVIEW 4111)
		(PalCycle 0 111 114 -1 5) ; Start
	)

	(method (dispose)
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance sFadeEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (>= (section1 cel:) 2)
					(PalVary 0 400 0 (* (- (section1 cel:) 1) 10) 64 79) ; PalVaryStart
				)
				(self changeState: (- state 1))
			)
		)
	)
)

(instance Roger of SmallTalker
	(properties
		talkView 413
		talkLoop 1
	)

	(method (init)
		(self talkLoop: (+ local1 1))
		(= client gEgo)
		(super init:)
	)
)

(instance sDoCrossFade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 0 setPri: 400 setScript: sFadeEgo)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGSound1 fade: 0 1 2 1)
				(section1 setCycle: End)
				(section2 setCycle: End)
				(section3 setCycle: End)
				(section4 setCycle: End)
				(section5 setCycle: End)
				(section6 setCycle: End self)
			)
			(2
				(PalVary 0 400 0 100) ; PalVaryStart
				(self dispose:)
			)
		)
	)
)

(instance sFuneral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsFONT 50)
				(Load 140 414) ; WAVE
				(Load 140 926) ; WAVE
				(Load rsHEAP 64941)
				(Load rsSCRIPT 64941)
				(section1 init:)
				(section2 init:)
				(= ticks 1)
			)
			(1
				(kielbasa setScript: sKielbasaFidget)
				(dorff setScript: sDorffCleanGlasses)
				(gMessager say: 0 0 1 1 self) ; "It's hard to believe that this is the HoloSuite. The setting is much like the graphics you have scanned in the library from those planets more interesting in their climatic diversity."
			)
			(2
				(Load rsVIEW 4120)
				(Load rsVIEW 414)
				(= ticks 1)
			)
			(3
				(gMessager say: 0 0 1 2 self) ; "From the scenic jutting peaks, soft hills and lake in the conjured distance to the lush pixelized growth of trees, flowers and grass in the foreground, the HoloDeck has that sublime park-like perfection."
			)
			(4
				(Load rsVIEW 361)
				(Load rsVIEW 4192)
				(= ticks 1)
			)
			(5
				(gMessager say: 0 0 1 3 self) ; "Unfortunately, its serene beauty is sadly negated by the headstones and the solemn event about to occur: the laying to rest of your rescuer and true friend, Stellar Santiago."
			)
			(6
				(Load rsVIEW 3660)
				(Load rsVIEW 4171)
				(= ticks 1)
			)
			(7
				(gMessager say: 0 0 1 4 self) ; "You are feeling as you have never felt before. Perhaps helped along by the relatively short stints aboard the various ships, as well as all-too-brief friendships, you've been spared the emotional devastation of true loss by lack of attachment."
			)
			(8
				(Load rsVIEW 4190)
				(= ticks 1)
			)
			(9
				(gMessager sayRange: 0 0 1 5 6 self) ; "This, however, is a different feeling -- far different from anything you've ever experienced. You can't help but wonder how you'd act towards Stellar given a second chance, but you know that can never happen. She gave her life for you and you will never be able to thank her."
			)
			(10
				(section3 init:)
				(Load rsVIEW 418)
				(Load rsVIEW 4141)
				(= ticks 1)
			)
			(11
				(chaplain setScript: sChapTalks self)
			)
			(12
				(section5 init:)
				(Load rsVIEW 417)
				(Load rsVIEW 415)
				(= ticks 1)
			)
			(13
				(gEgo setScript: sRogerTalks self)
			)
			(14
				(Load rsVIEW 416)
				(chaplain
					view: 418
					setLoop: 0
					setCel: 0
					posn: 81 119
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(15
				(section6 init:)
				(Load 140 411) ; WAVE
				(Load 140 413) ; WAVE
				(Load 140 412) ; WAVE
				(digger setScript: sDigHole self)
			)
			(16
				(digger
					view: 4120
					posn: (+ (digger x:) 6) (+ (digger y:) 2)
					setLoop: 0
				)
				(kielbasa setScript: sKielbasaRecover)
				(chaplain setScript: sChaplainRecover)
				(dorff setScript: sDorffRecover)
				(extras hide:)
				(extra1 setScript: sExtra1Leave)
				(extra2 setScript: sExtra2Leave)
			)
			(17
				(section4 init:)
				(chaplain setScript: sChaplainLeaves self)
				(self dispose:)
			)
		)
	)
)

(instance sChaplainLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chaplain
					view: 4121
					posn: (- (chaplain x:) 16) (- (chaplain y:) 2)
					cycleSpeed: (+ local0 2)
					setLoop: 0
					setCel: 1
				)
				(self cue:)
			)
			(1
				(gEgo normalize: 0)
				(chaplain
					setLoop: 1
					setCycle: Walk
					setSpeed: (+ local0 2)
					setMotion: MoveTo 52 126 self
				)
			)
			(2
				(chaplain
					setLoop: 2
					setCel: 0
					setPri: 400
					cycleSpeed: (+ local0 2)
					setCycle: ROsc 1 0 1 self
				)
			)
			(3
				(self setScript: sDoCrossFade self)
			)
			(4
				(chaplain
					setLoop: 1
					setCycle: Walk
					setSpeed: local0
					setMotion: MoveTo 38 130 self
				)
			)
			(5
				(chaplain
					setLoop: 2
					setCel: 0
					cycleSpeed: local0
					setCycle: CT 2 1 self
				)
			)
			(6
				(gGSound2 number: 926 loop: 1 play:)
				(chaplain cycleSpeed: local0 setCycle: End self)
			)
			(7
				(gGame handsOff:)
				(chaplain hide:)
				(= cycles 5)
			)
			(8
				(gGSound2 stop:)
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance sKielbasaLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielbasa
					view: 361
					setCycle: Walk
					setSpeed: local0
					setScaler: Scaler 100 80 126 95
					setMotion: MoveTo 138 125 self
				)
			)
			(1
				(kielbasa
					view: 361
					setCycle: Walk
					setMotion: MoveTo 56 130 self
				)
			)
			(2
				(kielbasa
					view: 4192
					setLoop: 0
					setCel: 0
					posn: 42 131
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(3
				(gGSound2 number: 926 loop: 1 play:)
				(kielbasa
					view: 4192
					setLoop: 1
					setCel: 0
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(4
				(kielbasa hide:)
				(= ticks 1)
			)
			(5
				(gGSound2 stop:)
				(sFuneral cue:)
				(self dispose:)
			)
		)
	)
)

(instance sDorffLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff
					view: 366
					setCycle: Walk
					setSpeed: local0
					setMotion: MoveTo 38 130 self
				)
			)
			(1
				(kielbasa setScript: sKielbasaLeaves)
				(dorff
					view: 3660
					setLoop: 0
					setCel: 0
					cycleSpeed: local0
					setCycle: CT 4 1 self
				)
			)
			(2
				(dorff setCycle: ROsc 2 4 6 self)
			)
			(3
				(dorff setCycle: End)
				(= seconds 2)
			)
			(4
				(gGSound2 number: 926 loop: 1 play:)
				(dorff
					view: 3660
					setLoop: 1
					setCel: 0
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(5
				(gGSound2 stop:)
				(dorff dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFadeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(digger
					view: 4191
					posn: (- (digger x:) 4) (- (digger y:) 2)
					setCycle: End self
				)
			)
			(1
				(digger dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sExtra1Leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extra1 show: cycleSpeed: local0 setCycle: End self)
			)
			(1
				(extra1
					view: 4171
					setLoop: 1 1
					posn: 180 114
					setScaler: Scaler 100 81 126 95
					setSpeed: local0
					setCycle: Walk
					setMotion: MoveTo 110 121 self
				)
			)
			(2
				(extra2 cue:)
				(extra1 setSpeed: local0 setMotion: MoveTo 38 127 self)
			)
			(3
				(extra1
					posn: (- (extra1 x:) 3) (+ (extra1 y:) 2)
					view: 419
					setLoop: 0
					setCel: 0
					cycleSpeed: local0
					setCycle: CT 5 1 self
				)
			)
			(4
				(gGSound2 number: 926 loop: 1 play:)
				(extra1 cycleSpeed: local0 setCycle: End self)
			)
			(5
				(gGSound2 stop:)
				(digger setScript: sFadeOut)
				(kielbasa setScript: sKielbasaFidget)
				(extra1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sExtra2Leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extra2 show:)
				(extra2 cycleSpeed: (+ local0 4) setCycle: End self)
			)
			(1)
			(2
				(extra2
					view: 4171
					setLoop: 0 1
					posn: 198 104
					setScaler: Scaler 100 81 126 95
					setSpeed: local0
					setCycle: Walk
					setMotion: MoveTo 150 120 self
				)
			)
			(3
				(dorff setScript: sDorffLeaves)
				(extra2 setMotion: MoveTo 38 127 self)
			)
			(4
				(extra2
					view: 4190
					posn: (- (extra2 x:) 3) (+ (extra2 y:) 2)
					setLoop: 0
					setCel: 0
					cycleSpeed: local0
					setCycle: CT 4 1 self
				)
			)
			(5
				(gGSound2 number: 926 loop: 1 play:)
				(extra2 cycleSpeed: local0 setCycle: End self)
			)
			(6
				(gGSound2 stop:)
				(kielbasa setScript: sKielbasaLeaves)
				(extra2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDorffRecover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff
					view: 4160
					setLoop: 0
					cycleSpeed: (+ local0 3)
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(dorff view: 411 setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance sChaplainRecover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chaplain
					view: 418
					setLoop: 1
					setCel: 1000
					cycleSpeed: (+ local0 3)
					setCycle: Beg self
				)
			)
			(1
				(gEgo show:)
				(chaplain
					view: 418
					setLoop: 0
					setCel: 1000
					posn: (+ (chaplain x:) 1) (chaplain y:)
					cycleSpeed: (+ local0 3)
					setCycle: Beg self
				)
			)
			(2
				(chaplain view: 412 loop: 1 posn: 98 121 setCel: 1000)
				(self dispose:)
			)
		)
	)
)

(instance sKielbasaRecover of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielbasa
					view: 415
					setLoop: 0
					cycleSpeed: (+ local0 3)
					cel: 1000
					setCycle: Beg self
				)
			)
			(1
				(kielbasa view: 411 setLoop: 2)
				(self dispose:)
			)
		)
	)
)

(instance sDigHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(digger view: 4120 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 110)
			)
			(2
				(coffin view: 414 cel: 0 loop: 1)
				(gGSound2 number: 411 setLoop: 0 play:)
				(digger
					view: 414
					setLoop: 0
					setCel: 0
					posn: (- (digger x:) 6) (- (digger y:) 2)
					cycleSpeed: (+ local0 4)
					setCycle: CT 2 1 self
				)
			)
			(3
				(ratBoy setScript: sRatBoySuckedOut)
				(chaplain setScript: sChapHangOn)
				(extras setScript: sExtrasHangOn)
				(digger cycleSpeed: local0 setCycle: End self)
			)
			(4
				(gGSound2 number: 412 setLoop: 0 play:)
				(kielbasa setScript: sKielbasaHangOn)
				(dorff setScript: sDorffHangOn)
				(coffin setScript: sCoffinSuckedOut self)
			)
			(5
				(= ticks 40)
			)
			(6
				(grave dispose:)
				(gGSound2 number: 413 setLoop: 0 play:)
				(digger
					view: 4141
					cycleSpeed: (+ local0 8)
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(7
				(gGSound2 stop:)
				(digger setCycle: End self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance sCoffinSuckedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coffin
					view: 414
					setLoop: 1
					cycleSpeed: (- local0 1)
					setCycle: End self
				)
			)
			(1
				(grave init:)
				(= seconds 3)
			)
			(2
				(coffin hide:)
				(self dispose:)
			)
		)
	)
)

(instance sDorffCleanGlasses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff view: 411 setLoop: 0)
				(= seconds (proc0_8 15 20))
			)
			(1
				(if local2
					(dorff setLoop: 1 cycleSpeed: local0 setCycle: End self)
				else
					(self changeState: 0)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sKielbasaFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(kielbasa view: 411 setLoop: 2)
				(= seconds 6)
			)
			(2
				(if local2
					(kielbasa
						view: 4112
						setLoop: 0
						cycleSpeed: local0
						setCycle: End self
					)
				else
					(= ticks 100)
				)
			)
			(3
				(kielbasa view: 411 setLoop: 2)
				(= seconds 8)
			)
			(4
				(if local2
					(kielbasa
						view: 4110
						setLoop: 0
						cycleSpeed: local0
						setCycle: End self
					)
				else
					(self changeState: (+ state 3))
				)
			)
			(5
				(kielbasa setLoop: 1 cycleSpeed: local0 setCycle: Fwd)
				(= seconds 2)
			)
			(6
				(kielbasa
					view: 4110
					setLoop: 0
					cycleSpeed: local0
					setCel: 1000
					setCycle: Beg self
				)
			)
			(7
				(kielbasa view: 411 setLoop: 2)
				(= seconds 10)
			)
			(8
				(if local2
					(kielbasa
						view: 4110
						setLoop: 2
						cycleSpeed: local0
						setCycle: End self
					)
				else
					(self changeState: (+ state 3))
				)
			)
			(9
				(kielbasa setLoop: 3 cycleSpeed: local0 setCycle: Fwd)
				(= seconds 4)
			)
			(10
				(kielbasa
					view: 4110
					setLoop: 0
					cycleSpeed: local0
					setCel: 1000
					setCycle: Beg self
				)
			)
			(11
				(kielbasa view: 411 setLoop: 2)
				(= seconds 2)
			)
			(12
				(if local2
					(kielbasa
						view: 4111
						setLoop: 0
						cycleSpeed: local0
						setCycle: End self
					)
				else
					(self changeState: 1)
				)
			)
			(13
				(self changeState: 1)
			)
		)
	)
)

(instance Chaplain of SmallTalker
	(properties
		talkView 412
	)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Chapelain})
			)
			(49
				(= name {Pfarrer})
			)
			(else
				(= name {Chaplain})
			)
		)
		(= client chaplain)
		(super init:)
	)
)

(instance sChapTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chaplain cycleSpeed: (+ local0 2) setCycle: Fwd)
				(gMessager say: 19 0 3 0 self) ; "Ladies and/or gentleman, we assemble here today to honor the memory of a former crewmate, Lieutenant First Class Stellar Santiago. Her unfortunate death takes place in the shadow of a new community, the dawning of a new life for the aged of our galaxy."
			)
			(1
				(chaplain
					setLoop: 1
					setCel: 0
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sRogerTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo cycleSpeed: local0 setCycle: CT 13 1 self)
			)
			(1
				(gGSound2 number: 414 setLoop: 0 play:)
				(gEgo cycleSpeed: local0 setCycle: End self)
			)
			(2
				(gEgo
					normalize: 0
					setSpeed: local0
					setMotion: MoveTo 108 119 self
				)
			)
			(3
				(gEgo view: 413 setLoop: 0 setCel: 0 setCycle: 0)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				((gInventory at: 41) select: 0 1) ; Eulogy
				(gTheIconBar show:)
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(4
				(SetFlag 41)
				(gEgo
					view: 413
					setLoop: local1
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(5
				(gGame points: 3)
				(gTheIconBar enable: 0)
				(gGame handsOff:)
				(= seconds 1)
			)
			(6
				(gMessager say: 19 0 4 1 self) ; "Uh ..."
			)
			(7
				(gMessager say: 19 0 4 2 self) ; "I only knew Stellar for, uh, a short time. I wish I, uh, could have gotten to know her much, uh, much, uh, better, to have had a deeper understanding of this, uh, person I was proud to have called ... friend."
			)
			(8
				(gMessager say: 19 0 4 3 self) ; "Of my friend I can say only say this: Of all the soles I have encountered in my cleaning, (EMOTIONAL PAUSE) hers were the most scu... (VOICE BREAKING) SCUFF-RESISTANT!"
			)
			(9
				(if local6
					(gTextScroller addString: {} 50 84 0)
					(gTextScroller addString: {} gUserFont 82 0)
					(= local6 0)
				)
				(= local2 1)
				(gEgo
					view: 413
					setLoop: 1
					cycleSpeed: (+ local0 2)
					setCel: 1000
					setCycle: Beg self
				)
			)
			(10
				(gEgo setSpeed: local5)
				(self dispose:)
			)
		)
	)
)

(instance sChapHangOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(chaplain
					view: 418
					setLoop: 1
					setCel: 0
					posn: (- (chaplain x:) 1) (chaplain y:)
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(1
				(chaplain setLoop: 2 setCel: 0 cycleSpeed: local0 setCycle: Fwd)
			)
		)
	)
)

(instance sDorffHangOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dorff
					view: 416
					setLoop: 0
					setCel: 0
					cycleSpeed: local0
					setCycle: End self
				)
			)
			(1
				(dorff setLoop: 1 setCel: 0 cycleSpeed: local0 setCycle: Fwd)
			)
		)
	)
)

(instance sKielbasaHangOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kielbasa
					view: 415
					setLoop: 0
					cycleSpeed: local0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(kielbasa setLoop: 1 setCel: 0 cycleSpeed: local0 setCycle: Fwd)
			)
		)
	)
)

(instance sExtrasHangOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extras
					view: 417
					setLoop: 1
					cycleSpeed: local0
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(extras
					cycleSpeed: local0
					setCycle: ROsc -1 4 (extras lastCel:)
				)
			)
		)
	)
)

(instance sRatBoySuckedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(ratBoy cycleSpeed: (+ local0 8) setCel: 0 setCycle: End)
			)
			(2
				(ratBoy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 39 131
					setSpeed: local0
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: cel: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 3)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 39 131
					setSpeed: local0
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: global119)
				(self dispose:)
			)
		)
	)
)

(instance section1 of Actor
	(properties
		x 1
		y 68
		priority 300
		fixPriority 1
		view 410
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance section2 of Actor
	(properties
		x 1
		y 70
		scaleX 0
		scaleY 0
		priority 300
		fixPriority 1
		view 4101
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance section3 of Actor
	(properties
		x 108
		y 67
		scaleX 0
		scaleY 0
		priority 300
		fixPriority 1
		view 4102
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance section4 of Actor
	(properties
		x 108
		y 69
		scaleX 0
		scaleY 0
		priority 300
		fixPriority 1
		view 4103
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance section5 of Actor
	(properties
		x 214
		y 67
		scaleX 0
		scaleY 0
		priority 300
		fixPriority 1
		view 4104
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance section6 of Actor
	(properties
		x 213
		y 69
		scaleX 0
		scaleY 0
		priority 300
		fixPriority 1
		view 4105
		signal 16385
		cycleSpeed 3
	)

	(method (init)
		(super init:)
	)
)

(instance extra1 of Actor
	(properties
		noun 8
		view 4170
		signal 20513
	)

	(method (init)
		(super init:)
		(self setLoop: 0 posn: 205 103 hide:)
	)

	(method (cue)
		(self show: cycleSpeed: local0 setCycle: End)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Pay no attention to them. They're just extras we hired to fill the room."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance extra2 of Actor
	(properties
		noun 8
		view 4170
		signal 20513
	)

	(method (init)
		(super init:)
		(self setLoop: 1 posn: 205 103 hide:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "Pay no attention to them. They're just extras we hired to fill the room."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dorff of Actor
	(properties
		noun 7
		view 411
		signal 20513
	)

	(method (init)
		(self posn: 260 120 setLoop: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "It's a funeral. Act appropriately."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "That's Dorff, the DeepShip's nearsighted and relatively clueless security chief."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kielbasa of Actor
	(properties
		noun 11
		view 411
		signal 20513
	)

	(method (init)
		(self posn: 229 108 setLoop: 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "Come on! You know him!"
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chaplain of Actor
	(properties
		noun 2
		view 412
		signal 20513
	)

	(method (init)
		(self posn: 98 121 setLoop: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "It's your average, everyday HoloChaplain. Stunningly real, don't you think?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ratBoy of Actor
	(properties
		noun 20
		view 417
		signal 20513
	)

	(method (init)
		(self posn: 166 104 setLoop: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 8 theVerb) ; "Pay no attention to them. They're just extras we hired to fill the room."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance extras of Actor
	(properties
		noun 8
		view 417
		signal 20513
	)

	(method (init)
		(self posn: 205 103 setLoop: 1)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "Pay no attention to them. They're just extras we hired to fill the room."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance digger of Actor
	(properties
		noun 6
		view 4120
		signal 20513
	)

	(method (init)
		(self setLoop: 0 posn: 131 95)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "There's the holographic gravedigger. His program certainly is low-key."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb) ; "This is no time to pick a conversation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coffin of Actor
	(properties
		noun 3
		view 4100
		signal 20513
	)

	(method (init)
		(self posn: 165 120 18)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "No, that's more than you are up to at this time. All you really want to touch is the spleen of whoever did this to Stellar!"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Geez, the coffin. The true gravity of Stellar's death hits you in the, er, stomach, nearly making you physically ill. It's really true."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grave of View
	(properties
		noun 10
		x 126
		y 93
		view 4142
		signal 20513
	)

	(method (init)
		(self setPri: 20)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; MISSING MESSAGE
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Stellar's coffin sits awaiting the finish of the service."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holoControls of Feature
	(properties
		noun 5
		x 40
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 32 70 49 70 49 95 32 99 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Wouldn't it be fun to see everyone's reactions if you turned off the program. You quickly lose the thought and remember Stellar."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is the control panel for the HoloSuite from which this setting was recreated."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance compost of Feature
	(properties
		noun 4
		sightAngle 40
		approachX 39
		approachY 131
		x 38
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 18 85 30 83 30 93 18 95 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "You would leave Stellar's funeral?!"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is the standard ComPost. It's the only other thing that detracts from the nearly perfect scene before your eyes."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubeTop of Feature
	(properties
		noun 16
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 0 55 0 55 15 44 17 29 17 20 15
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is the intake/exhaust tube for the on-ship transporter. This is what sucks you here and there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tubeBottom of Feature
	(properties
		noun 18
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 132 28 132 43 132 51 132 56 129 52 127 47 126 31 126 25 126 19 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is the tube bottom."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tree1 of Feature
	(properties
		noun 15
		sightAngle 40
		x 68
		y 57
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 0 131 10 117 8 100 2 84 4 78 66 80 79 80 98 87 113 66 115 69 65 67 65 67 30 64 20 53 23 53 42 55 45 47 45 43 101 46 124 33 123 34 46 28 48 24 50 23 48 0 48 0 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Visually perfect trees -- described by some higher handicap types as Golfball Trajectory Adjusters -- add a beauty and serenity to the setting. Yes, Stellar would have liked this. (Especially if she weren't the center of attention.)"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Visually perfect trees -- described by some higher handicap types as Golfball Trajectory Adjusters -- add a beauty and serenity to the setting. Yes, Stellar would have liked this. (Especially if she weren't the center of attention.)"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tree2 of Feature
	(properties
		noun 15
		sightAngle 40
		x 244
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 0 187 11 199 8 201 10 196 16 180 24 194 26 203 19 214 8 216 10 214 30 215 59 209 89 211 98 222 100 221 45 222 35 228 21 228 15 231 9 234 16 232 23 246 20 240 105 255 106 252 94 255 76 252 59 254 43 253 13 264 8 258 26 265 33 257 117 276 118 274 27 292 24 292 80 291 83 291 108 306 109 306 98 302 80 304 71 301 68 302 18 307 22 308 116 320 113 320 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Visually perfect trees -- described by some higher handicap types as Golfball Trajectory Adjusters -- add a beauty and serenity to the setting. Yes, Stellar would have liked this. (Especially if she weren't the center of attention.)"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Visually perfect trees -- described by some higher handicap types as Golfball Trajectory Adjusters -- add a beauty and serenity to the setting. Yes, Stellar would have liked this. (Especially if she weren't the center of attention.)"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sky1 of Feature
	(properties
		noun 14
		sightAngle 40
		x 86
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 40 74 27 92 19 99 19 105 26 107 26 118 0 55 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sky2 of Feature
	(properties
		noun 14
		sightAngle 40
		x 224
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 0 129 11 131 24 133 28 138 15 141 11 145 9 151 8 151 19 154 19 158 22 160 31 161 31 166 7 170 7 176 12 181 30 187 33 189 38 194 40 198 41 202 39 207 30 210 27 214 27 225 31 235 38 241 36 244 35 274 39 281 39 292 35 307 30 320 30 320 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; MISSING MESSAGE
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "The sky is the proverbial azure that so many humans find soothing and reminiscent of home (unless, of course, they're from LA or Denver)."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blueFlower of Feature
	(properties
		noun 1
		sightAngle 40
		x 33
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 95 5 100 9 104 14 102 16 108 31 101 31 123 48 124 44 99 51 98 52 84 64 102 67 100 66 120 50 126 37 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "No, they are not available for picking. You weren't going to try to pick up someone at the funeral, were you?"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "The blue flowers, and all of them for that matter, are typical of the HoloSuite's incredible attention to detail."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yellowFlower of Feature
	(properties
		noun 17
		sightAngle 40
		x 293
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 139 318 138 315 120 320 119 320 110 306 110 303 122 302 136 294 136 293 128 291 121 286 108 281 133 271 123 267 124 272 139
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "No, they are not available for picking. You weren't going to try to pick up someone at the funeral, were you?"
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "The yellow flowers, even though synthetically created, are very reminiscent of ones you once witnessed in a hallucination."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

