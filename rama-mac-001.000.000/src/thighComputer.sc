;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use VidmailChoices)
(use InvInitialize)
(use RamaInterface)
(use SoundManager)
(use AutoMapProp)
(use BombCtr)
(use newYorkRegion)
(use n1111)
(use Plane)
(use Print)
(use Inset)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	thighComputer 0
	proc44_2 2
	proc44_3 3
	proc44_4 4
	proc44_5 5
	proc44_6 6
	theTimer 7
	proc44_8 8
)

(procedure (proc44_2 &tmp temp0 temp1)
	(cond
		((IsFlag 14)
			((ScriptID 75 0) dispose:) ; InvInset
		)
		((IsFlag 94)
			((ScriptID 1013 0) dispose:) ; hubComputer
			(UpdatePlane global116)
			(FrameOut)
			(= temp1 (+ (GetTime) 30))
			(while (< (GetTime) temp1)
			)
		)
	)
	(= temp0 (proc70_6 39))
	(if (and (gTheCursor invItem:) (!= (gTheCursor invItem:) temp0))
		(proc70_1 (proc70_7 (gTheCursor invItem:)) 1)
	)
	(temp0 hide:)
	(temp0 cel: 0)
	(gTheCursor setInvCursor: temp0)
	(gTheCursor lolite: 1)
	(thighComputer init:)
	(proc70_1 39 1)
)

(procedure (proc44_8)
	(decryptCast init:)
	(decryptPlane
		picture: -2
		priority: (+ ((thighComputer plane:) priority:) 2)
		init: 0 0 250 50
		posn: 0 0 (thighComputer plane:)
	)
	(decryptPlane addCast: decryptCast)
	(if (IsFlag 13)
		(decryptAnim setCel: (decryptAnim lastCel:) init: decryptCast)
	else
		(decryptAnim setCel: 0 init: decryptCast setCycle: End)
		(SetFlag 13)
	)
	(UpdatePlane decryptPlane)
	(gTheDoits add: decryptAnim)
)

(procedure (proc44_3 &tmp temp0)
	(if (IsFlag 12)
		(proc55_4)
	)
	(= temp0 (proc70_6 39))
	(if (and (gTheCursor invItem:) (!= (gTheCursor invItem:) temp0))
		(proc70_1 39 1 (InventoryWindow whichHas: temp0))
	)
	(temp0 cel: 2)
	(thighComputer dispose:)
)

(procedure (proc44_5)
	(if ((thighComputer insetCast:) contains: timeRemaining)
		(theTimer hide:)
		(timeRemaining hide:)
	)
	(theExitButton hide:)
	(vidMailButton hide:)
	(automap hide:)
)

(procedure (proc44_6)
	(if ((thighComputer insetCast:) contains: timeRemaining)
		(theTimer show:)
		(timeRemaining show:)
	)
	(theExitButton show:)
	(vidMailButton show:)
	(automap show:)
)

(procedure (proc44_4)
	((AutoMapInset curMapInset:) dispose:)
)

(instance thighComputer of Inset
	(properties
		x 0
		y 0
	)

	(method (init)
		(SoundManager pauseMusic: 1 10 20)
		(= priority (+ ((gCurRoom plane:) priority:) 5))
		(if (<= global188 3)
			(= picture 41)
		else
			(= picture 40)
		)
		(super init: &rest)
		(gGame saveRobot: 1)
		(if (and oTimers (oTimers contains: NukeTimer) (proc1111_24 157))
			(NukeTimer setReal: NukeTimer (NukeTimer seconds:))
			(theTimer init: insetCast)
			(proc201_2 theTimer)
			(timeRemaining init: insetCast)
		)
		(if (or (== (proc70_9 31) 55) (== (proc70_9 32) 55))
			(proc44_8)
		)
		(cursorCatcher plane: (self plane:) init:)
		(vidMailButton plane: (self plane:) init:)
		(automap plane: (self plane:) init:)
		(theExitButton plane: (self plane:) init:)
	)

	(method (doit)
		(if
			(and
				oTimers
				(oTimers contains: NukeTimer)
				(proc1111_24 157)
				(<= (NukeTimer seconds:) 1)
			)
			(gGame handsOff:)
			(proc44_3)
		else
			(super doit: &rest)
		)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(if inView
			(plane setBitmap: inView 0)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose)
		(if (and oTimers (oTimers contains: NukeTimer) (proc1111_24 157))
			(if inset
				((inset oTimers:) release:)
			else
				(gTimers release:)
			)
			(proc201_3 theTimer)
			(theTimer dispose:)
		)
		(gGame saveRobot: 0)
		(SoundManager pauseMusic: 0 10 20)
		(if (IsFlag 12)
			(proc55_4)
		)
		(if (or (== (proc70_9 31) 55) (== (proc70_9 32) 55))
			(gTheDoits delete: decryptAnim)
			(decryptCast dispose:)
			(decryptPlane dispose:)
		)
		(super dispose:)
	)
)

(instance theExitButton of View
	(properties
		noun 113
		x 29
		y 252
		view 207
		loop 2
		cel 2
	)

	(method (init)
		(super init: (thighComputer insetCast:) &rest)
		(self setHotspot: 2)
		(&= signal $efff)
		(= case 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (gTheCursor isInvCursor:))
					(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
					(RamaInterface displayOptionsText: 90 noun 0 case 1)
				else
					(super doVerb: theVerb)
				)
			)
			(2
				(butnSnd play:)
				(if (IsFlag 12)
					(proc55_4)
				)
				(proc90_2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance automap of View
	(properties
		noun 93
		case 7
		x 29
		y 109
		view 207
		loop 2
		cel 1
	)

	(method (init)
		(if global190
			(super init: (thighComputer insetCast:) &rest)
			(self setHotspot: 2)
			(&= signal $efff)
			(= case 7)
		)
	)

	(method (show)
		(if global190
			(super show: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (gTheCursor isInvCursor:))
					(RamaInterface displayOptionsText: 90 noun 0 case 1)
					(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
				else
					(super doVerb: theVerb)
				)
			)
			(2
				(butnSnd play:)
				(switch global190
					(1
						(thighComputer setInset: (ScriptID 351 0)) ; bangkokMap
					)
					(2
						(thighComputer setInset: (ScriptID 352 0)) ; baseCampMap
					)
					(3
						(thighComputer setInset: (ScriptID 353 0)) ; beamMap
					)
					(4
						(thighComputer setInset: (ScriptID 354 0)) ; iceportMap
					)
					(5
						(thighComputer setInset: (ScriptID 355 0)) ; londonMap
					)
					(6
						(thighComputer setInset: (ScriptID 356 0)) ; wheelMap
					)
					(7
						(thighComputer setInset: (ScriptID 357 0)) ; newYorkMap
					)
					(8
						(thighComputer setInset: (ScriptID 358 0)) ; avianPlazaMap
					)
					(9
						(thighComputer setInset: (ScriptID 359 0)) ; avianMap
					)
					(10
						(thighComputer setInset: (ScriptID 360 0)) ; octoPlazaMap
					)
					(11
						(thighComputer setInset: (ScriptID 361 0)) ; octoLairMap
					)
					(12
						(thighComputer setInset: (ScriptID 362 0)) ; humanPlazaMap
					)
					(13
						(thighComputer setInset: (ScriptID 363 0)) ; humanLairMap
					)
					(16
						(thighComputer setInset: (ScriptID 366 0)) ; hubSiteMap
					)
					(15
						(thighComputer setInset: (ScriptID 365 0)) ; londonOutsideMap
					)
					(14
						(thighComputer setInset: (ScriptID 364 0)) ; bangkokOutsideMap
					)
					(else
						(Prints
							{Sorry, No Auto-Map defined for current area.}
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vidMailButton of View
	(properties
		noun 92
		x 29
		y 62
		view 207
		loop 2
	)

	(method (init)
		(super init: (thighComputer insetCast:) &rest)
		(self setHotspot: 2)
		(&= signal $efff)
		(= case 7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (gTheCursor isInvCursor:))
					(RamaInterface displayOptionsText: 90 noun 0 case 1)
					(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
				else
					(super doVerb: theVerb)
				)
			)
			(2
				(butnSnd play:)
				(if (not (IsFlag 12))
					(proc55_3 0)
				else
					(proc55_4)
					(= case 7)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance decryptCast of Cast
	(properties)
)

(instance decryptPlane of Plane
	(properties)
)

(instance decryptAnim of Prop
	(properties
		x 16
		y 10
		view 210
	)
)

(instance theTimer of BombCtr
	(properties
		xPos 319
		yPos 38
	)
)

(instance timeRemaining of View
	(properties
		x 319
		y 11
		view 207
		loop 5
	)
)

(instance cursorCatcher of Feature
	(properties
		nsRight 592
		nsBottom 292
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 56 50)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(56
				(= temp0 (gTheCursor invItem:))
				(proc70_3 (proc70_7 temp0))
				(insertCardSnd play:)
				(gTheCursor setInvCursor: (proc70_6 39))
				(proc55_3 (proc55_2 temp0))
				(proc70_1 39 1)
			)
			(50
				(= temp1 (gTheCursor invItem:))
				(proc70_3 (proc70_7 temp1))
				(insertCardSnd play:)
				(gTheCursor setInvCursor: (proc70_6 39))
				(proc70_10 (proc70_7 temp1) 55)
				(proc44_8)
				(if (IsFlag 12)
					(proc55_3 -1)
				)
				(proc70_1 39 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mapCursorCatcher of Feature ; UNUSED
	(properties
		nsRight 592
		nsBottom 292
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 31)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance butnSnd of Sound
	(properties
		number 4003
	)
)

(instance computerSnd of Sound ; UNUSED
	(properties
		flags 5
		number 1013
	)
)

(instance realtimeVMSnd of Sound ; UNUSED
	(properties
		flags 5
		number 4023
	)
)

(instance insertCardSnd of Sound
	(properties
		flags 5
		number 6102
	)
)

