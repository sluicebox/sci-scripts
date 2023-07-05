;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30400)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use n64896)
(use foEExit)
(use Array)
(use Scaler)
(use RandCycle)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	roStarPuzzle 0
)

(local
	oOstiaryTypes
	oPointLocs
	oPointHolds
	oLinesDone
	oOstiaries
	nEmptyPoint
	nLastClickTime
	nFidgetWaitTime
	bTalking
	nTellEm
	bPuzzleBegun
	bAutoMove
	bFirstScrewup
	[unused 2]
	bArraysInited
)

(procedure (InitArrays &tmp i nID nLoop nHead)
	(= nLastClickTime gGameTime)
	(= nFidgetWaitTime 1800)
	(= oOstiaryTypes (IntArray newWith: 11 0 3 17 5 9 18 6 10 20 24 12))
	(= oPointLocs
		(IntArray
			newWith:
				22
				319
				126
				132
				102
				273
				102
				319
				77
				368
				102
				509
				102
				410
				139
				519
				226
				319
				166
				114
				226
				229
				139
		)
	)
	(= oPointHolds (IntArray newWith: 11 0 1 2 5 6 9 8 4 3 7 10))
	(= nEmptyPoint 0)
	(= oLinesDone (IntArray newWith: 5 0 0 0 0 0))
	(= oOstiaries (Set new:))
	(for ((= i 0)) (< i 10) ((++ i))
		(= nID (+ i 1))
		(= nHead
			(switch (= nLoop (Random 0 7))
				(0 90)
				(1 270)
				(2 180)
				(3 0)
				(4 135)
				(5 225)
				(6 45)
				(7 315)
			)
		)
		(oOstiaries
			addToEnd:
				((Ostiary new:)
					ID: nID
					view: (+ 30410 i)
					heading: nHead
					loop: nLoop
					yourself:
				)
		)
	)
	(for ((= i 0)) (< i 11) ((++ i))
		(if (= nID (oPointHolds at: i))
			((oOstiaries at: (- nID 1))
				nPointOn: i
				nMusic: (+ 30410 (- nID 1))
				posn: (GetLocX i) (GetLocY i)
				init:
				stopwalk:
			)
		)
	)
	(CheckForWin)
)

(procedure (GetLocX nPoint)
	(if (not oPointLocs)
		(PrintDebug {error in GetLocX -- 30400.sc DJM})
		(return 0)
	)
	(return (oPointLocs at: (* nPoint 2)))
)

(procedure (GetLocY nPoint)
	(if (not oPointLocs)
		(PrintDebug {error in GetLocY -- 30400.sc DJM})
		(return 0)
	)
	(return (oPointLocs at: (+ (* nPoint 2) 1)))
)

(procedure (CheckForWin)
	(oLinesDone
		at:
			0
			(&
				(&
					(& (oOstiaryTypes at: (oPointHolds at: 1)) (oOstiaryTypes at: (oPointHolds at: 2)))
					(oOstiaryTypes at: (oPointHolds at: 4))
				)
				(oOstiaryTypes at: (oPointHolds at: 5))
			)
	)
	(oLinesDone
		at:
			1
			(&
				(&
					(& (oOstiaryTypes at: (oPointHolds at: 3)) (oOstiaryTypes at: (oPointHolds at: 4)))
					(oOstiaryTypes at: (oPointHolds at: 6))
				)
				(oOstiaryTypes at: (oPointHolds at: 7))
			)
	)
	(oLinesDone
		at:
			2
			(&
				(&
					(& (oOstiaryTypes at: (oPointHolds at: 5)) (oOstiaryTypes at: (oPointHolds at: 6)))
					(oOstiaryTypes at: (oPointHolds at: 8))
				)
				(oOstiaryTypes at: (oPointHolds at: 9))
			)
	)
	(oLinesDone
		at:
			3
			(&
				(&
					(& (oOstiaryTypes at: (oPointHolds at: 7)) (oOstiaryTypes at: (oPointHolds at: 8)))
					(oOstiaryTypes at: (oPointHolds at: 10))
				)
				(oOstiaryTypes at: (oPointHolds at: 1))
			)
	)
	(oLinesDone
		at:
			4
			(&
				(&
					(& (oOstiaryTypes at: (oPointHolds at: 9)) (oOstiaryTypes at: (oPointHolds at: 10)))
					(oOstiaryTypes at: (oPointHolds at: 2))
				)
				(oOstiaryTypes at: (oPointHolds at: 3))
			)
	)
	(if
		(and
			(oLinesDone at: 0)
			(oLinesDone at: 1)
			(oLinesDone at: 2)
			(oLinesDone at: 3)
			(oLinesDone at: 4)
		)
		(PrintDebug {Winning position!})
		(gCurRoom setScript: soPuzzleSolved)
	)
)

(procedure (ScrewItUp &tmp oTempArray bAny)
	(= oTempArray (IntArray newWith: 4 0 0 0 0))
	(= bAny 0)
	(cond
		((oLinesDone at: 0)
			(oTempArray at: 0 1 2 4 5)
		)
		((oLinesDone at: 1)
			(oTempArray at: 0 3 4 6 7)
		)
		((oLinesDone at: 2)
			(oTempArray at: 0 5 6 8 9)
		)
		((oLinesDone at: 3)
			(oTempArray at: 0 7 8 10 1)
		)
		((oLinesDone at: 4)
			(oTempArray at: 0 9 10 2 3)
		)
		(else
			(= bAny 1)
		)
	)
	(if bAny
		((oOstiaries at: (Random 0 9)) doVerb: 7777)
	else
		((oOstiaries at: (- (oPointHolds at: (oTempArray at: (Random 0 3))) 1)) doVerb: 7777)
	)
	(oTempArray dispose:)
	(= oTempArray 0)
)

(instance foExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gMessager say: 0 0 16 0 0 30600) ; "Torin? Where are you going?"
	)
)

(instance oDoneTalking of CueMe ; UNUSED
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(class Ostiary of Actor
	(properties
		ID -1
		nPointOn -1
		nPointLeft -1
		nPointTo -1
		oAvoiding 0
		bAvoid 1
		nSaveTime 0
		nLastX 0
		nLastY 0
		nMusic 0
		oMusic 0
		oSound 0
		bExcusedSelf 0
		curPrayer 666
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 7777)
		(|= signal $5000)
		(self
			setCycle: StopWalk -1
			setLooper: Grooper
			setScaler: Scaler 100 80 251 83
		)
		(= oMusic (TPSound new:))
		(= oSound (TPSound new:))
		(oMusic type: 1)
		(LockNLoad 141 nMusic)
		(LockNLoad 141 (+ 30423 (- ID 1)))
	)

	(method (dispose)
		(if oMusic
			(oMusic dispose:)
			(= oMusic 0)
		)
		(if oSound
			(oSound dispose:)
			(= oSound 0)
		)
		(UnlockNUnload 141 nMusic)
		(UnlockNUnload 141 (+ 30423 (- ID 1)))
		(super dispose: &rest)
	)

	(method (unloadSound)
		(UnlockNUnload 141 nMusic)
		(UnlockNUnload 141 (+ 30423 (- ID 1)))
	)

	(method (doit &tmp i oOstiary nDeltaX nDeltaY nMoveX nMoveY nDist)
		(super doit: &rest)
		(if (and (not bAvoid) (> (- gGameTime nSaveTime) 120))
			(PrintDebug {FailSafe Off -- Ostiary %d} ID)
			(= bAvoid 1)
			(= nSaveTime gGameTime)
		)
		(if (and mover bAvoid)
			(cond
				((or (!= x nLastX) (!= y nLastY))
					(= nLastX x)
					(= nLastY y)
					(= nSaveTime gGameTime)
					(for ((= i 0)) (< i 10) ((++ i))
						(if
							(and
								(!= (= oOstiary (oOstiaries at: i)) self)
								(!= oOstiary oAvoiding)
							)
							(= nDeltaX (- (oOstiary x:) x))
							(= nDeltaY (* (- (oOstiary y:) y) 3))
							(if (< (= nDist (GetDistance 0 0 nDeltaX nDeltaY)) 28)
								(if (not bExcusedSelf)
									(= bExcusedSelf 1)
									(oSound playSound: (+ 30423 (- ID 1)))
								)
								(= nMoveX (+ x (/ (- 0 nDeltaY) 2)))
								(= nMoveY (+ y (/ nDeltaX 6)))
								(self setLoop: loop 1)
								(= oAvoiding oOstiary)
								(self setMotion: MoveTo nMoveX nMoveY self)
							)
						)
					)
				)
				((> (- gGameTime nSaveTime) 20)
					(PrintDebug {FailSafe On -- Ostiary %d} ID)
					(= nSaveTime gGameTime)
					(= bAvoid 0)
					(self setLoop: -1)
					(self
						setMotion:
							MoveTo
							(GetLocX nPointTo)
							(GetLocY nPointTo)
							self
					)
					(= oAvoiding 0)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(= bPuzzleBegun 1)
		(= nSaveTime gGameTime)
		(self setLoop: -1)
		(= bAvoid 1)
		(= nLastY (= nLastX -1))
		(if (== theVerb 1) ; Do
			(self setScript: 0)
			(= nLastClickTime gGameTime)
			(= nFidgetWaitTime 1800)
			(= bAutoMove 0)
		else
			(= bAutoMove 1)
		)
		(if (!= nPointOn -1)
			(= nPointLeft nPointOn)
		else
			(= nPointLeft nPointTo)
		)
		(= nPointOn -1)
		(= nPointTo nEmptyPoint)
		(= nEmptyPoint nPointLeft)
		(oPointHolds at: nEmptyPoint 0)
		(CheckForWin)
		(if (and (== theVerb 1) (not bTalking) (< nTellEm 2)) ; Do
			(++ nTellEm)
			(if (== nPointTo 0)
				(self setScript: soInstruct1 0 nPointTo)
				(return)
			else
				(self setScript: soInstruct2 0 nPointTo)
				(return)
			)
		)
		(oMusic setMusic: nMusic)
		(self
			setMotion: MoveTo (GetLocX nPointTo) (GetLocY nPointTo) self
		)
	)

	(method (cue)
		(if (not bAutoMove)
			(= nLastClickTime gGameTime)
			(= nFidgetWaitTime 1800)
		)
		(if oAvoiding
			(self setLoop: -1)
			(self
				setMotion:
					MoveTo
					(GetLocX nPointTo)
					(GetLocY nPointTo)
					self
			)
			(= oAvoiding 0)
			(return)
		)
		(if (!= nPointOn -1)
			(PrintDebug
				{integrity failure -- invalid cue, point: %d, guy: %d}
				nPointTo
				ID
			)
			(return)
		)
		(oMusic setMusic: 0)
		(= bExcusedSelf 0)
		(= nPointOn nPointTo)
		(= nPointTo -1)
		(oPointHolds at: nPointOn ID)
		(self setHeading: 180)
		(CheckForWin)
	)
)

(instance soInstruct1 of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(= bTalking 1)
				(gMessager say: 0 0 1 1 self 30600) ; "(DIRECTING PEOPLE'S MOVEMENTS) Okay, you step into the center."
			)
			(1
				(= bTalking 0)
				((client oMusic:) setMusic: (client nMusic:))
				(client
					setMotion:
						MoveTo
						(GetLocX register)
						(GetLocY register)
						client
				)
				(self dispose:)
			)
		)
	)
)

(instance soInstruct2 of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(= bTalking 1)
				(gMessager say: 0 0 1 2 self 30600) ; "And you, take his place."
			)
			(1
				(= bTalking 0)
				((client oMusic:) setMusic: (client nMusic:))
				(client
					setMotion:
						MoveTo
						(GetLocX register)
						(GetLocY register)
						client
				)
				(self dispose:)
			)
		)
	)
)

(instance soTurnAndFace of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(client setMotion: 0)
				(= ticks (Random 50 200))
			)
			(1
				(client setMotion: 0)
				(if (== (= nLoop (client loop:)) 8)
					(= nLoop (client cel:))
				)
				(switch nLoop
					(3
						(client heading: 0)
					)
					(6
						(client heading: 45)
					)
					(0
						(client heading: 90)
					)
					(4
						(client heading: 135)
					)
					(2
						(client heading: 180)
					)
					(5
						(client heading: 225)
					)
					(1
						(client heading: 270)
					)
					(7
						(client heading: 315)
					)
				)
				(client setHeading: 180 self)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if client
			(client setMotion: 0)
		)
		(super dispose: &rest)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance poBoogle of Prop
	(properties)
)

(instance poLeenah of Prop
	(properties)
)

(class SmallOst of Prop
	(properties
		ID 0
	)

	(method (init)
		(= view (+ 30410 ID))
		(= loop 8)
		(= cel (Random 0 7))
		(self setScalePercent: 30)
		(super init: &rest)
		(= cycleSpeed (Random 10 30))
		(self setCycle: RandCycle)
	)
)

(instance oSmallOst0 of SmallOst
	(properties
		x 323
		y 206
	)
)

(instance oSmallOst1 of SmallOst
	(properties
		x 330
		y 234
		ID 1
	)
)

(instance oSmallOst2 of SmallOst
	(properties
		x 387
		y 238
		ID 2
	)
)

(instance oSmallOst3 of SmallOst
	(properties
		x 411
		y 215
		ID 3
	)
)

(instance oSmallOst4 of SmallOst
	(properties
		x 367
		y 197
		ID 4
	)
)

(instance oSmallOst5 of SmallOst
	(properties
		x 246
		y 222
		ID 5
	)
)

(instance oSmallOst6 of SmallOst
	(properties
		x 345
		y 283
		ID 6
	)
)

(instance oSmallOst7 of SmallOst
	(properties
		x 480
		y 244
		ID 7
	)
)

(instance oSmallOst8 of SmallOst
	(properties
		x 434
		y 184
		ID 8
	)
)

(instance oSmallOst9 of SmallOst
	(properties
		x 316
		y 175
		ID 9
	)
)

(class SyncEndLoop of End
	(properties)

	(method (nextCel &tmp newCel)
		(if
			(>
				(= newCel (/ (- gGameTime cycleCnt) (client cycleSpeed:)))
				clientLastCel
			)
			(= newCel clientLastCel)
		)
		(return newCel)
	)

	(method (doit &tmp newCel currentCel nPanPos)
		(= currentCel (client cel:))
		(= newCel (self nextCel:))
		(if (!= currentCel newCel)
			(= nPanPos (Max 0 (- 420 (* newCel 10))))
			(oTreeScrollPlane scrollTo: 0 nPanPos)
			(client cel: newCel)
		)
		(if (== newCel endCel)
			(self cycleDone:)
		)
	)
)

(instance poRiseIntro of Prop
	(properties)
)

(instance poRise of Prop
	(properties)
)

(instance poBeams of Prop
	(properties)
)

(instance poFrontBeam of Prop
	(properties)
)

(instance voRiseBG of View
	(properties)
)

(instance oStartup of TPSound
	(properties)
)

(instance oBeams of TPSound
	(properties)
)

(instance oRise of TPSound
	(properties)
)

(instance soPuzzleSolved of TPScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 100)
			)
			(1
				((ScriptID 64017 0) set: 121) ; oFlags
				(= bPuzzleBegun 0)
				(for ((= i 0)) (< i 10) ((++ i))
					((oOstiaries at: i) unloadSound:)
				)
				(goSound1 preload: 30420 30421 30422)
				(= ticks 30)
			)
			(2
				(oStartup playSound: 30420)
				(= ticks 60)
			)
			(3
				(gMessager say: 0 0 2 0 self 30600) ; "Hurry, Leenah. Jump up here!"
			)
			(4
				(if oOstiaries
					(oOstiaries dispose:)
					(= oOstiaries 0)
				)
				(gCurRoom picture: 30403)
				(gCurRoom drawPic: 30403)
				(poRiseIntro
					view: 30404
					cel: 0
					loop: 0
					posn: 348 261
					setPri: 300
					init:
				)
				(voRiseBG
					view: 30404
					cel: 0
					loop: 1
					posn: 348 254
					setPri: 250
					init:
				)
				(poBeams
					view: 30405
					cel: 0
					loop: 0
					posn: 369 278
					setPri: 270
					init:
					setCycle: End self
				)
				(poFrontBeam
					view: 30405
					cel: 0
					loop: 1
					posn: 369 278
					setPri: 500
					init:
					setCycle: End self
				)
				(oBeams playSound: 30421)
			)
			(5
				(= ticks 90)
			)
			(6
				(oRise playSound: 30422)
				(= ticks 60)
			)
			(7
				(voRiseBG dispose:)
				(poRiseIntro cel: 1 cycleSpeed: 3 doit: setCycle: End self)
				(goMusic1 playSound: 30498)
			)
			(8
				(poRiseIntro dispose:)
				(poBeams dispose:)
				(gCurRoom addRoomPlane: oTreeScrollPlane)
				(oTreeScrollPlane scrollTo: 0 632)
				(poRise
					view: 30406
					loop: 0
					cel: 0
					posn: 321 388
					cycleSpeed: 9
					init:
				)
				(oTreeScrollPlane panTo: 0 420 self 9 14 14)
			)
			(9
				(poRise setCycle: SyncEndLoop self)
			)
			(10
				(= ticks 80)
			)
			(11
				(gCurRoom newRoom: 30500) ; roMusicPuzzle
				(self dispose:)
			)
		)
	)
)

(instance soFirstScrewup of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= nLastClickTime gGameTime)
				(= nFidgetWaitTime 9000)
				(= bFirstScrewup 1)
				(= bTalking 1)
				(ScrewItUp)
				(gMessager sayRange: 0 0 17 1 2 self 30600) ; "Hey! I didn't tell you to move."
			)
			(1
				(ScrewItUp)
				(= nLastClickTime gGameTime)
				(= nFidgetWaitTime 70)
				(gMessager sayRange: 0 0 17 3 6 self 30600) ; "Oh, no. There goes another one."
			)
			(2
				(= bTalking 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPlayRoomIntro of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(= bArraysInited 0)
				(gCurRoom picture: 30405)
				(gCurRoom drawPic: 30405)
				(poTorin view: 30400 loop: 0 cel: 0 posn: 324 255 init:)
				(poLeenah view: 30400 loop: 5 cel: 0 posn: 324 255 init:)
				(poBoogle view: 30400 loop: 2 cel: 0 posn: 214 256 init:)
				(FadeToBlack 0 10 self)
			)
			(1
				(poTorin setCycle: End self)
			)
			(2
				(poTorin hide:)
				(poLeenah loop: 1 cel: 0 doit: setCycle: End self)
				(poBoogle setCycle: End self)
			)
			(3)
			(4
				(FadeToBlack 1 10 self)
			)
			(5
				(= ticks 1)
			)
			(6
				(poTorin dispose:)
				(poBoogle dispose:)
				(poLeenah dispose:)
				(gCurRoom picture: 30408)
				(gCurRoom drawPic: 30408)
				(oSmallOst0 init:)
				(oSmallOst1 init:)
				(oSmallOst2 init:)
				(oSmallOst3 init:)
				(oSmallOst4 init:)
				(oSmallOst5 init:)
				(oSmallOst6 init:)
				(oSmallOst7 init:)
				(oSmallOst8 init:)
				(oSmallOst9 init:)
				(foExit init:)
				(poTorin
					view: 30403
					loop: 0
					cel: 1
					posn: 245 205
					setPri: 1
					init:
					setCycle: End self
				)
				(poBoogle
					view: 30403
					loop: 2
					cel: 1
					posn: 205 256
					init:
					setCycle: End self
				)
				(poLeenah
					view: 30403
					loop: 1
					cel: 0
					posn: 283 220
					setPri: 1
					init:
					setCycle: End self
				)
				(FadeToBlack 0 10 self)
			)
			(7)
			(8)
			(9)
			(10
				(= ticks 180)
			)
			(11
				(goMusic1 fadeOut: 12 10 self)
			)
			(12
				(oSmallOst0 dispose:)
				(oSmallOst1 dispose:)
				(oSmallOst2 dispose:)
				(oSmallOst3 dispose:)
				(oSmallOst4 dispose:)
				(oSmallOst5 dispose:)
				(oSmallOst6 dispose:)
				(oSmallOst7 dispose:)
				(oSmallOst8 dispose:)
				(oSmallOst9 dispose:)
				(poTorin dispose:)
				(poBoogle dispose:)
				(poLeenah dispose:)
				(gCurRoom picture: 30404)
				(gCurRoom drawPic: 30404)
				(InitArrays)
				(= bArraysInited 1)
				(= ticks 200)
			)
			(13
				(gMessager say: 0 0 0 2 self 30500) ; "Attention, everyone. This is Torin and his friend, Leenah. Please, give him your attention."
				(= ticks 140)
			)
			(14
				(for ((= i 0)) (< i 10) ((++ i))
					((oOstiaries at: i) setMotion: 0)
					((oOstiaries at: i) setScript: (soTurnAndFace new:) self)
				)
			)
			(15)
			(16)
			(17)
			(18)
			(19)
			(20)
			(21)
			(22)
			(23)
			(24)
			(25
				(gMessager sayRange: 0 0 0 3 7 self 30500) ; "(TO TORIN) They're all yours."
			)
			(26
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff &tmp i)
		(oSmallOst0 dispose:)
		(oSmallOst1 dispose:)
		(oSmallOst2 dispose:)
		(oSmallOst3 dispose:)
		(oSmallOst4 dispose:)
		(oSmallOst5 dispose:)
		(oSmallOst6 dispose:)
		(oSmallOst7 dispose:)
		(oSmallOst8 dispose:)
		(oSmallOst9 dispose:)
		(poTorin setPri: -1 dispose:)
		(poBoogle dispose:)
		(poLeenah setPri: -1 dispose:)
		(gCurRoom picture: 30404)
		(gCurRoom drawPic: 30404)
		(goMusic1 setMusic: 0)
		(if (not bArraysInited)
			(InitArrays)
		)
		(for ((= i 0)) (< i 10) ((++ i))
			((oOstiaries at: i) setScript: (soTurnAndFace new:))
		)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance oTreeScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (init)
		(super init: (gThePlane getWidth:) 948)
	)

	(method (addPics)
		(AddPicAt self 30402 0 0)
		(AddPicAt self 30401 0 316)
		(AddPicAt self 30400 0 632)
	)
)

(instance roStarPuzzle of TPRoom
	(properties
		picture 30400
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 30400)
		(= bPuzzleBegun 0)
		(gCurRoom setScript: soPlayRoomIntro)
	)

	(method (dispose)
		(if oOstiaryTypes
			(oOstiaryTypes dispose:)
			(= oOstiaryTypes 0)
		)
		(if oPointLocs
			(oPointLocs dispose:)
			(= oPointLocs 0)
		)
		(if oPointHolds
			(oPointHolds dispose:)
			(= oPointHolds 0)
		)
		(if oLinesDone
			(oLinesDone dispose:)
			(= oLinesDone 0)
		)
		(if oOstiaries
			(oOstiaries release:)
			(oOstiaries dispose:)
			(= oOstiaries 0)
		)
		(goSound1 stop:)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (and bPuzzleBegun (> (- gGameTime nLastClickTime) nFidgetWaitTime))
			(if (not bFirstScrewup)
				(self setScript: soFirstScrewup)
				(return)
			)
			(ScrewItUp)
			(= nLastClickTime gGameTime)
			(= nFidgetWaitTime 70)
		)
	)

	(method (gimme)
		(gCurRoom setScript: soPuzzleSolved)
	)
)

