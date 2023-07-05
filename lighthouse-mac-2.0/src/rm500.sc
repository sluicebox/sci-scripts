;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use LightRoom)
(use TrackingProp)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(if (and (IsFlag 224) (== global232 500))
		(fBatDoor init:)
	)
	(crankBackUp newPic: 512 8)
	(cond
		((IsFlag 228)
			(doubleCrank
				init:
				setPoints:
					28
					-85
					102
					-61
					135
					0
					122
					65
					73
					111
					7
					124
					-55
					112
					-96
					64
					-99
					-1
					-51
					-61
			)
		)
		((IsFlag 132)
			(leftGearProp init:)
			(rightGearProp init:)
		)
		(else
			(leftGearSlot init:)
			(rightGearSlot init:)
		)
	)
)

(procedure (localproc_1)
	(if (and (not (IsFlag 131)) (not (IsFlag 224)))
		(gearsView init:)
	)
	((ScriptID 1 4) newPic: 515 1) ; exitRight
	((ScriptID 1 3) newPic: 514 5) ; exitLeft
	((ScriptID 1 1) newPic: 508 6) ; exitForward
	(if (not (IsFlag 131))
		(FrameOut)
		(Load rsAUDIO 453)
	)
)

(procedure (localproc_2)
	(if (not (IsFlag 131))
		(gearsView init:)
	)
	(if (and (IsFlag 224) (== global232 500))
		(fBatDoor init:)
	)
	((ScriptID 1 4) newPic: 6503 7) ; exitRight
	(if (and (IsFlag 224) (== global232 500))
		(to6502frm512 newPic: 6502 7)
	else
		(to6502f512no newPic: 6502 7)
	)
	(crankCU init: newPic: 6507 1)
	(if (IsFlag 132)
		(gearsATP init:)
	)
	(if (and (not (IsFlag 131)) (not (IsFlag 224)))
		(FrameOut)
		(Load rsAUDIO 453)
	)
)

(procedure (localproc_3)
	(if (and (IsFlag 224) (== global232 500))
		(fBatDoor init:)
	)
	(if (and (not (IsFlag 126)) (not (IsFlag 224)))
		(batCrankHandle init:)
	)
	((ScriptID 1 3) newPic: 6502 7) ; exitLeft
	(if (and (IsFlag 224) (== global232 500))
		(t6503f508bat newPic: 6503 7)
	else
		(t6503f508nob newPic: 6503 7)
	)
	(if (not (IsFlag 126))
		(FrameOut)
		(Load rsAUDIO 453)
	)
)

(instance rm500 of LightRoom
	(properties
		picture 506
	)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(Lock rsAUDIO 10075 1)
		(Lock rsVIEW 6505 1)
		(Lock rsVIEW 6506 1)
		(Lock rsVIEW 517 1)
		(Lock rsVIEW 525 1)
		(Lock rsVIEW 520 1)
		(Lock rsVIEW 527 1)
		(Lock rsVIEW 529 1)
		(Lock rsVIEW 528 1)
		(Lock rsVIEW 6541 1)
		(gBackMusic number: 10075 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(switch gPrevRoomNum
			(490
				(self changeScene: 506 4)
			)
			(510
				(self changeScene: 6511 1)
			)
			(710
				(= global232 500)
				(= global228 0)
				(= local2 1)
				(ClearFlag 232)
				(self changeScene: 256 3)
			)
			(else
				(self changeScene: 506 4)
			)
		)
	)

	(method (notify)
		(= global228 0)
		(ClearFlag 232)
		(gGame handsOff:)
		(gCurRoom setScript: sPlayMovie6516 0 scene)
	)

	(method (changeScene param1 &tmp temp0)
		(= temp0 scene)
		(downHatch dispose:)
		(moveDownLeft dispose:)
		(crankCU dispose:)
		(latchCU dispose:)
		(ladderUp dispose:)
		(moveDesk dispose:)
		(alanWrench dispose:)
		(batCrankHandle dispose:)
		(gearsView dispose:)
		(rightGearSlot dispose:)
		(leftGearSlot dispose:)
		(doubleCrank dispose:)
		(leftGearProp dispose:)
		(rightGearProp dispose:)
		(fWinchHandle dispose:)
		(fWinchLock dispose:)
		(pWinchHandle dispose:)
		(pWinchLock dispose:)
		(fBatDoor dispose:)
		(fLidHandle dispose:)
		(pLid dispose:)
		(pSpringLatch dispose:)
		(pSpringHandle dispose:)
		(pNeedle dispose:)
		(batToPic dispose:)
		(winchView dispose:)
		(gearsATP dispose:)
		(to6551_512 dispose:)
		(to512from511 dispose:)
		(to6502frm512 dispose:)
		(to6502f512no dispose:)
		(upLatter510 dispose:)
		(upladder509 dispose:)
		(to514from506 dispose:)
		(faceDesk dispose:)
		(to515fr6502 dispose:)
		(to513fr6502 dispose:)
		(t6503f508bat dispose:)
		(t6503f508nob dispose:)
		(to508f6501 dispose:)
		(to6508fro514 dispose:)
		(upLadder505 dispose:)
		(crankBackUp dispose:)
		(pBatDoor dispose:)
		(if
			(and
				(IsFlag 224)
				(== global232 500)
				(OneOf param1 507 508 512 6507)
			)
			(switch param1
				(507
					(super changeScene: 6550 11)
				)
				(508
					(super changeScene: 6552 6)
				)
				(512
					(super changeScene: 6551 8)
				)
				(6507
					(super changeScene: 6509 1)
				)
			)
		else
			(super changeScene: param1 &rest)
		)
		(switch param1
			(256
				(pLid init: setPri: 1)
				(if local2
					(pLid setCel: 0)
				else
					(gGame handsOff:)
					(pLid setCel: 11 setScript: sEnterCockpit)
				)
				(pSpringHandle init:)
				(pSpringLatch
					init:
					setCel: 0
					setPri: (+ (pSpringHandle priority:) 1)
				)
				(pNeedle init: setCel: (/ global228 9))
				(if (and (> (pNeedle cel:) 12) (< (pNeedle cel:) 17))
					(if (IsFlag 232)
						(pSpringLatch
							setCel: 8
							setPri: (- (pSpringHandle priority:) 1)
						)
					else
						(ClearFlag 232)
						(pSpringLatch
							setCel: 0
							setPri: (+ (pSpringHandle priority:) 1)
						)
					)
				else
					(ClearFlag 232)
					(pSpringLatch
						setCel: 0
						setPri: (+ (pSpringHandle priority:) 1)
					)
				)
				(fLidHandle init:)
				(if local2
					(= local2 0)
					(PlayVMD 6) ; Close
				)
			)
			(506
				(if (not (IsFlag 126))
					(batCrankHandle init:)
				)
				((ScriptID 1 4) newPic: 6501 4) ; exitRight
				((ScriptID 1 3) newPic: 6500 6) ; exitLeft
				((ScriptID 1 2) newPic: 515 1) ; exitBack
				(to514from506 newPic: 514 5)
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
				(if (not (IsFlag 126))
					(FrameOut)
					(Load rsAUDIO 453)
				)
			)
			(507
				(localproc_1)
			)
			(508
				(localproc_3)
			)
			(509
				(latchCU init: newPic: 6505 14)
				(upladder509 newPic: 6511 1)
				((ScriptID 1 3) newPic: 510 16) ; exitLeft
				((ScriptID 1 2) newPic: 6508 3) ; exitBack
				(if (IsFlag 223)
					(winchView init:)
				)
			)
			(510
				((ScriptID 1 4) newPic: 509 15) ; exitRight
				((ScriptID 1 3) newPic: 511 10) ; exitLeft
				(upLatter510 newPic: 6511 1)
				(moveDesk
					nsLeft: 127
					nsTop: 184
					nsRight: 243
					nsBottom: 265
					init:
					newPic: 513 8
				)
			)
			(511
				(if (and (not (IsFlag 131)) (not (IsFlag 224)))
					(gearsView init:)
				)
				(if (and (IsFlag 224) (== global232 500))
					(to512from511 newPic: 512 8)
				else
					((ScriptID 1 1) ; exitForward
						newPic: 512 8
						arrowStyle: 7
						nsLeft: 60
						nsTop: 30
						nsRight: 150
						nsBottom: 210
					)
				)
				((ScriptID 1 4) newPic: 510 16) ; exitRight
				((ScriptID 1 3) newPic: 6508 3) ; exitLeft
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
				(if (IsFlag 132)
					(gearsATP init:)
				)
				(if (not (IsFlag 131))
					(FrameOut)
					(Load rsAUDIO 453)
				)
			)
			(512
				(localproc_2)
			)
			(513
				((ScriptID 1 3) newPic: 515 1) ; exitLeft
				((ScriptID 1 2) newPic: 514 5) ; exitBack
				((ScriptID 1 1) newPic: 6506 8) ; exitForward
			)
			(514
				(if (and (not (IsFlag 126)) (not (IsFlag 224)))
					(batCrankHandle init:)
				)
				((ScriptID 1 4) newPic: 507 11) ; exitRight
				(if (not (IsFlag 224))
					((ScriptID 1 6) newPic: 516 13) ; exitUp
				)
				((ScriptID 1 2) newPic: 513 8) ; exitBack
				(to6508fro514 newPic: 6508 3)
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
			)
			(515
				((ScriptID 1 4) newPic: 513 8) ; exitRight
				((ScriptID 1 3) newPic: 6501 4) ; exitLeft
				(downHatch init:)
			)
			(516
				((ScriptID 1 5) newPic: 514 5) ; exitDown
			)
			(6500
				(faceDesk newPic: 6506 8)
				((ScriptID 1 4) newPic: 506 4) ; exitRight
				(if (IsFlag 223)
					(winchView init:)
				)
			)
			(6501
				(to508f6501 newPic: 508 6)
				((ScriptID 1 3) newPic: 506 4) ; exitLeft
				((ScriptID 1 4) newPic: 515 1) ; exitRight
				(if (not (IsFlag 131))
					(gearsView init:)
				)
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init: setPri: 300)
				)
			)
			(6502
				(to513fr6502 newPic: 513 8)
				((ScriptID 1 4) newPic: 508 6) ; exitRight
				(to515fr6502 newPic: 515 1)
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
			)
			(6503
				(if (not (IsFlag 126))
					(batCrankHandle init:)
				)
				((ScriptID 1 1) newPic: 509 15) ; exitForward
				((ScriptID 1 3) newPic: 512 8) ; exitLeft
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
				(if (IsFlag 223)
					(winchView init:)
				)
				(if (not (IsFlag 126))
					(FrameOut)
					(Load rsAUDIO 453)
				)
			)
			(6505
				((ScriptID 1 7) newPic: 509 15) ; exitBackUp
				(upLadder505 newPic: 6511 1)
				(if (not (IsFlag 223))
					(fWinchLock init:)
					(FrameOut)
					(Load rsAUDIO 45001)
					(Load rsAUDIO 45002)
				else
					(pWinchLock init: setCel: 35)
					(if (not (IsFlag 224))
						(fWinchHandle init:)
						(FrameOut)
						(Load rsAUDIO 45002)
					else
						(pWinchHandle init: setCel: 13)
					)
				)
			)
			(6506
				((ScriptID 1 7) newPic: 513 8) ; exitBackUp
				(if (not (IsFlag 91))
					(if (not (IsFlag 91))
						(alanWrench init:)
					)
					(FrameOut)
					(Load rsAUDIO 453)
				)
			)
			(6507
				(localproc_0)
			)
			(6508
				(if (not (IsFlag 126))
					(batCrankHandle init:)
				)
				((ScriptID 1 4) newPic: 511 10) ; exitRight
				((ScriptID 1 2) newPic: 509 15) ; exitBack
				(to6551_512 newPic: 512 8)
				(if (and (IsFlag 224) (== global232 500))
					(batToPic init:)
				)
				(if (IsFlag 132)
					(gearsATP init:)
				)
				(if (not (IsFlag 126))
					(FrameOut)
					(Load rsAUDIO 453)
				)
			)
			(6509
				(localproc_0)
			)
			(6511
				(if (OneOf temp0 509 510 6505)
					(= global241 temp0)
				)
				((ScriptID 1 6) newRoom: 510) ; exitUp
				((ScriptID 1 5) ; exitDown
					newPic:
						global241
						(switch global241
							(509 15)
							(510 16)
							(6505 14)
						)
				)
			)
			(6550
				(localproc_1)
			)
			(6551
				(localproc_2)
			)
			(6552
				(localproc_3)
			)
		)
	)

	(method (dispose)
		(Lock rsAUDIO 10075 0)
		(Lock rsVIEW 6505 0)
		(Lock rsVIEW 6506 0)
		(Lock rsVIEW 517 0)
		(Lock rsVIEW 525 0)
		(Lock rsVIEW 520 0)
		(Lock rsVIEW 527 0)
		(Lock rsVIEW 529 0)
		(Lock rsVIEW 528 0)
		(Lock rsVIEW 6541 0)
		(gBackMusic fade:)
		(super dispose: &rest)
	)
)

(instance doubleCrank of TrackingProp
	(properties
		x 318
		y 175
		view 517
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 600)
		(approachX hotVerbs: 5)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= cel local0)
			(if
				(and
					(IsFlag 224)
					(or
						(and (> cel local0) (!= cel 9))
						(and (== cel 9) (!= local0 0))
						(and (== cel 0) (== local0 9))
					)
				)
				(localSound number: 45007 play:)
				(if (> (++ global228) 144)
					(= global228 0)
					(gGame handsOff:)
					(= tracking 0)
					(self doMouseUp: setScript: sUnwindCrank)
				)
			else
				(or
					(and (< cel local0) (!= cel 0))
					(and (== cel 0) (!= local0 9))
				)
				(if (!= script sUnwindCrank)
					(localSound number: 45006 play:)
				)
			)
		)
		(= local0 cel)
	)
)

(instance sUnwindCrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doubleCrank setCycle: Rev)
				(localSound number: 45006 setLoop: -1 play:)
				(= seconds 6)
			)
			(1
				(if (doubleCrank cel:)
					(doubleCrank setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(2
				(doubleCrank setCycle: 0)
				(localSound setLoop: 1 stop:)
				(= global228 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftGearProp of Prop
	(properties
		x 206
		y 60
		view 517
		loop 2
		cel 4
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 52)
	)

	(method (doVerb theVerb)
		(rightGearProp doVerb: theVerb &rest)
	)
)

(instance rightGearProp of Prop
	(properties
		x 206
		y 60
		view 517
		loop 2
		cel 3
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 52)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; invCrank
				(gInventory deleteItem: (ScriptID 9 43)) ; invCrank
				(localSound number: 45005 play:)
				(SetFlag 228)
				(leftGearProp dispose:)
				(rightGearProp dispose:)
				(if (IsFlag 132)
					(doubleCrank
						init:
						setPoints:
							28
							-85
							102
							-61
							135
							0
							122
							65
							73
							111
							7
							124
							-55
							112
							-96
							64
							-99
							-1
							-51
							-61
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance alanWrench of View
	(properties
		x 64
		y 225
		view 6541
		cel 2
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(localSound number: 453 setLoop: 1 play:)
				(SetFlag 91)
				(gInventory addItem: (ScriptID 9 37)) ; invAlanWrench
				(self dispose:)
			)
		)
	)
)

(instance batCrankHandle of View
	(properties
		x 111
		y 168
		view 520
	)

	(method (init)
		(switch (gCurRoom scene:)
			(506
				(self view: 528 posn: 206 118)
			)
			(508
				(self view: 529 posn: 228 92)
			)
			(514
				(self view: 6563 posn: 275 172)
			)
			(6503
				(self view: 527 posn: 374 130)
			)
			(6508
				(self view: 520 posn: 111 168)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 126)
				(localSound number: 453 setLoop: 1 play:)
				(gInventory addItem: (ScriptID 9 43)) ; invCrank
				(self dispose:)
			)
		)
	)
)

(instance gearsView of View
	(properties
		view 525
	)

	(method (init &tmp temp0)
		(cond
			((or (== (= temp0 (gCurRoom scene:)) 507) (== temp0 6550))
				(self view: 521 posn: 370 224)
			)
			((== temp0 511)
				(self view: 525 posn: 238 186)
			)
			((or (== temp0 512) (== temp0 6551))
				(self view: 526 posn: 134 237)
			)
			((== temp0 6502)
				(self view: 6502 posn: 401 278)
			)
			((== temp0 6501)
				(self view: 6517 posn: 298 260)
			)
		)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 131)
				(localSound setLoop: 1 number: 453 play:)
				(gInventory addItem: (ScriptID 9 44)) ; invGears
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance pWinchLock of Prop
	(properties
		x 285
		y 168
		view 6505
	)

	(method (cue)
		(SetFlag 223)
		(fWinchLock dispose:)
		(fWinchHandle init:)
		(gGame handsOn:)
	)
)

(instance pWinchHandle of Prop
	(properties
		x 182
		y 189
		view 6506
	)

	(method (cue)
		(proc0_8 522)
		(gGame handsOn:)
	)
)

(instance pLid of Prop
	(properties
		y 187
		view 3256
		loop 3
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (cue)
		(gGame handsOn:)
		(switch local1
			(6551
				(gCurRoom changeScene: 512 8)
			)
			(6552
				(gCurRoom changeScene: 508 6)
			)
			(0
				(gCurRoom changeScene: 6509 1)
			)
			(else
				(gCurRoom changeScene: 6507 1)
			)
		)
	)
)

(instance pSpringLatch of Prop
	(properties
		x 45
		y 171
		view 3256
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (> (pNeedle cel:) 12) (< (pNeedle cel:) 17) (not cel))
					(gGame handsOff:)
					(SetFlag 232)
					(localSound number: 45012 setLoop: 1 play:)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pSpringHandle of Prop
	(properties
		x 45
		y 171
		view 3256
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gCurRoom drawPic: 0)
		(self hide:)
		(pLid hide:)
		(pNeedle hide:)
		(pSpringLatch hide:)
		(FrameOut)
		(proc0_8 6518)
		(= global232 710)
		(= global224 1)
		(= global225 710)
		(gGame getDisc: global224)
		(gCurRoom newRoom: global225)
	)

	(method (doVerb)
		(if (pSpringLatch cel:)
			(gGame handsOff:)
			(localSound number: 45013 setLoop: 1 play:)
			(self setPri: (+ (pSpringLatch priority:) 1) setCycle: End self)
		)
	)
)

(instance pNeedle of Prop
	(properties
		x 45
		y 171
		view 3256
		loop 2
	)
)

(instance rightGearSlot of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 134 281 157 277 183 297 207 332 203 356 177 353 143
					yourself:
				)
		)
		(approachX hotVerbs: 53)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; invGears
				(SetFlag 133)
				(SetFlag 132)
				(localSound number: 45005 play:)
				(rightGearProp init:)
				(leftGearProp init:)
				(gInventory deleteItem: (ScriptID 9 44)) ; invGears
				(leftGearSlot dispose:)
				(self dispose:)
			)
		)
	)
)

(instance leftGearSlot of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 183 207 205 207 236 235 263 278 259 301 232 296 203 271 181
					yourself:
				)
		)
		(approachX hotVerbs: 53)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(53 ; invGears
				(SetFlag 133)
				(SetFlag 132)
				(localSound number: 45005 play:)
				(if (IsFlag 228)
					(doubleCrank
						init:
						setPoints:
							28
							-85
							102
							-61
							135
							0
							122
							65
							73
							111
							7
							124
							-55
							112
							-96
							64
							-99
							-1
							-51
							-61
					)
				else
					(rightGearProp init:)
					(leftGearProp init:)
				)
				(gInventory deleteItem: (ScriptID 9 44)) ; invGears
				(rightGearSlot dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fWinchLock of Feature
	(properties
		x 299
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 117 332 117 332 195 264 195
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 46)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; invAlanWrench
				(localSound number: 45001 play:)
				(gInventory deleteItem: (ScriptID 9 37)) ; invAlanWrench
				(gGame handsOff:)
				(pWinchLock init: setCycle: End pWinchLock)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWinchHandle of Feature
	(properties
		x 203
		y 200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(SetFlag 224)
				(localSound number: 45002 play:)
				(pWinchHandle init: setCycle: End pWinchHandle)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 145 175 186 231 186 231 145
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fBatDoor of Feature
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(6551
				(= x 95)
				(= y 155)
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 22 180 79 197 139 192 160 175 168 152 130 114 84 125 51 143
							yourself:
						)
				)
			)
			(6552
				(= x 407)
				(= y 127)
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 340 156 404 171 494 148 469 116 414 88 371 83 348 85 321 117
							yourself:
						)
				)
			)
			(6509
				(= x 103)
				(= y 38)
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 57 70 83 77 133 68 152 30 121 0 78 13 54 47
							yourself:
						)
				)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(= local1 (gCurRoom scene:))
				(gCurRoom setScript: sOpenCockpit)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pBatDoor of Prop
	(properties)
)

(instance sOpenCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local1
					(6551
						(Load rsAUDIO 45010)
						(pBatDoor
							view: 6551
							cel: 0
							x: 0
							y: 299
							init:
							setCycle: End self
						)
						(localSound number: 45010 setLoop: 1 play:)
					)
					(6552
						(Load rsAUDIO 45010)
						(pBatDoor
							view: 6552
							cel: 0
							x: 137
							y: 222
							init:
							setCycle: End self
						)
						(localSound number: 45010 setLoop: 1 play:)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gCurRoom changeScene: 256 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fLidHandle of Feature
	(properties
		x 262
		y 154
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(localSound number: 45010 setLoop: 1 play:)
				(pLid setCel: 0 setCycle: End pLid)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 136 274 136 272 172 252 172
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance downHatch of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 6)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 167 228 143 293 200 195 234
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance moveDesk of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(super init: &rest)
	)
)

(instance moveDownLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 9)
		(= nsLeft 0)
		(= nsTop 209)
		(= nsRight 186)
		(= nsBottom 299)
		(super init: &rest)
	)
)

(instance crankCU of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 299 242 241 273 149 319 146 351 251 343 299
					yourself:
				)
		)
	)
)

(instance latchCU of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 329 105 329 181 403 181 403 105
					yourself:
				)
		)
	)
)

(instance ladderUp of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 5)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 292 240 247 240 0 168 0
					yourself:
				)
		)
	)
)

(instance sEnterCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localSound number: 45011 setLoop: 1 play:)
				(pLid setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance batToPic of View
	(properties)

	(method (init)
		(= view
			(switch (gCurRoom scene:)
				(6501 6553)
				(6502 6554)
				(6503 6555)
				(6508 6556)
				(506 6557)
				(511 6558)
				(514 6559)
			)
		)
		(= x
			(switch (gCurRoom scene:)
				(514 401)
				(506 204)
				(6508 300)
				(6502 259)
				(else 0)
			)
		)
		(= y
			(switch (gCurRoom scene:)
				(514 43)
				(else 0)
			)
		)
		(self setPri: 2)
		(super init: &rest)
	)
)

(instance gearsATP of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(511
				(= view 525)
				(= loop 1)
				(= cel (if (IsFlag 228) 0 else 1))
				(= x 125)
				(= y 160)
			)
			(512
				(= view 526)
				(= loop 1)
				(= cel (if (IsFlag 228) 0 else 1))
				(= x 243)
				(= y 145)
			)
			(6551
				(= view 526)
				(= loop 1)
				(= cel (if (IsFlag 228) 0 else 1))
				(= x 243)
				(= y 145)
			)
			(6508
				(= view 520)
				(= loop 1)
				(= cel (if (IsFlag 228) 0 else 1))
				(= x 435)
				(= y 173)
			)
		)
		(super init: &rest)
	)
)

(instance winchView of View
	(properties
		x 450
		y 102
		view 6500
		loop 1
	)

	(method (init)
		(switch (gCurRoom scene:)
			(509
				(= view 6562)
				(= loop (if (IsFlag 224) 0 else 1))
				(= x 329)
				(= y 96)
			)
			(6500
				(= view 6500)
				(= x 450)
				(= y 102)
			)
			(6503
				(= view 6503)
				(= loop (if (IsFlag 224) 1 else 0))
				(= x 194)
				(= y 105)
			)
		)
		(super init: &rest)
	)
)

(instance to6551_512 of ExitFeature
	(properties
		x 391
		y 158
	)

	(method (init)
		(= arrowStyle 7)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 439 228 439 89 343 89 343 228
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to512from511 of ExitFeature
	(properties
		x 79
		y 80
	)

	(method (init)
		(= arrowStyle 7)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 90 1 0 160 0 160 56 132 97 121 160 75 152 75 90
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to6502frm512 of ExitFeature
	(properties
		x 81
		y 89
	)

	(method (init)
		(= arrowStyle 7)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 164 19 179 52 139 127 111 162 62 144 0 0 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to6502f512no of ExitFeature
	(properties
		x 118
		y 159
	)

	(method (init)
		(= arrowStyle 7)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 32 266 111 266 117 229 204 215 204 53 32 53
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upLatter510 of ExitFeature
	(properties
		x 452
		y 78
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 498 0 498 92 446 92 446 157 406 157 412 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upladder509 of ExitFeature
	(properties
		x 236
		y 81
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 0 277 0 272 161 200 163
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to514from506 of ExitFeature
	(properties
		x 159
		y 143
	)

	(method (init)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 90 70 196 248 196 248 90
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance faceDesk of ExitFeature
	(properties
		x 88
		y 225
	)

	(method (init)
		(= arrowStyle 9)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 153 176 152 177 171 112 299 0 299
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to515fr6502 of ExitFeature
	(properties
		x 124
		y 259
	)

	(method (init)
		(= arrowStyle 9)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 18 220 230 220 230 299 18 299
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to513fr6502 of ExitFeature
	(properties
		x 192
		y 165
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 111 90 219 295 219 295 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance t6503f508bat of ExitFeature
	(properties
		x 425
		y 149
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 352 0 353 30 403 82 473 119 494 147 490 191 434 227 373 225 384 298 499 298 499 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance t6503f508nob of ExitFeature
	(properties
		x 371
		y 141
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 26 455 26 455 256 287 256
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to508f6501 of ExitFeature
	(properties
		x 383
		y 146
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 337 47 440 47 440 245 337 245
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance to6508fro514 of ExitFeature
	(properties
		x 174
		y 210
	)

	(method (init)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 249 96 299 251 299 297 224 174 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upLadder505 of ExitFeature
	(properties
		x 66
		y 83
	)

	(method (init)
		(= arrowStyle 8)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 166 132 166 132 0 0 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance crankBackUp of ExitFeature
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom changeScene: curPic curDir)
	)

	(method (init)
		(= arrowStyle 2)
		(= nsLeft 170)
		(= nsTop 250)
		(= nsRight 330)
		(= nsBottom 300)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 24 5)) ; ???, Do
			(return)
		)
		(if (doubleCrank cel:)
			(gGame handsOff:)
			(doubleCrank setCycle: Beg self)
		else
			(gCurRoom changeScene: curPic curDir)
		)
	)
)

(instance localSound of Sound
	(properties)
)

(instance unwindSound of Sound ; UNUSED
	(properties)
)

(instance sPlayMovie6516 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(cond
					((OneOf register 6501 6502 6503 6508 506 511 514)
						(batToPic init:)
					)
					((OneOf register 507 508 512 6507)
						(switch register
							(507
								(gCurRoom drawPic: 6550)
							)
							(508
								(gCurRoom drawPic: 6552)
							)
							(512
								(gCurRoom drawPic: 6551)
							)
							(6507
								(gCurRoom drawPic: 6509)
							)
						)
					)
				)
				(proc0_8 6516)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

