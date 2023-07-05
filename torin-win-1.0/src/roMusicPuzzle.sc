;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30500)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use Array)
(use Talker)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	roMusicPuzzle 0
)

(local
	oOstiaries
	oPointHolds
	oPointLocs
	oSmallPtLocs
	nStage
	oSelectedSinger
	bLeftOrdered
	bRightOrdered
	bLeftDoorOpen
	bRightDoorOpen
	nCues
	bTAndLInPlace
	bSaidFirstLeftDoor
	bSaidFirstRightDoor
	bLeenahEyesClosed
	bTalking
)

(procedure (InitArrays &tmp i nID oSoundArray oCaseArray)
	(= oSoundArray
		(IntArray
			newWith:
				10
				30514
				30513
				30512
				30511
				30510
				30515
				30516
				30517
				30518
				30519
		)
	)
	(= oCaseArray (IntArray newWith: 10 9 8 7 6 5 13 11 10 14 12))
	(= oPointLocs
		(IntArray
			newWith:
				20
				68
				268
				116
				268
				164
				268
				212
				268
				260
				268
				370
				268
				418
				268
				466
				268
				514
				268
				562
				268
		)
	)
	(= oSmallPtLocs
		(IntArray
			newWith:
				20
				140
				265
				175
				262
				210
				259
				245
				256
				280
				253
				350
				253
				385
				256
				420
				259
				455
				262
				490
				265
		)
	)
	(= oPointHolds (IntArray newWith: 10 0 5 1 6 2 7 3 8 4 9))
	(= oOstiaries (Set new:))
	(for ((= i 0)) (< i 10) ((++ i))
		(oOstiaries
			addToEnd:
				((Singer new:)
					ID: i
					nSound: (oSoundArray at: i)
					case: (oCaseArray at: i)
					view: (+ 30410 i)
					heading: 225
					loop: 5
					yourself:
				)
		)
	)
	(oSoundArray dispose:)
	(= oSoundArray 0)
	(oCaseArray dispose:)
	(= oCaseArray 0)
	(for ((= i 0)) (< i 10) ((++ i))
		(= nID (oPointHolds at: i))
		((oOstiaries at: nID)
			nPointOn: i
			posn: (GetLocX i) (GetLocY i)
			init:
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

(procedure (GetSmallLocX nPoint)
	(if (not oSmallPtLocs)
		(PrintDebug {error in GetLocX -- 30400.sc DJM})
		(return 0)
	)
	(return (oSmallPtLocs at: (* nPoint 2)))
)

(procedure (GetSmallLocY nPoint)
	(if (not oSmallPtLocs)
		(PrintDebug {error in GetLocY -- 30400.sc DJM})
		(return 0)
	)
	(return (oSmallPtLocs at: (+ (* nPoint 2) 1)))
)

(procedure (IsMale nSinger)
	(return (< nSinger 5))
)

(procedure (IsEmpty nPoint)
	(return (== (oPointHolds at: nPoint) -1))
)

(procedure (CheckForWin &tmp i bWin)
	(if (== nStage 0)
		(for ((= i 0)) (< i 4) ((++ i))
			(if
				(and
					(not (IsEmpty i))
					(not (IsEmpty (+ i 1)))
					(not (IsMale (oPointHolds at: i)))
					(not (IsMale (oPointHolds at: (+ i 1))))
				)
				((oOstiaries at: (oPointHolds at: i)) raiseHands: 2)
				((oOstiaries at: (oPointHolds at: (+ i 1))) raiseHands: 1)
			else
				(if (not (IsEmpty i))
					((oOstiaries at: (oPointHolds at: i)) lowerHands: 2)
				)
				(if (not (IsEmpty (+ i 1)))
					((oOstiaries at: (oPointHolds at: (+ i 1))) lowerHands: 1)
				)
			)
			(if
				(and
					(not (IsEmpty (+ i 5)))
					(not (IsEmpty (+ i 6)))
					(IsMale (oPointHolds at: (+ i 5)))
					(IsMale (oPointHolds at: (+ i 6)))
				)
				((oOstiaries at: (oPointHolds at: (+ i 5))) raiseHands: 2)
				((oOstiaries at: (oPointHolds at: (+ i 6))) raiseHands: 1)
			else
				(if (not (IsEmpty (+ i 5)))
					((oOstiaries at: (oPointHolds at: (+ i 5))) lowerHands: 2)
				)
				(if (not (IsEmpty (+ i 6)))
					((oOstiaries at: (oPointHolds at: (+ i 6))) lowerHands: 1)
				)
			)
		)
		(= bWin 1)
		(for ((= i 0)) (< i 5) ((++ i))
			(if
				(or
					(IsEmpty i)
					(IsEmpty (+ i 5))
					(IsMale (oPointHolds at: i))
					(not (IsMale (oPointHolds at: (+ i 5))))
				)
				(= bWin 0)
				(break)
			)
		)
		(if bWin
			(gCurRoom setScript: soWinStage1)
		)
	else
		(= bLeftOrdered 1)
		(= bRightOrdered 1)
		(for ((= i 0)) (< i 5) ((++ i))
			(if (!= (oPointHolds at: i) (+ i 5))
				(= bLeftOrdered 0)
			)
			(if (!= (oPointHolds at: (+ i 5)) i)
				(= bRightOrdered 0)
			)
		)
	)
)

(instance foLeftSide of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 0 0 290 316)
		(self addHotspotVerb: 80)
	)

	(method (doVerb)
		(gCurRoom setScript: soLeftSings)
	)
)

(instance foRightSide of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 340 0 632 316)
		(self addHotspotVerb: 80)
	)

	(method (doVerb)
		(gCurRoom setScript: soRightSings)
	)
)

(instance aoLeftDoor of Actor
	(properties
		view 30502
	)

	(method (init)
		(self setPri: 5)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
		(self setStep: 5 5)
		(self setSpeed: 6)
	)

	(method (doVerb)
		(if (not bSaidFirstLeftDoor)
			(= bSaidFirstLeftDoor 1)
			(gMessager say: 11 1 3 1 0 30600) ; "I bet that door hides a phenocryst."
		else
			(gMessager say: 11 1 3 2 0 30600) ; "Four dots and a circle?"
		)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoRightDoor of Actor
	(properties
		x 317
		y 1
		view 30502
		loop 1
	)

	(method (init)
		(self setPri: 5)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
		(self setStep: 5 5)
		(self setSpeed: 6)
	)

	(method (doVerb)
		(if (not bSaidFirstRightDoor)
			(= bSaidFirstRightDoor 1)
			(gMessager say: 12 1 3 1 0 30600) ; "Those carvings must symbolize something."
		else
			(gMessager say: 12 1 3 2 0 30600) ; "Five concentric rings?"
		)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoPodium of Actor
	(properties
		x 287
		y 318
		view 30505
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 80)
		(self setPri: 390)
		(self setStep: 5 5)
		(self setSpeed: 3)
	)

	(method (doVerb)
		(aoBaton init:)
		(= global101 1)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance aoBaton of Actor
	(properties
		x 316
		y 342
		view 30505
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self setPri: 400)
		(self setStep: 5 5)
		(self setSpeed: 3)
	)

	(method (doVerb)
		(= global101 80)
		(self dispose:)
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance coHandsOnWhenCuedThrice of CueMe
	(properties)

	(method (cue)
		(if (== (++ nCues) 3)
			(gGame handsOn:)
		)
	)
)

(class Singer of Actor
	(properties
		ID -1
		nPointOn -1
		bLeftHandOut 0
		bRightHandOut 0
		oLeftHand 0
		oRightHand 0
		bSinging 0
		oSingCuee 0
		nSound 0
		curPrayer 666
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $5000)
		(= cycleSpeed (= moveSpeed 2))
		(self setLooper: Grooper)
		(LockNLoad 141 nSound)
	)

	(method (dispose)
		(if (and oLeftHand (oLeftHand scratch:))
			(oLeftHand dispose:)
			(= oLeftHand 0)
		)
		(if (and oRightHand (oRightHand scratch:))
			(oRightHand dispose:)
			(= oRightHand 0)
		)
		(UnlockNUnload 141 nSound)
		(super dispose: &rest)
	)

	(method (unlockAudio)
		(UnlockNUnload 141 nSound)
	)

	(method (getMyYOffset)
		(if (== nStage 0)
			(return 0)
		)
		(return
			(switch ID
				(0 -10)
				(1 -5)
				(2 0)
				(3 5)
				(4 10)
				(5 10)
				(6 5)
				(7 0)
				(8 -5)
				(9 -10)
			)
		)
	)

	(method (doVerb)
		(if (== nStage 0)
			(if oSelectedSinger
				(if (== self oSelectedSinger)
					(self unselect:)
				else
					(self switchWith: oSelectedSinger)
					(= oSelectedSinger 0)
				)
			else
				(self select:)
			)
		else
			(= nCues 0)
			(gGame handsOff:)
			(self sing: coHandsOnWhenCuedThrice)
			((self getOneHigher:)
				switchWith: (self getTwoHigher:) coHandsOnWhenCuedThrice
			)
		)
	)

	(method (cue)
		(self stopSinging: 1)
	)

	(method (select)
		(if oSelectedSinger
			(oSelectedSinger unselect:)
		)
		(self stopSinging:)
		(= oSelectedSinger self)
		(self setScript: (soSelect new:))
	)

	(method (unselect)
		(if (!= self oSelectedSinger)
			(return)
		)
		(= oSelectedSinger 0)
		(self setScript: (soUnselect new:))
	)

	(method (switchWith oWho oCueParm &tmp oCuee)
		(if (or (not argc) (not oWho))
			(PrintDebug {illegal switchWith. 30500.sc djm})
			(return)
		)
		(if (> argc 1)
			(= oCuee oCueParm)
		else
			(= oCuee 0)
		)
		(self setScript: (soStrollTo new:) oCuee (oWho nPointOn:))
		(oWho setScript: (soStrollTo new:) oCuee (self nPointOn:))
	)

	(method (getOneHigher)
		(cond
			((< ID 5)
				(if (== ID 4)
					(oOstiaries at: 0)
					(return)
				else
					(oOstiaries at: (+ ID 1))
					(return)
				)
			)
			((== ID 9)
				(oOstiaries at: 5)
				(return)
			)
			(else
				(oOstiaries at: (+ ID 1))
				(return)
			)
		)
	)

	(method (getTwoHigher)
		(cond
			((< ID 5)
				(if (>= ID 3)
					(oOstiaries at: (- ID 3))
					(return)
				else
					(oOstiaries at: (+ ID 2))
					(return)
				)
			)
			((>= ID 8)
				(oOstiaries at: (- ID 3))
				(return)
			)
			(else
				(oOstiaries at: (+ ID 2))
				(return)
			)
		)
	)

	(method (sing oCueParm)
		(if bSinging
			(return)
		)
		(if (and argc oCueParm)
			(= oSingCuee oCueParm)
		else
			(= oSingCuee 0)
		)
		(goSound1 playSubtitledSound: nSound 0 0 case 1 self 30600)
		(= bSinging 1)
		(self setDisplay:)
	)

	(method (stopSinging bCue)
		(if (not bSinging)
			(return)
		)
		(= bSinging 0)
		(self setDisplay:)
		(if (and argc bCue oSingCuee)
			(oSingCuee cue:)
			(= oSingCuee 0)
		)
	)

	(method (raiseHands which)
		(if (not argc)
			(PrintDebug {invalid call of raiseHands. 30500.sc})
			(return)
		)
		(if (& which $0001)
			(= bRightHandOut 1)
		)
		(if (& which $0002)
			(= bLeftHandOut 1)
		)
		(self setDisplay:)
	)

	(method (lowerHands which)
		(if (not argc)
			(PrintDebug {invalid call of lowerHands. 30500.sc})
			(return)
		)
		(if (& which $0001)
			(= bRightHandOut 0)
		)
		(if (& which $0002)
			(= bLeftHandOut 0)
		)
		(self setDisplay:)
	)

	(method (setDisplay &tmp newView newLoop newCel)
		(if bSinging
			(if (or (not cycler) (cycler isKindOf: StopWalk))
				(= view (+ 30420 ID))
				(= cel (= loop 0))
				(self setCycle: Fwd)
			)
			(return)
		)
		(if (== nStage 0)
			(if bLeftHandOut
				(self setCycle: 0)
				(= newView (+ 30420 ID))
				(= newLoop 1)
				(= newCel 0)
				(if (not oLeftHand)
					(= oLeftHand
						((View new:)
							view: (+ 30420 ID)
							loop: 3
							cel: 0
							posn: x y
							init:
							setPri: (+ priority 1)
							yourself:
						)
					)
				)
			else
				(= newView (+ 30410 ID))
				(= newCel 5)
				(= newLoop 8)
				(self setCycle: StopWalk -1)
				(if oLeftHand
					(oLeftHand dispose:)
					(= oLeftHand 0)
				)
			)
			(cond
				(bRightHandOut
					(if (not oRightHand)
						(= oRightHand
							((View new:)
								view: (+ 30420 ID)
								loop: 2
								cel: 0
								posn: x y
								init:
								setPri: (- priority 1)
								yourself:
							)
						)
					)
				)
				(oRightHand
					(oRightHand dispose:)
					(= oRightHand 0)
				)
			)
			(if (!= view newView)
				(= view newView)
			)
			(if (!= loop newLoop)
				(self setLoop: newLoop)
			)
			(if (!= cel newCel)
				(self setCel: newCel)
			)
		else
			(if oLeftHand
				(oLeftHand dispose:)
				(= oLeftHand 0)
			)
			(if oRightHand
				(oRightHand dispose:)
				(= oRightHand 0)
			)
			(= view (+ 30410 ID))
			(cond
				((IsMale ID)
					(if bRightDoorOpen
						(= newLoop 3)
					else
						(= newLoop 5)
					)
				)
				(bLeftDoorOpen
					(= newLoop 3)
				)
				(else
					(= newLoop 4)
				)
			)
			(self setCycle: StopWalk -1)
			(self setLoop: newLoop)
		)
	)
)

(instance soLeftSings of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((oOstiaries at: (oPointHolds at: 0)) sing: self)
			)
			(1
				((oOstiaries at: (oPointHolds at: 1)) sing: self)
			)
			(2
				((oOstiaries at: (oPointHolds at: 2)) sing: self)
			)
			(3
				((oOstiaries at: (oPointHolds at: 3)) sing: self)
			)
			(4
				((oOstiaries at: (oPointHolds at: 4)) sing: self)
			)
			(5
				(if bLeftOrdered
					(self setScript: soOpenLeftDoor self)
				else
					(self cue:)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soRightSings of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((oOstiaries at: (oPointHolds at: 5)) sing: self)
			)
			(1
				((oOstiaries at: (oPointHolds at: 6)) sing: self)
			)
			(2
				((oOstiaries at: (oPointHolds at: 7)) sing: self)
			)
			(3
				((oOstiaries at: (oPointHolds at: 8)) sing: self)
			)
			(4
				((oOstiaries at: (oPointHolds at: 9)) sing: self)
			)
			(5
				(if bRightOrdered
					(self setScript: soOpenRightDoor self)
				else
					(self cue:)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOpenLeftDoor of TPScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(for ((= i 0)) (< i 5) ((++ i))
					((oOstiaries at: (oPointHolds at: i))
						heading: 135
						setLoop: 4
						setLooper: Grooper
						setCycle: StopWalk -1
						setHeading: 0
						deleteHotspotVerb: 1
					)
				)
				(foLeftSide dispose:)
				(goSound1 playSound: 30507)
				(= ticks 20)
			)
			(1
				(aoLeftDoor setMotion: MoveTo 0 -20 self)
			)
			(2
				(aoLeftDoor setMotion: MoveTo -320 -20 self)
			)
			(3
				(aoLeftDoor dispose:)
				((ScriptID 64017 0) set: 123) ; oFlags
				(= bLeftDoorOpen 1)
				(if bRightDoorOpen
					(self setScript: soWin self)
				else
					(gMessager say: 0 0 15 1 self 30600) ; "Ahhh, that's it. The pattern was five ascending notes leading to the second nested planet. So that phenocryst goes back to Escarpa."
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soOpenRightDoor of TPScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(for ((= i 5)) (< i 10) ((++ i))
					((oOstiaries at: (oPointHolds at: i))
						heading: 215
						setLoop: 5
						setLooper: Grooper
						setCycle: StopWalk -1
						setHeading: 0
						deleteHotspotVerb: 1
					)
				)
				(foRightSide dispose:)
				(goSound1 playSound: 30507)
				(= ticks 20)
			)
			(1
				(aoRightDoor setMotion: MoveTo 317 -19 self)
			)
			(2
				(aoRightDoor setMotion: MoveTo 640 -19 self)
			)
			(3
				(aoRightDoor dispose:)
				((ScriptID 64017 0) set: 124) ; oFlags
				(= bRightDoorOpen 1)
				(if bLeftDoorOpen
					(self setScript: soWin self)
				else
					(gMessager say: 0 0 15 2 self 30600) ; "Ahhh, that's it. The pattern was five descending notes leading to the fourth nested planet. The other door must go back to Escarpa."
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance poLeenah of Prop
	(properties)
)

(instance voTorinNormalMouth of View
	(properties
		x 323
		y 273
		priority 400
		fixPriority 1
		view 30503
		loop 9
	)
)

(instance poLeenahClosedEyes of Prop
	(properties
		x 323
		y 273
		priority 405
		fixPriority 1
		view 30503
		loop 17
	)

	(method (init)
		(super init: &rest)
		(self setScript: soLeenahBlink)
	)
)

(instance soLeenahBlink of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(if (not bLeenahEyesClosed)
					(client hide:)
				)
				(= ticks (Random 50 150))
			)
			(1
				(client show:)
				(= ticks (Random 6 18))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance voLeenahNormalMouth of View
	(properties
		x 323
		y 273
		priority 400
		fixPriority 1
		view 30503
		loop 11
	)
)

(instance toTorinEndCh3 of Talker
	(properties
		x 323
		y 273
		view 30503
		loop 9
		priority 400
	)

	(method (init)
		(voTorinNormalMouth hide:)
		(super init: &rest)
		(if (not bTAndLInPlace)
			(mouth hide:)
		)
	)

	(method (dispose)
		(if bTAndLInPlace
			(voTorinNormalMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance toLeenahEndCh3 of Talker
	(properties
		x 323
		y 273
		view 30503
		loop 11
		priority 400
	)

	(method (init)
		(voLeenahNormalMouth hide:)
		(super init: &rest)
		(if (not bTAndLInPlace)
			(mouth hide:)
		)
	)

	(method (dispose)
		(if bTAndLInPlace
			(voLeenahNormalMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance soWin of TPScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aoLeftDoor dispose:)
				(aoRightDoor dispose:)
				(aoBaton dispose:)
				(= gtTorin toTorinEndCh3)
				(= gtLeenah toLeenahEndCh3)
				(voLeenahNormalMouth init: hide:)
				(voTorinNormalMouth init: hide:)
				(= global101 1)
				(= bTAndLInPlace 0)
				(goSound1 preload: 30598)
				(= ticks 1)
			)
			(1
				(= ticks 20)
			)
			(2
				(if (aoPodium scratch:)
					(goSound1 playSound: 30521)
					(aoPodium setMotion: MoveTo 287 318)
				)
				(= ticks 90)
			)
			(3
				(gMessager sayRange: 0 0 4 1 3 self 30600) ; "Oh, Torin! I knew you could do it!"
			)
			(4
				(aoPodium dispose:)
				(aoBaton dispose:)
				(for ((= i 0)) (< i 5) ((++ i))
					((oOstiaries at: i) setScript: (soMenStage3 new:))
					((oOstiaries at: (+ i 5)) setScript: (soWomenStage3 new:))
				)
				(gCurRoom picture: 30501)
				(gCurRoom drawPic: 30501)
				(poTorin
					view: 30503
					posn: 341 270
					loop: 3
					cel: 0
					init:
					setCycle: End self
				)
				(poLeenah
					view: 30503
					posn: 291 273
					loop: 1
					cel: 0
					init:
					setCycle: End self
				)
				(= bTalking 1)
				(gMessager say: 0 0 4 4 coDoneTalking 30600) ; "Oh, this part I know. Stand over here. I'll throw enough of this powder for both of us, and off we'll go."
			)
			(5)
			(6
				(goMusic1 fadeIn: 30598 12 10 0 0)
				(poLeenah dispose:)
				(poTorin loop: 7 cel: 0 posn: 323 273)
				(= bTAndLInPlace 1)
				(if (toTorinEndCh3 mouth:)
					((toTorinEndCh3 mouth:) show:)
				else
					(voTorinNormalMouth show:)
				)
				(if (toLeenahEndCh3 mouth:)
					((toLeenahEndCh3 mouth:) show:)
				else
					(voLeenahNormalMouth show:)
				)
				(poLeenahClosedEyes init:)
				(= ticks 1)
			)
			(7
				(= cycles 1)
			)
			(8
				(if bTalking
					(-= state 2)
				)
				(= cycles 1)
			)
			(9
				(gMessager sayRange: 0 0 4 6 9 self 30600) ; "Don't forget me, Torin!"
			)
			(10
				(= bLeenahEyesClosed 1)
				(poLeenahClosedEyes show:)
				(gMessager say: 0 0 4 10 self 30600) ; "(SOFTLY, HINTING) They ARE closed."
			)
			(11
				(= bLeenahEyesClosed 0)
				(poLeenahClosedEyes dispose:)
				(voLeenahNormalMouth hide:)
				(voTorinNormalMouth hide:)
				(goSound1 preload: 30509)
				(poTorin loop: 13 cel: 0 doit: setCycle: CT 13 1 self)
			)
			(12
				(= ticks 60)
			)
			(13
				(poTorin setCycle: End self)
			)
			(14
				(poTorin loop: 15 cel: 0 posn: 323 273)
				(voLeenahNormalMouth posn: 318 274 show:)
				(voTorinNormalMouth posn: 323 275 show:)
				(toLeenahEndCh3 x: 318 y: 274)
				(toTorinEndCh3 x: 323 y: 275)
				(poLeenahClosedEyes posn: 318 274 init:)
				(gMessager sayRange: 0 0 4 11 14 self 30600) ; "(LOVINGLY) Save enough powder for a trip to Escarpa."
			)
			(15
				(poLeenahClosedEyes dispose:)
				(voLeenahNormalMouth hide:)
				(voTorinNormalMouth hide:)
				(poLeenah view: 30504 loop: 1 cel: 0 posn: 323 273 init:)
				(poTorin
					view: 30504
					loop: 3
					cel: 0
					posn: 323 273
					doit:
					setCycle: End self
				)
			)
			(16
				(poTorin
					view: 30504
					loop: 5
					cel: 0
					posn: 323 273
					setCycle: CT 1 1 self
				)
			)
			(17
				(poTorin setCycle: End self)
				(poLeenah setCycle: End self)
				(= ticks 1)
			)
			(18
				(= ticks 30)
			)
			(19
				(goSound1 playSound: 30509)
			)
			(20
				(poLeenah dispose:)
				(poTorin loop: 7 cel: 0 posn: 323 273 doit: setCycle: End self)
				(= gtTorin 0)
				(= gtLeenah 0)
			)
			(21
				(poTorin dispose:)
				((ScriptID 64017 0) set: 125) ; oFlags
				(FrameOut)
				(= ticks 120)
			)
			(22
				(FadeToBlack 1 10 self)
			)
			(23
				(gCurRoom newRoom: 40000) ; roChapter4
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(instance soWinStage1 of TPScript
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 30520)
				(= cycles 2)
			)
			(1
				((ScriptID 64017 0) set: 122) ; oFlags
				(= nStage 1)
				(for ((= i 0)) (< i 5) ((++ i))
					((oOstiaries at: i) setScript: (soMenStage2 new:) self)
					((oOstiaries at: (+ i 5))
						setScript: (soWomenStage2 new:) self
					)
				)
				(goSound1 playSound: 30520)
				(aoPodium init: setMotion: MoveTo 287 208 self)
				(aoBaton init: setMotion: MoveTo 316 232)
			)
			(2)
			(3)
			(4)
			(5)
			(6)
			(7)
			(8)
			(9)
			(10)
			(11)
			(12
				(foLeftSide init:)
				(foRightSide init:)
				(CheckForWin)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMenStage3 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					unlockAudio:
					setPri: 12
					setScalePercent: 40
					setLoop: 3
					heading: 0
					posn:
						(GetSmallLocX (- 9 (client ID:)))
						(GetSmallLocY (- 9 (client ID:)))
					doit:
				)
				(= ticks (Random 100 300))
			)
			(1
				(client setHeading: 225 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soWomenStage3 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					unlockAudio:
					setPri: 12
					setScalePercent: 40
					setLoop: 3
					heading: 0
					posn:
						(GetSmallLocX (- 9 (client ID:)))
						(GetSmallLocY (- 9 (client ID:)))
					doit:
				)
				(= ticks (Random 100 300))
			)
			(1
				(client setHeading: 135 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soMenStage2 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client lowerHands: 3)
				(client
					heading: 215
					setCycle: StopWalk -1
					setLooper: Grooper
					setMotion:
						MoveTo
						(client x:)
						(+ (client y:) (client getMyYOffset:))
						self
				)
			)
			(2
				(client setHeading: 225 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soWomenStage2 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client lowerHands: 3)
				(client
					heading: 215
					setCycle: StopWalk -1
					setLooper: Grooper
					setMotion:
						MoveTo
						(client x:)
						(+ (client y:) (client getMyYOffset:))
						self
				)
			)
			(2
				(client setHeading: 135 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soSelect of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client deleteHotspotVerb: 1)
				(oPointHolds at: (client nPointOn:) -1)
				(client lowerHands: 3)
				(CheckForWin)
				(client setCycle: StopWalk -1)
				(client setMotion: MoveTo (client x:) (+ (client y:) 5) self)
			)
			(1
				(client addHotspotVerb: 1)
				(client setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance soUnselect of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client deleteHotspotVerb: 1)
				(client setCycle: StopWalk -1)
				(client setLoop: 2 1)
				(client setMotion: MoveTo (client x:) (- (client y:) 5) self)
			)
			(1
				(client setLoop: -1)
				(client setHeading: 225 self)
			)
			(2
				(client addHotspotVerb: 1)
				(client setCycle: 0)
				(oPointHolds at: (client nPointOn:) (client ID:))
				(CheckForWin)
				(self dispose:)
			)
		)
	)
)

(class soStrollTo of TPScript
	(properties
		nGoingTo -1
		nComingFrom -1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client deleteHotspotVerb: 1)
				(client lowerHands: 3)
				(= nComingFrom (client nPointOn:))
				(= nGoingTo register)
				(oPointHolds at: nComingFrom -1)
				(CheckForWin)
				(client setCycle: StopWalk -1)
				(if (< nComingFrom nGoingTo)
					(client
						setMotion:
							MoveTo
							(GetLocX nComingFrom)
							(- (GetLocY nComingFrom) 15)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(GetLocX nComingFrom)
							(+ (GetLocY nComingFrom) 15)
							self
					)
				)
			)
			(1
				(if (< nComingFrom nGoingTo)
					(client
						setMotion:
							MoveTo
							(GetLocX nGoingTo)
							(- (GetLocY nGoingTo) 15)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(GetLocX nGoingTo)
							(+ (GetLocY nGoingTo) 15)
							self
					)
				)
			)
			(2
				(client
					setMotion:
						MoveTo
						(GetLocX nGoingTo)
						(+ (GetLocY nGoingTo) (client getMyYOffset:))
						self
				)
			)
			(3
				(if (and (not (IsMale (client ID:))) (== nStage 1))
					(client setHeading: 135 self)
				else
					(client setHeading: 225 self)
				)
			)
			(4
				(client nPointOn: nGoingTo)
				(client addHotspotVerb: 1)
				(oPointHolds at: nGoingTo (client ID:))
				(if (== nStage 0)
					(client setCycle: 0)
				)
				(CheckForWin)
				(self dispose:)
			)
		)
	)
)

(instance soStartMeUp of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roMusicPuzzle of TPRoom
	(properties
		picture 30500
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 0)
		(InitArrays)
		(aoLeftDoor init:)
		(aoRightDoor init:)
		(gCurRoom setScript: soStartMeUp)
	)

	(method (dispose)
		(if oPointLocs
			(oPointLocs dispose:)
			(= oPointLocs 0)
		)
		(if oPointHolds
			(oPointHolds dispose:)
			(= oPointHolds 0)
		)
		(if oSmallPtLocs
			(oSmallPtLocs dispose:)
			(= oSmallPtLocs 0)
		)
		(if oOstiaries
			(oOstiaries release:)
			(oOstiaries dispose:)
			(= oOstiaries 0)
		)
		(super dispose: &rest)
	)

	(method (gimme)
		(gCurRoom setScript: soWin)
	)
)

