;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use User)
(use System)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
	(properties)
)

(instance sounds of EventHandler
	(properties)

	(method (pause tOrF)
		(self eachElementDo: #perform mayPause (if argc tOrF else 1))
	)
)

(instance mayPause of Code
	(properties)

	(method (doit theSound tOrF)
		(if (not (& (theSound flags:) $0001))
			(theSound pause: tOrF)
		)
	)
)

(instance regions of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)

	(method (doit)
		(AddToPic elements)
	)
)

(instance timers of Set
	(properties)
)

(class Game of Obj
	(properties
		script 0
		parseLang 1
		printLang 1
		subtitleLang 0
		_detailLevel 3
		egoMoveSpeed 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1 init: setCursor: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (quitGame tOrF)
		(if (or (not argc) tOrF)
			(= gQuit 1)
		)
	)

	(method (masterVolume newVol)
		(if argc
			(DoSound sndMASTER_VOLUME newVol)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (detailLevel theLevel)
		(if argc
			(= _detailLevel theLevel)
			(gCast eachElementDo: #checkDetail)
		)
		(return _detailLevel)
	)

	(method (replay))

	(method (init)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
	)

	(method (doit &tmp temp0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
			)
		else
			(gSounds eachElementDo: #check)
			(gTimers eachElementDo: #doit)
			(if gModelessDialog
				(gModelessDialog check:)
			)
			(Animate (gCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: #motionCue)
			)
			(if script
				(script doit:)
			)
			(gRegions eachElementDo: #doit)
			(if (== gNewRoomNum gCurRoomNum)
				(gUser doit:)
			)
			(gTheDoits doit:)
			(if (!= gNewRoomNum gCurRoomNum)
				(self newRoom: gNewRoomNum)
			)
			(gTimers eachElementDo: #delete)
			(GameIsRestarting 0)
		)
	)

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5)
		(gAddToPics eachElementDo: #dispose release:)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gTheDoits release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(self startRoom: gCurRoomNum checkAni:)
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp theExtra)
		(Animate (gCast elements:) 0)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(while (> (Wait 0) global30)
			(breakif (== (= theExtra (gCast firstTrue: #isExtra)) 0))
			(theExtra addToPic:)
			(Animate (gCast elements:) 0)
			(gCast eachElementDo: #delete)
		)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(gCurRoom init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((== (event type:) evVERB)
				(self pragmaFail:)
			)
		)
		(event claimed:)
	)

	(method (changeScore delta)
		(+= gScore delta)
	)

	(method (restart)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (save &tmp [temp0 23]))

	(method (restore &tmp [temp0 23]))

	(method (setSpeed newSpeed &tmp oldSpeed)
		(= oldSpeed gSpeed)
		(= gSpeed newSpeed)
		(return oldSpeed)
	)

	(method (setCursor form &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(SetCursor form &rest)
		(return oldCur)
	)

	(method (showMem))

	(method (pragmaFail))

	(method (notify))

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		lookStr 0
	)

	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			(
				(not
					(and
						script
						(or (script handleEvent: event) 1)
						(event claimed:)
					)
				)
				(event
					claimed:
						(self
							doVerb:
								(event message:)
								(and
									gInventory
									gTheIconBar
									(== (event message:) JOY_DOWNRIGHT)
									(gInventory indexOf: (gTheIconBar curInvIcon:))
								)
						)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) lookStr)
			(Printf 994 0 lookStr) ; "%s"
			(return 1)
		else
			(return 0)
		)
	)

	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (newRoom))

	(method (notify))
)

(class Rm of Rgn
	(properties
		picture 0
		style -1
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		obstacles 0
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: EDGE_NONE)
	)

	(method (reflectPosn))

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
	)

	(method (edgeToRoom))

	(method (roomToEdge))

	(method (dispose)
		(if controls
			(controls dispose:)
		)
		(if obstacles
			(obstacles dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(or
			(super handleEvent: event)
			(and controls (controls handleEvent: event))
		)
		(event claimed:)
	)

	(method (setRegions region &tmp i n regID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [region i])
			(= regID (ScriptID n))
			(regID number: n)
			(gRegions add: regID)
			(if (not (regID initialized:))
				(regID init:)
			)
		)
	)

	(method (setLocales &tmp [temp0 3]))

	(method (setFeatures feature &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures add: [feature temp0])
		)
	)

	(method (addObstacle))

	(method (newRoom newRoomNumber)
		(gRegions delete: self eachElementDo: #newRoom newRoomNumber addToFront: self)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic pic theStyle)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(= curPic pic)
		(= gOverlays -1)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else global17)
			)
			1
			global40
		)
	)

	(method (overlay pic theStyle)
		(= gOverlays pic)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else global17)
			)
			0
			global40
		)
	)
)

(instance DNKR of Code
	(properties)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance fDC of Code
	(properties)

	(method (doit theFeature)
		(if (theFeature respondsTo: #delete)
			(theFeature signal: (& (theFeature signal:) $ffdf) dispose: delete:)
		else
			(theFeature dispose:)
		)
	)
)

