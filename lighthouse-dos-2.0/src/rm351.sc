;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 351)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use rm400)
(use Osc)
(use Polygon)
(use Feature)
(use Cursor)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm351 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 24
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17 = 1
	local18
	local19
	local20
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (!= (boxPlayer curFrame:) param2)
		(= local14 param1)
		(= temp0
			(if
				(==
					(localproc_2
						(boxPlayer maxFrame:)
						(boxPlayer curFrame:)
						param2
					)
					1
				)
				1
			else
				2
			)
		)
		(rotateCode doit: 1)
		(gMySoundFX number: 20001 setLoop: -1 play:)
		(boxPlayer
			caller: gCurRoom
			loopMe: 1
			startFrame: 0
			end: (boxPlayer maxFrame:)
			cycleTo: param2 temp0 12
		)
		(return 0)
	)
	(return 1)
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
	(param1 nsLeft: param2 nsTop: param3 nsRight: param4 nsBottom: param5)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1)
	(if (== param2 param3)
		(return 0)
	)
	(= temp0
		(if (> param3 param2)
			(- param3 param2)
		else
			(+ (- param1 param2) param3)
		)
	)
	(return
		(if
			(<
				(= temp1
					(if (< param3 param2)
						(- param2 param3)
					else
						(+ param2 (- param1 param3))
					)
				)
				temp0
			)
			-1
		else
			1
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8) ; UNUSED
	(= temp0 (List new:))
	(if (not (param1 onMeCheck:))
		(temp0
			add:
				(AddLine
					gThePlane
					(param1 nsLeft:)
					(param1 nsTop:)
					(param1 nsRight:)
					(param1 nsTop:)
					5000
					255
					0
					0
					1
				)
		)
		(temp0
			add:
				(AddLine
					gThePlane
					(param1 nsRight:)
					(param1 nsTop:)
					(param1 nsRight:)
					(param1 nsBottom:)
					5000
					255
					0
					0
					1
				)
		)
		(temp0
			add:
				(AddLine
					gThePlane
					(param1 nsRight:)
					(param1 nsBottom:)
					(param1 nsLeft:)
					(param1 nsBottom:)
					5000
					255
					0
					0
					1
				)
		)
		(temp0
			add:
				(AddLine
					gThePlane
					(param1 nsLeft:)
					(param1 nsBottom:)
					(param1 nsLeft:)
					(param1 nsTop:)
					5000
					255
					0
					0
					1
				)
		)
	else
		(= temp8 ((param1 onMeCheck:) points:))
		(= temp6 (= temp1 (temp8 at: 0)))
		(= temp7 (= temp2 (temp8 at: 1)))
		(= temp5 0)
		(while (< (++ temp5) ((param1 onMeCheck:) size:))
			(= temp3 (temp8 at: (* temp5 2)))
			(= temp4 (temp8 at: (+ (* temp5 2) 1)))
			(temp0
				add: (AddLine gThePlane temp1 temp2 temp3 temp4 5000 255 0 0 1)
			)
			(= temp1 temp3)
			(= temp2 temp4)
		)
		(temp0 add: (AddLine gThePlane temp6 temp7 temp1 temp2 5000 255 0 0 1))
	)
)

(procedure (localproc_4 param1 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(DeleteLine (param1 at: temp0) gThePlane)
	)
	(param1 release:)
	(param1 dispose:)
)

(procedure (localproc_5 param1)
	(cond
		((== param1 1)
			(if (== (boxPlayer curFrame:) (boxPlayer maxFrame:))
				(boxPlayer curFrame: 0)
			else
				(boxPlayer curFrame: (+ (boxPlayer curFrame:) 1))
			)
		)
		((== (boxPlayer curFrame:) 0)
			(boxPlayer curFrame: (boxPlayer maxFrame:))
		)
		(else
			(boxPlayer curFrame: (- (boxPlayer curFrame:) 1))
		)
	)
	(Robot 1 (boxPlayer curFrame:) (boxPlayer x:) (boxPlayer y:)) ; DisplayFrame
	(PrintDebug {Frame : %d} (boxPlayer curFrame:))
	(establishHotSpots doit:)
)

(instance rm351 of LightRoom
	(properties)

	(method (init)
		(Lock rsAUDIO 200 1)
		(Lock rsAUDIO 202 1)
		(Lock rsAUDIO 211 1)
		(Lock rsAUDIO 212 1)
		(Lock rsAUDIO 213 1)
		(super init: &rest)
		(= scene 355)
		(proc400_1 7)
		(if (gIRandomMusic handle:)
			(gIRandomMusic client: changeSong fade:)
		else
			(changeSong cue:)
		)
		(gGame handsOn:)
		(if (== global246 1)
			(= global244 8)
		)
		(leavePuzzle init:)
		(cond
			((< global244 4)
				(= global244 0)
				(gCurRoom drawPic: 355)
				(rotateRight init:)
				(rotateLeft init:)
				(boxPlayer init: 4330 10 124 44)
			)
			((< global244 5)
				(= global244 4)
				(gCurRoom drawPic: 355)
				(rotateRight init:)
				(rotateLeft init:)
				(boxPlayer init: 4345 0 0 0)
				(boxPlayer maxFrame: 16)
				(= local3 0)
				(establishHotSpots doit:)
			)
			((< global244 6)
				(= global244 5)
				(gCurRoom drawPic: 5324)
				(rotateRight init:)
				(rotateLeft init:)
				(establishHotSpots doit:)
				(boxPlayer init: 6340 0 117 32)
			)
			((< global244 7)
				(= global244 6)
				(gCurRoom drawPic: 5324)
				(boxPlayer init: 6343 12 151 30)
				(inlayInitializer doit: 1)
			)
			((< global244 8)
				(= global244 7)
				(gCurRoom drawPic: 5324)
				(boxPlayer init: 6349 10 157 46)
				(if ((ScriptID 9 73) state:) ; invPuzzleAmulet
					(amuletPart init: cel: (amuletPart lastCel:))
				)
				(if ((ScriptID 9 42) state:) ; invJems
					(jems init: cel: (jems lastCel:))
				)
				(if (and ((ScriptID 9 42) state:) ((ScriptID 9 73) state:)) ; invJems, invPuzzleAmulet
					(amuletStud init: setCel: 0)
					(amuletStudFtr init:)
				else
					(amuletDropFtr init:)
				)
			)
			(else
				(gCurRoom drawPic: 5324)
				(boxPlayer init: 5330 13 160 34)
				(if (IsFlag 381)
					(if (not ((ScriptID 9 57) state:)) ; invCrystalBottle
						(cylinderATP init:)
						(cylinder init: cel: (cylinder lastCel:))
						(bottleFtr init:)
					else
						(cylinderATP loop: 0 setPri: 300 init:)
					)
				else
					(gGame handsOff:)
					(ringInitializer doit: 1)
				)
			)
		)
		(Load rsVIEW 4331)
	)

	(method (cue)
		(if local14
			(gMySoundFX stop:)
			(boxPlayer caller: 0)
			(establishHotSpots doit:)
			(local14 doVerb: 5)
			(= local14 0)
		)
	)

	(method (dispose)
		(Lock rsAUDIO 200 0)
		(Lock rsAUDIO 202 0)
		(Lock rsAUDIO 211 1)
		(Lock rsAUDIO 212 1)
		(Lock rsAUDIO 213 1)
		(if (gBackMusic handle:)
			(gBackMusic client: 0 dispose:)
		)
		(if (and gTimers (gTimers contains: songTimer))
			(songTimer client: 0 delete:)
		)
		(leavePuzzle dispose:)
		(rotateRight dispose:)
		(rotateLeft dispose:)
		(gMySoundFX stop:)
		(boxPlayer dispose:)
		(gGame normalizeCursor:)
		(super dispose: &rest)
	)
)

(class TilePiece of Actor
	(properties
		view 4348
		moveSpeed 2
		position -1
		correctPos -1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2 ignoreActors: 1 setLoop: (self loop:) 1)
		(switch position
			(0
				(self posn: 210 116)
			)
			(1
				(self posn: 235 116)
			)
			(2
				(self posn: 260 116)
			)
			(3
				(self posn: 285 116)
			)
			(4
				(self posn: 310 116)
			)
			(5
				(self posn: 210 140)
			)
			(6
				(self posn: 235 140)
			)
			(7
				(self posn: 260 140)
			)
			(8
				(self posn: 285 140)
			)
			(9
				(self posn: 310 140)
			)
			(10
				(self posn: 210 164)
			)
			(11
				(self posn: 235 164)
			)
			(12
				(self posn: 260 164)
			)
			(13
				(self posn: 285 164)
			)
			(14
				(self posn: 310 164)
			)
			(15
				(self posn: 210 188)
			)
			(16
				(self posn: 235 188)
			)
			(17
				(self posn: 260 188)
			)
			(18
				(self posn: 285 188)
			)
			(19
				(self posn: 310 188)
			)
			(20
				(self posn: 210 212)
			)
			(21
				(self posn: 235 212)
			)
			(22
				(self posn: 260 212)
			)
			(23
				(self posn: 285 212)
			)
			(24
				(self posn: 310 212)
			)
		)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(= local20 0)
		(checkPuzzle doit:)
	)

	(method (doVerb theVerb)
		(if local20
			(return)
		)
		(switch theVerb
			(5 ; Do
				(cond
					((and (< (self x:) 310) (== (+ (self position:) 1) local4))
						(= local4 (self position:))
						(self
							position: (+ (self position:) 1)
							setMotion: MoveTo (+ (self x:) 25) (self y:) self
						)
						(if (tileSound1 handle:)
							(tileSound2
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						else
							(tileSound1
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						)
					)
					((and (> (self x:) 210) (== (- (self position:) 1) local4))
						(= local4 (self position:))
						(self
							position: (- (self position:) 1)
							setMotion: MoveTo (- (self x:) 25) (self y:) self
						)
						(if (tileSound1 handle:)
							(tileSound2
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						else
							(tileSound1
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						)
					)
					((== (+ (self position:) 5) local4)
						(= local4 (self position:))
						(self
							position: (+ (self position:) 5)
							setMotion: MoveTo (self x:) (+ (self y:) 24) self
						)
						(if (tileSound1 handle:)
							(tileSound2
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						else
							(tileSound1
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						)
					)
					((== (- (self position:) 5) local4)
						(= local4 (self position:))
						(self
							position: (- (self position:) 5)
							setMotion: MoveTo (self x:) (- (self y:) 24) self
						)
						(if (tileSound1 handle:)
							(tileSound2
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						else
							(tileSound1
								number: (Random 211 213)
								setLoop: 0
								play:
							)
						)
					)
					(else 0)
				)
			)
		)
		(if (self mover:)
			(= local20 1)
		)
	)
)

(class PuzzleButton of Prop
	(properties
		active 0
		downOrOver 0
		canStayDownOrOver 0
		amISquare 0
	)

	(method (init)
		(self setPri: 600 setCel: 0 downOrOver: 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (handleEvent event)
		(if (not active)
			(return 0)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (not canStayDownOrOver) active)
				(self setCycle: Osc 1)
				(if amISquare
					(gMySoundFX number: 206 setLoop: 0 play:)
				)
			)
			(active
				(cond
					((not cel)
						(self downOrOver: 1 setCycle: End)
						(if amISquare
							(gMySoundFX number: 206 setLoop: 0 play:)
						else
							(= local9 (+ 211 (Random 0 2)))
							(gMySoundFX number: local9 setLoop: 0 play:)
						)
					)
					((== cel (self lastCel:))
						(self downOrOver: 0 setCycle: Beg)
						(if amISquare
							(gMySoundFX number: 206 setLoop: 0 play:)
						else
							(= local9 (+ 211 (Random 0 2)))
							(gMySoundFX number: local9 setLoop: 0 play:)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(class InlayPiece of Prop
	(properties
		type -1
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not local10))
			(cond
				((== cel 0)
					(self setCycle: End self)
					(if (tileSound1 handle:)
						(tileSound2 number: 219 setLoop: 0 play:)
					else
						(tileSound1 number: 219 setLoop: 0 play:)
					)
				)
				((== cel (self lastCel:))
					(if (tileSound1 handle:)
						(tileSound2 number: 219 setLoop: 0 play:)
					else
						(tileSound1 number: 219 setLoop: 0 play:)
					)
					(self setCycle: Beg self)
				)
			)
			(event claimed: 1)
			(return)
		)
		(return 0)
	)

	(method (verify param1)
		(return
			(or
				(and (== type param1) (== cel (self lastCel:)))
				(and (!= type param1) (== cel 0))
			)
		)
	)
)

(class RingProp of Prop
	(properties
		ticks 1
		tracking 0
		delay 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 302)
	)

	(method (cue)
		(switch (++ local15)
			(1
				(tileSound2 number: 223 loop: -1 play:)
			)
			(3
				(tileSound1 dispose:)
			)
			(4
				(tileSound2 dispose:)
				(gGame handsOn:)
			)
			(5
				(gGame handsOn:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((and tracking (not (& (event type:) evMOUSERELEASE)))
				(if (and (self timeElapsed:) (> (++ cel) (- (self lastCel:) 1)))
					(= cel 0)
				)
				(return 1)
			)
			(tracking
				(= tracking 0)
				(gMySoundFX stop:)
				(global206 delete: self)
				(self testForSolution:)
				(return 1)
			)
			((self onMe: event)
				(if cycler
					(self setCycle: 0)
				)
				(if (> (++ cel) (- (self lastCel:) 1))
					(= cel 0)
				)
				(gMySoundFX loop: -1 number: 223 play:)
				(global206 add: self)
				(= ticks (+ (GetTime) delay gTickOffset))
				(= tracking 1)
				(return)
			)
		)
	)

	(method (timeElapsed)
		(if (> (- gGameTime ticks) 0)
			(= ticks (+ (GetTime) delay gTickOffset))
			(return 1)
		)
		(return 0)
	)

	(method (testForSolution)
		(switch local12
			(0
				(if (ringList allTrue: 1003 0)
					(++ local12)
					(gMySoundFX number: 228 loop: 0 play:)
				)
			)
			(1
				(if (ringList allTrue: 1003 12)
					(++ local12)
					(gCurRoom setScript: openTopRingScr)
				)
			)
			(2
				(if (ringList allTrue: 1003 4)
					(++ local12)
					(gCurRoom setScript: openBottomRingScr)
				)
			)
			(3
				(if
					(and
						(ring1 symbolMatch: 12)
						(ring2 symbolMatch: 4)
						(ring3 symbolMatch: 0)
						(ring4 symbolMatch: 8)
					)
					(++ local12)
					(gCurRoom setScript: openCylinderScr)
				)
			)
		)
	)

	(method (symbolMatch param1)
		(return (== param1 cel))
	)
)

(instance openFishPanelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(stud2Ftr dispose:)
				(latch2Ftr dispose:)
				(stud2 init: setCycle: End self)
			)
			(1
				(gMySoundFX loop: 0 number: 216 play: self)
			)
			(2
				(stud2 dispose:)
				(Load rsAUDIO 215)
				(boxPlayer dispose:)
				(boxPlayer caller: self init: 6343 0 150 30 start: 1 12)
				(gMySoundFX loop: 0 number: 202 play:)
			)
			(3
				(rotateLeft dispose:)
				(rotateRight dispose:)
				(= cycles 2)
			)
			(4
				(++ global244)
				(inlayInitializer doit: 1)
				(gGame handsOn:)
			)
		)
	)
)

(instance turnLatch2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(latch2 init: setCycle: (if local13 Beg else End) self)
				(gMySoundFX number: 200 setLoop: 0 play:)
			)
			(1
				(latch2 dispose:)
				(boxPlayer dispose:)
				(if (= local13 (not local13))
					(boxPlayer init: 6341 0 101 37)
					(boxPlayer maxFrame: 20)
				else
					(boxPlayer init: 6340 4 117 32)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance latchAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(latchProp init: setCycle: End self)
				(gMySoundFX number: 200 setLoop: 0 play:)
			)
			(1
				(latch dispose:)
				(latchProp dispose:)
				(boxPlayer dispose:)
				(boxPlayer caller: self init: 4332 0 0 52)
				(boxPlayer start: 1 12)
				(= cycles 25)
			)
			(2
				(gMySoundFX number: 202 setLoop: 0 play:)
			)
			(3
				(Lock rsAUDIO 200 0)
				(Lock rsAUDIO 202 0)
				(= global244 1)
				(establishHotSpots doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance redButtonAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 207)
				(redButton init: setCycle: End self)
			)
			(1
				(gMySoundFX number: 207 setLoop: 0 play:)
				(redButton setCycle: Beg self)
			)
			(2
				(redButton dispose:)
				(cond
					((not local6)
						(= local5 1)
						(sideStudFeature init:)
						(self cue:)
					)
					((IsFlag 77)
						(self setScript: closeKeyPanelAni self)
					)
					(local2
						(self setScript: closeDrawerAni self)
					)
					(else
						(self setScript: openDrawerAni self)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sideStudAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 216)
				(sideStud init: setCycle: End self)
			)
			(1
				(gMySoundFX loop: 0 number: 216 play:)
				(sideStud setCycle: Beg self)
			)
			(2
				(= local6 1)
				(sideStud dispose:)
				(sideStudFeature dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openDrawerAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 208)
				(drawer init: setCycle: End self)
				(gMySoundFX loop: 0 number: 208 play:)
			)
			(1
				(= local2 1)
				(keyFeature init:)
				(drawer dispose:)
				(boxPlayer dispose:)
				(boxPlayer init: 4341 0 0 0)
				(boxPlayer maxFrame: 20)
				(self dispose:)
			)
		)
	)
)

(instance closeDrawerAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 208)
				(boxPlayer dispose:)
				(boxPlayer init: 4338 0 0 0)
				(gMySoundFX loop: 0 number: 208 play:)
				(drawer init:)
				(drawer setCycle: CT 1 -1 self)
			)
			(1
				(= local2 0)
				(keyFeature dispose:)
				(drawer dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeKeyPanelAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(redButtonFeature dispose:)
				(boxPlayer dispose:)
				(KillRobot 4344 139 47)
			)
			(1
				(KillRobot 4333 127 37)
			)
			(2
				(boxPlayer dispose:)
				(boxPlayer init: 4345 0 0 0 caller: 0)
				(boxPlayer maxFrame: 16)
				(= global244 4)
				(keyFeature dispose:)
				(gGame handsOn:)
				(self dispose:)
				(if register
					(gCurRoom newRoom: 350)
				)
			)
		)
	)
)

(instance closeBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slider9Level8 setCycle: Beg)
				(slider8Level7 setCycle: Beg)
				(slider7Level5 setCycle: Beg)
				(slider6Level4 setCycle: Beg)
				(slider5Level4 setCycle: Beg)
				(slider4Level3 setCycle: Beg)
				(slider3Level2 setCycle: Beg)
				(slider2Level2 setCycle: Beg)
				(slider1Level1 setCycle: Beg)
				(square8Level8 setCycle: Beg)
				(square7Level7 setCycle: Beg)
				(square6Level7 setCycle: Beg)
				(square5Level5 setCycle: Beg)
				(square4Level4 setCycle: Beg)
				(square3Level2 setCycle: Beg)
				(square2Level2 setCycle: Beg)
				(square1Level1 setCycle: Beg self)
			)
			(1
				(redStud dispose:)
				(slider9Level8 dispose:)
				(slider8Level7 dispose:)
				(slider7Level5 dispose:)
				(slider6Level4 dispose:)
				(slider5Level4 dispose:)
				(slider4Level3 dispose:)
				(slider3Level2 dispose:)
				(slider2Level2 dispose:)
				(slider1Level1 dispose:)
				(square8Level8 dispose:)
				(square7Level7 dispose:)
				(square6Level7 dispose:)
				(square5Level5 dispose:)
				(square4Level4 dispose:)
				(square3Level2 dispose:)
				(square2Level2 dispose:)
				(square1Level1 dispose:)
				(boxPlayer
					caller: self
					end: (boxPlayer maxFrame:)
					startFrame: (boxPlayer maxFrame:)
					cycleTo: 0 2 12
				)
				(= cycles 25)
			)
			(2
				(gMySoundFX number: 202 setLoop: 0 play:)
			)
			(3
				(latchProp
					init:
					setCel: (latchProp lastCel:)
					setCycle: Beg self
				)
				(gMySoundFX number: 201 setLoop: 0 play:)
			)
			(4
				(latchProp dispose:)
				(boxPlayer dispose:)
				(boxPlayer init: 4330 0 124 44)
				(if (== caller pushRedStud)
					(self dispose:)
				else
					(boxPlayer start: register 12 1)
					(= global244 0)
					(= local0 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance pushRedStud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(redStud setCycle: End self)
			)
			(1
				(gMySoundFX number: 130 setLoop: 0 play:)
				(redStud setCycle: Beg self)
			)
			(2
				(self setScript: closeBox self)
			)
			(3
				(backDoor init: setCycle: End self)
				(gMySoundFX number: 202 setLoop: 0 play:)
			)
			(4
				(backDoor dispose:)
				(boxPlayer dispose:)
				(boxPlayer init: 4335 0 0 22)
				(= global244 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance squarePegAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(squarePegFeature dispose:)
				(squarePeg init: setCycle: End self)
				(gMySoundFX number: 206 setLoop: 0 play:)
			)
			(1
				(squarePeg dispose:)
				(boxPlayer dispose:)
				(Load rsAUDIO 20902)
				(backGround init:)
				(tilePuzzleManager doit: 1)
				(if local8
					(boxPlayer init: 4347 9 0 0 caller: self start: 1 12)
					(gMySoundFX loop: 0 number: 20902 play:)
				else
					(boxPlayer init: 4347 0 0 0 caller: self cycleTo: 9 1 12)
					(gMySoundFX number: 20001 setLoop: -1 play:)
				)
			)
			(2
				(if (not local8)
					(gMySoundFX stop:)
					(gMySoundFX loop: 0 number: 20902 play:)
					(boxPlayer caller: self start: 1 12)
				else
					(self cue:)
				)
			)
			(3
				(if (>= (++ global223) 5)
					(solveIt init:)
				)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeBirdPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(boxPlayer
					caller: self
					end: (boxPlayer maxFrame:)
					startFrame: (boxPlayer maxFrame:)
					cycleTo: 5 2 12
				)
			)
			(1
				(solveIt dispose:)
				(backGround dispose:)
				(boxPlayer dispose:)
				(boxPlayer init: 4345 15 0 0 caller: 0)
				(boxPlayer maxFrame: 16)
				(= local3 0)
				(= global244 4)
				(squarePegFeature init:)
				(gGame handsOn:)
				(self dispose:)
				(if register
					(rotateCode doit: 0 register)
					(= register 0)
				)
			)
		)
	)
)

(instance openPanel1Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(fishPanel1 init: setCycle: End self)
				(gMySoundFX loop: 0 number: 217 play: self)
			)
			(1 0)
			(2
				(fishPanel1Ftr dispose:)
				(= local10 1)
				(inlaySwitch init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance closePanel1Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(inlaySwitch dispose:)
				(fishPanel1 loop: 1 cel: 0 setCycle: End self)
				(gMySoundFX loop: 0 number: 218 play: self)
			)
			(1 0)
			(2
				(inlayPiece13 setCycle: Beg self)
				(inlayPiece14 setCycle: Beg self)
				(inlayPiece15 setCycle: Beg self)
				(inlayPiece16 setCycle: Beg self)
			)
			(3 0)
			(4 0)
			(5 0)
			(6
				(fishPanel1 loop: 2 cel: 0 setCycle: End self)
				(gMySoundFX loop: 0 number: 217 play: self)
			)
			(7 0)
			(8
				(fishPanel1 dispose:)
				(= local11 1)
				(= local10 0)
				(gGame handsOn:)
			)
		)
	)
)

(instance openPanel2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(fishPanel2Ftr dispose:)
				(fishPanel2 init: setCycle: End self)
				(gMySoundFX loop: 0 number: 225 play: self)
			)
			(1 0)
			(2
				(= local10 1)
				(keyHoleFtr init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance closePanel2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gInventory deleteItem: (ScriptID 9 16)) ; invPuzzleBoxKey
				(= cycles 1)
			)
			(1
				(keyHoleFtr dispose:)
				(fishPanel2 loop: 1 cel: 0 setCycle: End self)
				(gMySoundFX loop: 0 number: 226 play: self)
			)
			(2 0)
			(3
				(gMySoundFX loop: 0 number: 217 play: self)
				(fishPanel2 loop: 2 cel: 0 setCycle: End self)
			)
			(4 0)
			(5
				(fishPanel2 dispose:)
				(inlayPiece17 setCycle: Beg self)
				(inlayPiece18 setCycle: Beg self)
				(inlayPiece19 setCycle: Beg self)
				(inlayPiece20 setCycle: Beg self)
			)
			(6 0)
			(7 0)
			(8 0)
			(9
				(inlayInitializer doit: 0)
				(boxPlayer dispose:)
				(Load rsAUDIO 217)
				(boxPlayer caller: self init: 6349 0 157 46 start: 1 12)
				(gMySoundFX number: 215 loop: 0 play:)
			)
			(10
				(amuletDropFtr init:)
				(= global244 7)
				(gGame handsOn:)
			)
		)
	)
)

(instance pushAmuletStudScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 216)
				(amuletStudFtr dispose:)
				(amuletStud setCycle: CT 4 1 self)
			)
			(1
				(gMySoundFX loop: 0 number: 216 play:)
				(amuletStud setCycle: End self)
			)
			(2
				(amuletPart dispose:)
				(jems dispose:)
				(amuletStud dispose:)
				(boxPlayer dispose:)
				(Load rsAUDIO 215)
				(boxPlayer caller: self init: 5330 0 160 34 start: 1 12)
				(gMySoundFX loop: 0 number: 215 play:)
			)
			(3
				(ringInitializer doit: 1)
				(= global244 8)
				(self dispose:)
			)
		)
	)
)

(instance placeAmuletPartScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gInventory deleteItem: ((ScriptID 9 73) state: 1 yourself:)) ; invPuzzleAmulet
				(= cycles 1)
			)
			(1
				(gMySoundFX loop: 0 number: 221 play:)
				(amuletPart init: setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance placeJemScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(amuletDropFtr dispose:)
				(gInventory deleteItem: ((ScriptID 9 42) state: 1 yourself:)) ; invJems
				(= cycles 1)
			)
			(1
				(jems init: setCycle: End self)
				(amuletStudFtr init:)
				(gMySoundFX loop: 0 number: 222 play:)
			)
			(2
				(amuletStud
					init:
					setCel: (amuletStud lastCel:)
					setCycle: Beg self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTopRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cylinderTop setCycle: End self)
				(gMySoundFX loop: 0 number: 227 play: self)
			)
			(1 0)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openBottomRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cylinderBottom setCycle: End self)
				(gMySoundFX loop: 0 number: 227 play: self)
			)
			(1 0)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openCylinderScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ringList dispose:)
				(Load rsAUDIO 224)
				(cylinder init: setCycle: End self)
				(gMySoundFX loop: 0 number: 224 play: self)
			)
			(1 0)
			(2
				(gBackMusic pause: 1)
				(gMySoundFX loop: 0 number: 20002 play: self)
			)
			(3
				(gBackMusic pause: 0)
				(SetFlag 381)
				(bottleFtr init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance solveItScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(solveIt cel: 1)
				(= ticks 20)
			)
			(1
				(solveIt cel: 0)
				(= ticks 10)
			)
			(2
				(solveIt dispose:)
				(tilePuzzleManager doit: 0)
				(tilePuzzleManager doit: 1 0)
				(= ticks 120)
			)
			(3
				(gCurRoom setScript: finishTilePuzzleScr)
			)
		)
	)
)

(instance finishTilePuzzleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(solveIt dispose:)
				(silverSheet init: setCycle: End self)
				(gMySoundFX loop: 0 number: 220 play:)
			)
			(1
				(= ticks 120)
			)
			(2
				(boxPlayer dispose:)
				(backGround dispose:)
				(tilePuzzleManager doit: 0)
				(silverSheet dispose:)
				(gCurRoom picture: 5339)
				(gCurRoom drawPic: (gCurRoom picture:))
				(gGame normalizeCursor:)
				(FrameOut)
				(while (not (& ((gUser curEvent:) type:) evMOUSEBUTTON))
					(= gGameTime (+ gTickOffset (GetTime)))
					((gUser curEvent:) new:)
				)
				(gGame setCursor: gWaitCursor 1)
				(= cycles 1)
			)
			(3
				(gTheCursor show:)
				(gCurRoom picture: 5324)
				(gCurRoom drawPic: (gCurRoom picture:))
				(boxPlayer init: 5325 0 115 0)
				(silverSheet init:)
				(= cycles 1)
			)
			(4
				(silverSheet setCycle: End self)
				(gMySoundFX loop: 0 number: 220 play:)
			)
			(5
				(Load rsAUDIO 214)
				(silverSheet dispose:)
				(boxPlayer caller: self start: 1 12)
				(gMySoundFX loop: 0 number: 214 play:)
			)
			(6
				(boxPlayer dispose:)
				(boxPlayer init: 6340 0 117 32)
				(++ global244)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cylinder of Prop
	(properties
		x 225
		y 431
		view 5337
		z 300
	)
)

(instance stud2 of Prop
	(properties
		x 164
		y 279
		view 6342
	)
)

(instance latch2 of Prop
	(properties
		x 273
		y 232
		view 6350
	)

	(method (init)
		(= cel
			(if local13
				(self lastCel:)
			)
		)
		(super init: &rest)
	)
)

(instance silverSheet of Prop
	(properties
		x 253
		y 259
	)

	(method (init)
		(if (== (gCurRoom picture:) 5324)
			(= view 5340)
		else
			(= view 5323)
		)
		(= cel 0)
		(super init: &rest)
	)
)

(instance latchProp of Prop
	(properties
		x 221
		y 161
		view 4331
	)

	(method (init)
		(self setCel: 0 setPri: 5500)
		(super init: &rest)
	)
)

(instance redStud of Prop
	(properties
		x 225
		y 156
		view 5320
	)

	(method (init)
		(super init: &rest)
		(self
			setPri:
				(Max
					(+ (slider5Level4 priority:) 1)
					(+ (slider2Level2 priority:) 1)
				)
			setCel: 0
		)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: pushRedStud)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: (event x:) (event y:)))
			(event claimed: 1)
			(self doVerb: (event message:))
		)
		(super handleEvent: event &rest)
	)
)

(instance backDoor of Prop
	(properties
		x 188
		y 25
		view 4334
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)
)

(instance redButton of Prop
	(properties
		x 314
		y 753
		view 4337
		z 600
	)
)

(instance sideStud of Prop
	(properties
		x 319
		y 165
		view 4336
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)
)

(instance drawer of Prop
	(properties
		x 272
		y 206
		view 4340
	)

	(method (init)
		(self
			setPri: 601
			setLoop: 0
			setCel:
				(if local2
					(self lastCel:)
				else
					1
				)
		)
		(super init: &rest)
	)
)

(instance squarePeg of Prop
	(properties
		x 283
		y 243
		view 4346
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)
)

(instance fishPanel1 of Prop
	(properties
		x 229
		y 534
		view 6345
		z 300
	)
)

(instance fishPanel2 of Prop
	(properties
		x 262
		y 559
		view 6347
		z 300
	)
)

(instance amuletPart of Prop
	(properties
		x 224
		y 408
		view 5328
		z 300
	)
)

(instance jems of Prop
	(properties
		x 219
		y 463
		view 5329
		z 300
	)
)

(instance amuletStud of Prop
	(properties
		x 264
		y 345
		view 5327
		z 300
	)
)

(instance cylinderTop of Prop
	(properties
		x 222
		y 97
		view 5335
	)

	(method (init)
		(super init: &rest)
		(self setPri: 303)
	)
)

(instance cylinderBottom of Prop
	(properties
		x 224
		y 178
		view 5336
	)

	(method (init)
		(super init: &rest)
		(self setPri: 301)
	)
)

(instance cylinderATP of Prop
	(properties
		x 215
		y 103
		loop 1
		view 5338
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)
)

(instance solveIt of Prop
	(properties
		x 269
		y 294
		loop 1
		view 5341
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1000)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: solveItScr)
		)
	)
)

(instance slider9Level8 of PuzzleButton
	(properties
		x 242
		y 243
		view 5306
		canStayDownOrOver 1
	)

	(method (doVerb theVerb)
		(if
			(and
				active
				(OneOf cel 0 (self lastCel:))
				(not (slider8Level7 cycler:))
			)
			(self setPri: (+ (slider8Level7 priority:) 1))
			(if downOrOver
				(slider8Level7 active: 0)
			else
				(slider8Level7 active: 1)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance slider8Level7 of PuzzleButton
	(properties
		x 243
		y 202
		view 5307
		canStayDownOrOver 1
	)

	(method (doVerb theVerb)
		(if
			(and
				active
				(not cycler)
				(not (slider9Level8 cycler:))
				(not (slider7Level5 cycler:))
			)
			(self
				setPri:
					(Max
						(+ (slider9Level8 priority:) 1)
						(+ (slider7Level5 priority:) 1)
					)
			)
			(if downOrOver
				(slider9Level8 active: 1)
				(slider7Level5 active: 0)
			else
				(slider9Level8 active: 0)
				(slider7Level5 active: 1)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance slider7Level5 of PuzzleButton
	(properties
		x 217
		y 179
		view 5308
		canStayDownOrOver 1
	)

	(method (doVerb theVerb)
		(if
			(and
				active
				(not cycler)
				(not (slider5Level4 cycler:))
				(not (slider8Level7 cycler:))
			)
			(self
				setPri:
					(Max
						(+ (slider8Level7 priority:) 1)
						(+ (slider5Level4 priority:) 1)
					)
			)
			(if downOrOver
				(slider8Level7 active: 1)
				(slider5Level4 active: 0)
			else
				(slider8Level7 active: 0)
				(slider5Level4 active: 1)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance slider6Level4 of PuzzleButton
	(properties
		x 245
		y 158
		view 5316
		canStayDownOrOver 1
	)

	(method (doVerb)
		(if
			(and
				active
				(not cycler)
				(not (slider3Level2 cycler:))
				(<= (slider5Level4 cel:) 5)
			)
			(self
				setPri:
					(Max
						(+ (slider3Level2 priority:) 1)
						(+ (slider5Level4 priority:) 1)
						(+ (slider7Level5 priority:) 1)
					)
			)
			(if active
				(cond
					((not cel)
						(self downOrOver: 1 setCycle: End)
						(slider3Level2 active: 0)
						(= local7 0)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
					)
					((== cel (self lastCel:))
						(self downOrOver: 0 setCycle: Beg)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
						(if (not (slider4Level3 downOrOver:))
							(slider3Level2 active: 1)
						)
						(if (not (slider3Level2 downOrOver:))
							(= local7 1)
						)
					)
					(else 0)
				)
			)
		)
	)
)

(instance slider5Level4 of PuzzleButton
	(properties
		x 195
		y 133
		view 5309
		canStayDownOrOver 1
	)

	(method (cue)
		(cond
			((== cel 5)
				(gMySoundFX number: local9 setLoop: 0 play: self)
				(if (== local17 1)
					(self setCycle: End self)
				else
					(self setCycle: Beg self)
				)
			)
			((== local17 1)
				(redStud init:)
			)
		)
	)

	(method (doVerb)
		(if (and active (not cycler) (not (slider7Level5 cycler:)))
			(self
				setPri:
					(Max
						(+ (slider7Level5 priority:) 1)
						(+ (slider6Level4 priority:) 1)
						(+ (slider3Level2 priority:) 1)
						(+ (slider2Level2 priority:) 1)
					)
			)
			(cond
				(
					(and
						(!= (slider3Level2 cel:) (slider3Level2 lastCel:))
						(<= (self priority:) (slider3Level2 priority:))
					)
					(self setPri: (+ (slider3Level2 priority:) 1))
				)
				(
					(and
						(slider3Level2 cel:)
						(<= (self priority:) (slider3Level2 priority:))
					)
					(slider3Level2 setPri: (+ (self priority:) 1))
				)
			)
			(if active
				(cond
					((not cel)
						(self downOrOver: 1)
						(if local7
							(= local17 1)
							(self setCycle: CT 5 1 self)
							(slider6Level4 active: 0)
							(slider4Level3 active: 0)
							(slider3Level2 active: 0)
							(= local9 (+ 211 (Random 0 2)))
							(gMySoundFX number: local9 setLoop: 0 play:)
						else
							(redStud dispose:)
							(self setCycle: CT 5 1)
							(= local9 (+ 211 (Random 0 2)))
							(gMySoundFX number: local9 setLoop: 0 play:)
						)
						(slider7Level5 active: 0)
						(slider2Level2 active: 1)
					)
					((== cel (self lastCel:))
						(= local17 -1)
						(self downOrOver: 0 setCycle: CT 5 -1 self)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
						(redStud dispose:)
						(slider7Level5 active: 1)
						(if (not (slider3Level2 downOrOver:))
							(slider6Level4 active: 1)
						)
						(if (not (slider3Level2 cel:))
							(slider4Level3 active: 1)
						)
						(slider3Level2 active: 1)
						(slider2Level2 active: 0)
					)
					((== cel 5)
						(self downOrOver: 0 setCycle: Beg)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
						(redStud dispose:)
						(slider7Level5 active: 1)
						(if (not (slider3Level2 downOrOver:))
							(slider6Level4 active: 1)
						)
						(if (not (slider3Level2 cel:))
							(slider4Level3 active: 1)
						)
						(slider2Level2 active: 0)
					)
					(else 0)
				)
			)
		)
	)
)

(instance slider4Level3 of PuzzleButton
	(properties
		x 216
		y 134
		view 5312
		canStayDownOrOver 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 599)
	)

	(method (doVerb)
		(if (and active (not cycler) (not (slider3Level2 cycler:)))
			(self setPri: (+ (slider3Level2 priority:) 1))
			(if active
				(cond
					((not cel)
						(self downOrOver: 1 setCycle: End)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
						(slider3Level2 active: 0)
					)
					((== cel (self lastCel:))
						(self downOrOver: 0 setCycle: Beg)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
						(if (not (slider6Level4 downOrOver:))
							(slider3Level2 active: 1)
							(if (not (slider3Level2 downOrOver:))
							)
						)
					)
					(else 0)
				)
			)
		)
	)
)

(instance slider3Level2 of PuzzleButton
	(properties
		x 243
		y 86
		view 5311
		canStayDownOrOver 1
	)

	(method (init)
		(super init: &rest)
		(self setCel: 5)
		(= local7 1)
	)

	(method (doVerb)
		(if
			(and
				active
				(not cycler)
				(not (slider1Level1 cycler:))
				(<= (slider5Level4 cel:) 5)
			)
			(self
				setPri:
					(Max
						(+ (slider1Level1 priority:) 1)
						(+ (slider4Level3 priority:) 1)
						(+ (slider5Level4 priority:) 1)
						(+ (slider6Level4 priority:) 1)
					)
			)
			(if active
				(cond
					((not cel)
						(self downOrOver: 1 setCycle: End)
						(slider6Level4 active: 0)
						(slider4Level3 active: 0)
						(slider1Level1 active: 1)
						(= local7 0)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
					)
					((== cel (self lastCel:))
						(self downOrOver: 0 setCycle: Beg)
						(slider6Level4 active: 1)
						(slider4Level3 active: 1)
						(slider1Level1 active: 0)
						(if (not (slider6Level4 downOrOver:))
							(= local7 1)
						)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
					)
					((== cel 5)
						(self downOrOver: 0 setCycle: Beg)
						(slider6Level4 active: 1)
						(slider4Level3 active: 1)
						(slider1Level1 active: 0)
						(= local7 1)
						(= local9 (+ 211 (Random 0 2)))
						(gMySoundFX number: local9 setLoop: 0 play:)
					)
					(else 0)
				)
			)
		)
	)
)

(instance slider2Level2 of PuzzleButton
	(properties
		x 195
		y 108
		view 5313
		canStayDownOrOver 1
	)

	(method (doVerb theVerb)
		(if (and active (not cycler) (not (slider5Level4 cycler:)))
			(self setPri: (+ (slider5Level4 priority:) 1))
			(if downOrOver
				(slider5Level4 active: 1)
			else
				(slider5Level4 active: 0)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance slider1Level1 of PuzzleButton
	(properties
		x 194
		y 110
		view 5310
		canStayDownOrOver 1
	)

	(method (doVerb theVerb)
		(if
			(and
				active
				(not cycler)
				(not (slider2Level2 cycler:))
				(not (slider3Level2 cycler:))
			)
			(self
				setPri:
					(Max
						(+ (slider2Level2 priority:) 1)
						(+ (slider3Level2 priority:) 1)
					)
			)
			(if downOrOver
				(if (not (slider6Level4 downOrOver:))
					(slider3Level2 active: 1)
				)
			else
				(slider3Level2 active: 0)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance square8Level8 of PuzzleButton
	(properties
		x 286
		y 247
		view 5301
		amISquare 1
	)

	(method (cue)
		(self active: 0)
		(square7Level7 active: 0)
		(square6Level7 active: 0)
		(square5Level5 active: 0)
		(square4Level4 active: 0)
		(square3Level2 active: 0)
		(square2Level2 active: 0)
		(square1Level1 active: 0)
		(slider9Level8 init: active: 1)
		(slider8Level7 init: active: 0)
		(slider7Level5 init: active: 0)
		(slider6Level4 init: active: 1)
		(slider5Level4 init: active: 0)
		(slider4Level3 init: active: 0)
		(slider3Level2 init: active: 1)
		(slider2Level2 init: active: 0)
		(slider1Level1 init: active: 1)
		(gMySoundFX number: 206 setLoop: 0 play:)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and canStayDownOrOver active)
					(gGame handsOff:)
					(self downOrOver: 1 setCycle: End self)
					(gMySoundFX number: 206 setLoop: 0 play:)
				else
					(super doVerb: theVerb &rest)
					(if active
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square7Level7 of PuzzleButton
	(properties
		x 265
		y 223
		view 5317
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square6Level7 downOrOver:))
						(square8Level8 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square6Level7 of PuzzleButton
	(properties
		x 219
		y 218
		view 5302
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square5Level5 downOrOver:))
						(square7Level7 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square5Level5 of PuzzleButton
	(properties
		x 195
		y 176
		view 5303
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square4Level4 downOrOver:))
						(square6Level7 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square4Level4 of PuzzleButton
	(properties
		x 243
		y 158
		view 5304
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square3Level2 downOrOver:))
						(square5Level5 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square3Level2 of PuzzleButton
	(properties
		x 266
		y 112
		view 5319
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square2Level2 downOrOver:))
						(square4Level4 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square2Level2 of PuzzleButton
	(properties
		x 218
		y 109
		view 5318
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (and (not downOrOver) (square1Level1 downOrOver:))
						(square3Level2 canStayDownOrOver: 1)
						(super doVerb: theVerb &rest)
					else
						(super doVerb: theVerb &rest)
						(self canStayDownOrOver: 0)
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square1Level1 setCycle: Beg downOrOver: 0)
					)
				)
			)
		)
	)
)

(instance square1Level1 of PuzzleButton
	(properties
		x 242
		y 86
		view 5305
		amISquare 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and active (not cycler))
					(if (not downOrOver)
						(square2Level2 canStayDownOrOver: 1)
					else
						(square8Level8
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square7Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square6Level7
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square5Level5
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square4Level4
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square3Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
						(square2Level2
							setCycle: Beg
							downOrOver: 0
							canStayDownOrOver: 0
						)
					)
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance tilePiece0 of TilePiece
	(properties
		correctPos 0
	)
)

(instance tilePiece1 of TilePiece
	(properties
		loop 1
		correctPos 1
	)
)

(instance tilePiece2 of TilePiece
	(properties
		loop 2
		correctPos 2
	)
)

(instance tilePiece3 of TilePiece
	(properties
		loop 3
		correctPos 3
	)
)

(instance tilePiece4 of TilePiece
	(properties
		loop 4
		correctPos 4
	)
)

(instance tilePiece5 of TilePiece
	(properties
		loop 5
		correctPos 5
	)
)

(instance tilePiece6 of TilePiece
	(properties
		loop 6
		correctPos 6
	)
)

(instance tilePiece7 of TilePiece
	(properties
		loop 7
		correctPos 7
	)
)

(instance tilePiece8 of TilePiece
	(properties
		loop 8
		correctPos 8
	)
)

(instance tilePiece9 of TilePiece
	(properties
		loop 9
		correctPos 9
	)
)

(instance tilePiece10 of TilePiece
	(properties
		loop 10
		correctPos 10
	)
)

(instance tilePiece11 of TilePiece
	(properties
		loop 11
		correctPos 11
	)
)

(instance tilePiece12 of TilePiece
	(properties
		loop 12
		correctPos 12
	)
)

(instance tilePiece13 of TilePiece
	(properties
		loop 13
		correctPos 13
	)
)

(instance tilePiece14 of TilePiece
	(properties
		loop 14
		correctPos 14
	)
)

(instance tilePiece15 of TilePiece
	(properties
		loop 15
		correctPos 15
	)
)

(instance tilePiece16 of TilePiece
	(properties
		loop 16
		correctPos 16
	)
)

(instance tilePiece17 of TilePiece
	(properties
		loop 17
		correctPos 17
	)
)

(instance tilePiece18 of TilePiece
	(properties
		loop 18
		correctPos 18
	)
)

(instance tilePiece19 of TilePiece
	(properties
		loop 19
		correctPos 19
	)
)

(instance tilePiece20 of TilePiece
	(properties
		loop 20
		correctPos 20
	)
)

(instance tilePiece21 of TilePiece
	(properties
		loop 21
		correctPos 21
	)
)

(instance tilePiece22 of TilePiece
	(properties
		loop 22
		correctPos 22
	)
)

(instance tilePiece23 of TilePiece
	(properties
		loop 23
		correctPos 23
	)
)

(instance ring1 of RingProp
	(properties
		x 225
		y 140
		view 5331
	)
)

(instance ring2 of RingProp
	(properties
		x 229
		y 151
		view 5332
	)
)

(instance ring3 of RingProp
	(properties
		x 229
		y 160
		view 5333
	)
)

(instance ring4 of RingProp
	(properties
		x 225
		y 168
		view 5334
	)
)

(instance inlayPiece0 of InlayPiece
	(properties
		x 200
		y 134
		view 6344
	)
)

(instance inlayPiece1 of InlayPiece
	(properties
		x 303
		y 125
		loop 1
		view 6344
	)
)

(instance inlayPiece2 of InlayPiece
	(properties
		x 233
		y 151
		loop 2
		view 6344
	)
)

(instance inlayPiece3 of InlayPiece
	(properties
		x 233
		y 199
		loop 3
		view 6344
	)
)

(instance inlayPiece4 of InlayPiece
	(properties
		x 305
		y 168
		loop 4
		view 6344
	)
)

(instance inlayPiece5 of InlayPiece
	(properties
		x 330
		y 204
		loop 5
		view 6344
	)
)

(instance inlayPiece6 of InlayPiece
	(properties
		x 202
		y 262
		loop 6
		view 6344
	)
)

(instance inlayPiece7 of InlayPiece
	(properties
		x 300
		y 255
		loop 7
		view 6344
	)
)

(instance inlayPiece8 of InlayPiece
	(properties
		x 222
		y 132
		loop 8
		view 6344
	)
)

(instance inlayPiece9 of InlayPiece
	(properties
		x 265
		y 115
		loop 9
		view 6344
	)
)

(instance inlayPiece10 of InlayPiece
	(properties
		x 265
		y 195
		loop 10
		view 6344
	)
)

(instance inlayPiece11 of InlayPiece
	(properties
		x 202
		y 225
		loop 11
		view 6344
	)
)

(instance inlayPiece12 of InlayPiece
	(properties
		x 312
		y 255
		loop 12
		view 6344
	)
)

(instance inlayPiece13 of InlayPiece
	(properties
		x 200
		y 153
		loop 13
		view 6344
		type 1
	)
)

(instance inlayPiece14 of InlayPiece
	(properties
		x 265
		y 169
		loop 14
		view 6344
		type 1
	)
)

(instance inlayPiece15 of InlayPiece
	(properties
		x 304
		y 205
		loop 15
		view 6344
		type 1
	)
)

(instance inlayPiece16 of InlayPiece
	(properties
		x 220
		y 260
		loop 16
		view 6344
		type 1
	)
)

(instance inlayPiece17 of InlayPiece
	(properties
		x 201
		y 200
		loop 17
		view 6344
		type 2
	)
)

(instance inlayPiece18 of InlayPiece
	(properties
		x 331
		y 167
		loop 18
		view 6344
		type 2
	)
)

(instance inlayPiece19 of InlayPiece
	(properties
		x 264
		y 258
		loop 19
		view 6344
		type 2
	)
)

(instance inlayPiece20 of InlayPiece
	(properties
		x 337
		y 231
		loop 20
		view 6344
		type 2
	)
)

(instance backGround of View
	(properties
		x 192
		y 100
		view 5321
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (handleEvent))
)

(instance keyFeature of Feature
	(properties
		y 1000
	)

	(method (init)
		(self
			setPolygon:
				(switch (boxPlayer curFrame:)
					(0
						((Polygon new:)
							type: PTotalAccess
							init: 332 259 320 246 360 233 372 244
							yourself:
						)
					)
					(1
						((Polygon new:)
							type: PTotalAccess
							init: 378 246 324 256 330 247 368 238
							yourself:
						)
					)
					(2
						((Polygon new:)
							type: PTotalAccess
							init: 350 259 308 259 310 255 345 251
							yourself:
						)
					)
					(3
						((Polygon new:)
							type: PTotalAccess
							init: 311 266 267 260 283 256 311 257
							yourself:
						)
					)
					(4
						((Polygon new:)
							type: PTotalAccess
							init: 260 267 217 256 246 252 269 257
							yourself:
						)
					)
					(5
						((Polygon new:)
							type: PTotalAccess
							init: 215 265 195 255 209 244 234 254
							yourself:
						)
					)
					(6
						((Polygon new:)
							type: PTotalAccess
							init: 176 252 173 242 197 236 202 247
							yourself:
						)
					)
					(19
						((Polygon new:)
							type: PTotalAccess
							init: 369 214 366 241 342 235 346 211
							yourself:
						)
					)
					(20
						((Polygon new:)
							type: PTotalAccess
							init: 373 231 363 252 336 245 344 221
							yourself:
						)
					)
				)
		)
		(if onMeCheck
			(super init: &rest)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (localproc_0 self 0)) ; Do
			(gInventory addItem: (ScriptID 9 16)) ; invPuzzleBoxKey
			(SetFlag 77)
			(boxPlayer dispose:)
			(boxPlayer init: 4342 20 0 23)
			(gMySoundFX number: 20800 loop: 0 play:)
			(boxPlayer maxFrame: 20)
			(self dispose:)
		)
	)
)

(instance latch of Feature
	(properties
		y 1000
	)

	(method (init)
		(switch (boxPlayer curFrame:)
			(0
				(localproc_1 self 229 161 262 204)
			)
			(1
				(localproc_1 self 201 157 230 202)
			)
			(2
				(localproc_1 self 176 153 208 194)
			)
			(3
				(localproc_1 self 163 144 189 190)
			)
			(16
				(localproc_1 self 341 147 368 188)
			)
			(17
				(localproc_1 self 320 158 354 196)
			)
			(18
				(localproc_1 self 288 162 329 202)
			)
			(19
				(localproc_1 self 260 163 294 205)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (localproc_0 self 0)) ; Do
			(gCurRoom setScript: latchAni)
		)
	)
)

(instance latch2Ftr of Feature
	(properties
		y 1000
	)

	(method (init &tmp temp0 temp1)
		(if local13
			(= temp1 0)
		else
			(= temp1 4)
		)
		(switch (boxPlayer curFrame:)
			((+ temp1 5)
				(localproc_1 self 163 137 190 195)
			)
			((+ temp1 4)
				(localproc_1 self 177 149 210 201)
			)
			((+ temp1 3)
				(localproc_1 self 199 158 240 205)
			)
			((+ temp1 2)
				(localproc_1 self 227 158 280 204)
			)
			((+ temp1 1)
				(localproc_1 self 265 158 305 204)
			)
			(temp1
				(localproc_1 self 297 158 331 204)
			)
			(
				(if local13
					(boxPlayer maxFrame:)
				else
					(- temp1 1)
				)
				(localproc_1 self 323 152 351 201)
			)
			(
				(if local13
					(- (boxPlayer maxFrame:) 1)
				else
					(- temp1 2)
				)
				(localproc_1 self 345 147 370 190)
			)
			(
				(if local13
					(- (boxPlayer maxFrame:) 2)
				else
					(- temp1 3)
				)
				(localproc_1 self 347 138 379 182)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (localproc_0 self (if local13 0 else 4))) ; Do
			(gCurRoom setScript: turnLatch2Scr)
		)
	)
)

(instance stud2Ftr of Feature
	(properties
		y 1000
	)

	(method (init)
		(if (not local13)
			(return)
		)
		(switch (boxPlayer curFrame:)
			(11
				(localproc_1 self 174 151 193 174)
			)
			(10
				(localproc_1 self 181 156 200 179)
			)
			(9
				(localproc_1 self 195 163 217 185)
			)
			(8
				(localproc_1 self 220 168 239 190)
			)
			(7
				(localproc_1 self 242 166 270 191)
			)
			(6
				(localproc_1 self 271 166 299 192)
			)
			(5
				(localproc_1 self 297 163 324 188)
			)
			(4
				(localproc_1 self 323 161 343 184)
			)
			(3
				(localproc_1 self 339 159 357 178)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (localproc_0 self 6)) ; Do
			(gCurRoom setScript: openFishPanelScr)
		)
	)
)

(instance redButtonFeature of Feature
	(properties
		y 1000
	)

	(method (init &tmp temp0 temp1)
		(= temp1 (boxPlayer curFrame:))
		(switch
			(= temp0
				(cond
					((== (boxPlayer number:) 4342)
						(if (OneOf temp1 20 19)
							(- temp1 26)
						else
							(+ temp1 8)
						)
					)
					((== (boxPlayer number:) 4335) temp1)
					((== temp1 20) 6)
					(else
						(+ temp1 7)
					)
				)
			)
			(6
				(localproc_1 self 334 151 357 188)
			)
			(7
				(localproc_1 self 316 154 347 194)
			)
			(8
				(localproc_1 self 285 158 328 201)
			)
			(9
				(localproc_1 self 255 160 302 203)
			)
			(10
				(localproc_1 self 227 160 271 206)
			)
			(11
				(localproc_1 self 201 154 242 203)
			)
			(12
				(localproc_1 self 183 150 218 197)
			)
			(13
				(localproc_1 self 179 145 198 191)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(localproc_0
					self
					(switch (boxPlayer number:)
						(4335 7)
						(4342 20)
						(else 0)
					)
				)
			)
			(gCurRoom setScript: redButtonAni)
		)
	)
)

(instance sideStudFeature of Feature
	(properties
		y 1000
	)

	(method (init)
		(switch (boxPlayer curFrame:)
			(1
				(localproc_1 self 333 159 353 183)
			)
			(2
				(localproc_1 self 317 163 338 189)
			)
			(3
				(localproc_1 self 294 164 319 193)
			)
			(4
				(localproc_1 self 267 166 291 192)
			)
			(5
				(localproc_1 self 241 165 263 191)
			)
			(6
				(localproc_1 self 209 161 232 190)
			)
			(7
				(localproc_1 self 193 159 209 186)
			)
			(8
				(localproc_1 self 181 156 194 178)
			)
			(else
				(return)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (localproc_0 self 2)) ; Do
			(gCurRoom setScript: sideStudAni)
		)
	)
)

(instance squarePegFeature of Feature
	(properties
		y 1000
	)

	(method (init)
		(self
			setPolygon:
				(switch (boxPlayer curFrame:)
					(17
						((Polygon new:)
							type: PTotalAccess
							init: 242 260 259 260 258 245 239 246
							yourself:
						)
					)
					(16
						((Polygon new:)
							type: PTotalAccess
							init: 279 260 302 265 301 241 276 242
							yourself:
						)
					)
					(15
						((Polygon new:)
							type: PTotalAccess
							init: 315 255 338 256 336 234 315 238
							yourself:
						)
					)
					(14
						((Polygon new:)
							type: PTotalAccess
							init: 344 245 361 245 361 224 341 226
							yourself:
						)
					)
					(13
						((Polygon new:)
							type: PTotalAccess
							init: 354 232 374 234 370 210 352 215
							yourself:
						)
					)
				)
		)
		(if onMeCheck
			(super init: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (boxPlayer number:) 4347)
					(= local8 1)
					(gCurRoom setScript: squarePegAni)
					(return)
				)
				(if (localproc_0 self 16)
					(gCurRoom setScript: squarePegAni)
				)
			)
		)
	)
)

(instance rotateRight of ExitFeature
	(properties
		nsBottom 238
		nsLeft 380
		nsRight 450
		nsTop 63
	)

	(method (init)
		(= exitCode rotateCode)
		(= cursorObj rightCursor)
		(super init: &rest)
	)
)

(instance rotateLeft of ExitFeature
	(properties
		nsBottom 238
		nsLeft 35
		nsRight 135
		nsTop 63
	)

	(method (init)
		(= exitCode rotateCode)
		(= cursorObj leftCursor)
		(super init: &rest)
	)
)

(instance leavePuzzle of ExitFeature
	(properties)

	(method (init)
		(= exitCode leavePuzzleCode)
		(= cursorObj myExitCursor)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 2 49 60 49 60 299 2 299 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 440 53 440 299 499 299 499 53
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance amuletStudFtr of Feature
	(properties
		y 301
		nsBottom 67
		nsLeft 255
		nsRight 281
		nsTop 37
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: pushAmuletStudScr)
		)
	)
)

(instance bottleFtr of Feature
	(properties
		nsBottom 191
		nsLeft 246
		nsRight 294
		nsTop 143
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory addItem: ((ScriptID 9 57) state: 1 yourself:)) ; invCrystalBottle
			(cylinderATP loop: 0 setPri: 300)
			(cylinderTop dispose:)
			(cylinderBottom dispose:)
			(cylinder dispose:)
			(self dispose:)
			(SetFlag 169)
			(gMySoundFX number: 43512 loop: 0 play:)
		)
	)
)

(instance fishPanel1Ftr of Feature
	(properties
		y 300
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 226 231 185 246 203 264 193 268 186 280 186 322 207 322 211 301 221 263 220 264 212 246 213 249 221
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not local11) (inlayList allTrue: 1001 1)) ; Do
			(gCurRoom setScript: openPanel1Scr)
		)
	)
)

(instance fishPanel2Ftr of Feature
	(properties
		y 300
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 144 267 107 278 120 299 111 298 105 310 105 310 110 337 117 356 130 337 140 321 142 304 134 296 141 294 131 274 130 277 140
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) local11 (inlayList allTrue: 1001 2)) ; Do
			(gCurRoom setScript: openPanel2Scr)
		)
	)
)

(instance amuletDropFtr of Feature
	(properties
		nsBottom 225
		nsLeft 224
		nsRight 323
		nsTop 113
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 82 50)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; invPuzzleAmulet
				(gCurRoom setScript: placeAmuletPartScr)
			)
			(50 ; invJems
				(if ((ScriptID 9 73) state:) ; invPuzzleAmulet
					(gCurRoom setScript: placeJemScr)
				)
			)
		)
	)
)

(instance keyHoleFtr of Feature
	(properties
		y 305
		nsBottom 151
		nsLeft 246
		nsRight 364
		nsTop 89
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 17)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(if (== theVerb 17) ; invPuzzleBoxKey
			(gCurRoom setScript: closePanel2Scr)
		)
	)
)

(instance inlaySwitch of Feature
	(properties
		y 301
		nsBottom 209
		nsLeft 267
		nsRight 300
		nsTop 195
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: closePanel1Scr)
		)
	)
)

(instance rightCursor of Cursor
	(properties
		cel 1
		view 1101
	)
)

(instance leftCursor of Cursor
	(properties
		view 1101
	)
)

(instance myExitCursor of Cursor
	(properties
		loop 2
		view 1100
	)
)

(instance boxPlayer of RobotPlayer
	(properties)
)

(instance establishHotSpots of Code
	(properties)

	(method (doit)
		(switch global244
			(0
				(latch init:)
			)
			(1
				(square8Level8 init: active: 1)
				(square7Level7 init: active: 1)
				(square6Level7 init: active: 1)
				(square5Level5 init: active: 1)
				(square4Level4 init: active: 1)
				(square3Level2 init: active: 1)
				(square2Level2 init: active: 1)
				(square1Level1 init: active: 1 canStayDownOrOver: 1)
				(= local16 0)
				(= local17 1)
			)
			(2
				(redButtonFeature init:)
				(if local5
					(sideStudFeature init:)
				)
			)
			(3
				(redButtonFeature init:)
				(if (and local2 (not (IsFlag 77)))
					(keyFeature init:)
				)
			)
			(4
				(squarePegFeature init:)
			)
			(5
				(latch2Ftr init:)
				(stud2Ftr init:)
			)
		)
	)
)

(instance tilePuzzleManager of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (or (not argc) param1)
			(= temp4 -1)
			(= temp1 (List new:))
			(temp1
				add:
					(tilePiece0 position: 0 yourself:)
					(tilePiece1 position: 1 yourself:)
					(tilePiece2 position: 2 yourself:)
					(tilePiece3 position: 3 yourself:)
					(tilePiece4 position: 4 yourself:)
					(tilePiece5 position: 5 yourself:)
					(tilePiece6 position: 6 yourself:)
					(tilePiece7 position: 7 yourself:)
					(tilePiece8 position: 8 yourself:)
					(tilePiece9 position: 9 yourself:)
					(tilePiece10 position: 10 yourself:)
					(tilePiece11 position: 11 yourself:)
					(tilePiece12 position: 12 yourself:)
					(tilePiece13 position: 13 yourself:)
					(tilePiece14 position: 14 yourself:)
					(tilePiece15 position: 15 yourself:)
					(tilePiece16 position: 16 yourself:)
					(tilePiece17 position: 17 yourself:)
					(tilePiece18 position: 18 yourself:)
					(tilePiece19 position: 19 yourself:)
					(tilePiece20 position: 20 yourself:)
					(tilePiece21 position: 21 yourself:)
					(tilePiece22 position: 22 yourself:)
					(tilePiece23 position: 23 yourself:)
			)
			(if (or (== argc 1) param2)
				(= local4 24)
				(for ((= temp8 0)) (<= temp8 100) ((++ temp8))
					(= temp3 (List new:))
					(for ((= temp2 0)) (<= temp2 23) ((++ temp2))
						(cond
							(
								(and
									(not (mod ((temp1 at: temp2) position:) 5))
									(==
										(- ((temp1 at: temp2) position:) 5)
										local4
									)
								)
								(temp3 add: (temp1 at: temp2))
							)
							((== (+ ((temp1 at: temp2) position:) 5) local4)
								(temp3 add: (temp1 at: temp2))
							)
							((== (+ ((temp1 at: temp2) position:) 1) local4)
								(temp3 add: (temp1 at: temp2))
							)
							(
								(and
									(==
										(+ ((temp1 at: temp2) position:) 1)
										local4
									)
									(mod (+ ((temp1 at: temp2) position:) 1) 5)
								)
								(temp3 add: (temp1 at: temp2))
							)
							(
								(or
									(==
										(- ((temp1 at: temp2) position:) 1)
										local4
									)
									(==
										(- ((temp1 at: temp2) position:) 5)
										local4
									)
									(==
										(+ ((temp1 at: temp2) position:) 5)
										local4
									)
								)
								(temp3 add: (temp1 at: temp2))
							)
						)
					)
					(= temp4 local4)
					(= temp5 (temp3 size:))
					(= temp6 (temp3 at: (Random 0 (- temp5 1))))
					(= temp7 (temp6 position:))
					(temp6 position: local4)
					(= local4 temp7)
					(temp3 dispose:)
				)
			)
			(temp1 eachElementDo: #init release: dispose:)
		else
			(tilePiece0 dispose:)
			(tilePiece1 dispose:)
			(tilePiece2 dispose:)
			(tilePiece3 dispose:)
			(tilePiece4 dispose:)
			(tilePiece5 dispose:)
			(tilePiece6 dispose:)
			(tilePiece7 dispose:)
			(tilePiece8 dispose:)
			(tilePiece9 dispose:)
			(tilePiece10 dispose:)
			(tilePiece11 dispose:)
			(tilePiece12 dispose:)
			(tilePiece13 dispose:)
			(tilePiece14 dispose:)
			(tilePiece15 dispose:)
			(tilePiece16 dispose:)
			(tilePiece17 dispose:)
			(tilePiece18 dispose:)
			(tilePiece19 dispose:)
			(tilePiece20 dispose:)
			(tilePiece21 dispose:)
			(tilePiece22 dispose:)
			(tilePiece23 dispose:)
		)
	)
)

(instance checkPuzzle of Code
	(properties)

	(method (doit)
		(if
			(or
				(== global246 1)
				(and
					(== (tilePiece0 position:) (tilePiece0 correctPos:))
					(== (tilePiece1 position:) (tilePiece1 correctPos:))
					(== (tilePiece2 position:) (tilePiece2 correctPos:))
					(== (tilePiece3 position:) (tilePiece3 correctPos:))
					(== (tilePiece4 position:) (tilePiece4 correctPos:))
					(== (tilePiece5 position:) (tilePiece5 correctPos:))
					(== (tilePiece6 position:) (tilePiece6 correctPos:))
					(== (tilePiece7 position:) (tilePiece7 correctPos:))
					(== (tilePiece8 position:) (tilePiece8 correctPos:))
					(== (tilePiece9 position:) (tilePiece9 correctPos:))
					(== (tilePiece10 position:) (tilePiece10 correctPos:))
					(== (tilePiece11 position:) (tilePiece11 correctPos:))
					(== (tilePiece12 position:) (tilePiece12 correctPos:))
					(== (tilePiece13 position:) (tilePiece13 correctPos:))
					(== (tilePiece14 position:) (tilePiece14 correctPos:))
					(== (tilePiece15 position:) (tilePiece15 correctPos:))
					(== (tilePiece16 position:) (tilePiece16 correctPos:))
					(== (tilePiece17 position:) (tilePiece17 correctPos:))
					(== (tilePiece18 position:) (tilePiece18 correctPos:))
					(== (tilePiece19 position:) (tilePiece19 correctPos:))
					(== (tilePiece20 position:) (tilePiece20 correctPos:))
					(== (tilePiece21 position:) (tilePiece21 correctPos:))
					(== (tilePiece22 position:) (tilePiece22 correctPos:))
					(== (tilePiece23 position:) (tilePiece23 correctPos:))
				)
			)
			(gCurRoom setScript: finishTilePuzzleScr)
		)
	)
)

(instance ringInitializer of Code
	(properties)

	(method (doit param1)
		(if (or (not argc) param1)
			(= local12 0)
			(ringList
				add: ring1 ring2 ring3 ring4
				eachElementDo: #init
				eachElementDo: #perform randomCycleCode
			)
			(tileSound1 number: 223 loop: -1 play:)
			(cylinderATP init:)
			(cylinderTop init:)
			(cylinderBottom init:)
		else
			(ringList eachElementDo: #dispose)
		)
	)
)

(instance inlayInitializer of Code
	(properties)

	(method (doit param1 &tmp [temp0 3])
		(if (or (not argc) param1)
			(inlayList
				add:
					inlayPiece0
					inlayPiece1
					inlayPiece2
					inlayPiece3
					inlayPiece4
					inlayPiece5
					inlayPiece6
					inlayPiece7
					inlayPiece8
					inlayPiece9
					inlayPiece10
					inlayPiece11
					inlayPiece12
					inlayPiece13
					inlayPiece14
					inlayPiece15
					inlayPiece16
					inlayPiece17
					inlayPiece18
					inlayPiece19
					inlayPiece20
			)
			(inlayList eachElementDo: #init)
			(fishPanel1Ftr init:)
			(fishPanel2Ftr init:)
		else
			(fishPanel1Ftr dispose:)
			(fishPanel2Ftr dispose:)
			(inlayList dispose:)
		)
	)
)

(instance randomCycleCode of Code
	(properties)

	(method (doit param1)
		(param1 setCycle: CT (Random 0 (- (param1 lastCel:) 1)) 1 param1)
	)
)

(instance rotateCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(if local0
			(= local0 0)
			(gMySoundFX stop:)
			(boxPlayer stop:)
			(establishHotSpots doit:)
		else
			(if (< argc 1)
				(if (== gTheCursor leftCursor)
					(= temp0 1)
				else
					(= temp0 2)
				)
			else
				(= temp0 param2)
			)
			(switch global244
				(0
					(latch dispose:)
				)
				(1
					(gCurRoom setScript: closeBox 0 temp0)
					(return)
				)
				(else
					(cond
						((and local6 (not local1))
							(= local1 1)
							(boxPlayer dispose:)
							(boxPlayer
								init: 4338 (if (== temp0 1) 17 else 15) 0 0
							)
							(= global244 3)
						)
						((== global244 2)
							(redButtonFeature dispose:)
							(sideStudFeature dispose:)
						)
						((== global244 3)
							(keyFeature dispose:)
							(redButtonFeature dispose:)
						)
						((== global244 4)
							(if local3
								(gCurRoom setScript: closeBirdPanel 0 temp0)
								(return)
							else
								(squarePegFeature dispose:)
							)
						)
						((== global244 5)
							(latch2Ftr dispose:)
							(stud2Ftr dispose:)
						)
					)
				)
			)
			(if (not (and argc param1))
				(if (== global246 -1)
					(localproc_5 temp0)
				else
					(= local0 1)
					(boxPlayer start: temp0 12 1)
					(gMySoundFX number: 20001 setLoop: -1 play:)
				)
			)
		)
	)
)

(instance leavePuzzleCode of Code
	(properties)

	(method (doit)
		(if (and (== global244 3) (IsFlag 77))
			(gGame handsOff:)
			(closeKeyPanelAni register: 1)
			(redButtonFeature doVerb: 5)
		else
			(gCurRoom newRoom: 350)
		)
	)
)

(instance tileSound1 of Sound
	(properties)
)

(instance tileSound2 of Sound
	(properties)
)

(instance ringList of List
	(properties)
)

(instance inlayList of List
	(properties)
)

(instance songTimer of Timer
	(properties)
)

(instance changeSong of Script
	(properties)

	(method (cue)
		(if (= local18 (not local18))
			(songTimer setReal: self (Random 2 5))
		else
			(if (not local19)
				(= local19 1)
				(Load rsAUDIO 102)
			)
			(gBackMusic number: 102 loop: 0 play: self)
		)
	)
)

