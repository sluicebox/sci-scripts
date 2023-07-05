;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rCliffs 0
	proc21_1 1
)

(local
	[local0 200]
	[local200 18]
	[local218 28]
	[local246 16] = [74 103 132 161 190 219 248 219 190 161 132 103 132 161 190 219]
	[local262 16] = [184 172 160 148 136 124 112 100 88 76 64 52 40 28 16 4]
	[local278 9] = [103 132 161 190 161 132 103 74 45]
	[local287 37] = [100 88 76 64 52 40 28 16 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	local324
	local325
	local326
	local327
	local328
)

(procedure (proc21_1)
	(if (== ((ScriptID 21 0) stepSound:) 1) ; rCliffs
		((ScriptID 21 0) stepSound: 4) ; rCliffs
	else
		((ScriptID 21 0) stepSound: (- ((ScriptID 21 0) stepSound:) 1)) ; rCliffs, rCliffs
	)
	(gGlobalSound3
		number:
			(switch ((ScriptID 21 0) stepSound:) ; rCliffs
				(1 301)
				(2 302)
				(3 303)
				(4 304)
			)
		setLoop: 1
		play:
	)
)

(class rCliffs of Rgn
	(properties
		cliffFace 0
		puzzleIsUp 0
		stepDirection 0
		stepSound 1
		cheatCount 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 300 320))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (notify)
		(= local325 1)
		(= local326 (Random 500 1000))
	)

	(method (cue)
		(= local325 0)
	)

	(method (init)
		(super init:)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose:)
	)
)

(class CliffRoom of KQ6Room
	(properties
		maxRocks 0
		rockCount 0
		flipRocks 0
		rockList 0
	)

	(method (init)
		(if (not rockList)
			((= rockList (Set new:)) add:)
		)
		(super init: &rest)
	)

	(method (constantRocks &tmp temp0)
		(rCliffs cheatCount: 0)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			((= [local200 temp0] (RockStep new:))
				x:
					(if argc
						(- 320 [local246 temp0])
					else
						[local246 temp0]
					)
				y: [local262 temp0]
				cel: 3
				rockPointer: temp0
				corner: (if (== temp0 6) 1 else 0)
				init:
				stopUpd:
			)
			(rockList add: [local200 temp0])
			(if (< temp0 6)
				([local200 temp0] addToPic:)
			)
		)
	)

	(method (callForRocks)
		(if (== gCurRoomNum 300)
			(self rockCount: 0 maxRocks: 9)
		else
			(self rockCount: 7 maxRocks: 16)
		)
		(self makeARock:)
	)

	(method (makeARock)
		(if (== rockCount maxRocks)
			(if (== gCurRoomNum 300)
				(gMessager say: 8 5 18 2 0 21) ; "Alexander stares with wonder. That's quite a way to welcome a guest--if, indeed, it IS a welcome."
			)
			((gCurRoom script:) cue:)
		else
			(ShakeScreen 1 (Random 0 2))
			(gGlobalSound3 number: 300 setLoop: 1 play:)
			(if (> rockCount 0)
				([local200 (- rockCount 1)] stopUpd:)
			)
			((= [local200 rockCount] (RockStep new:))
				x:
					(cond
						((== gCurRoomNum 300) [local278 rockCount])
						(flipRocks
							(- 320 [local246 rockCount])
						)
						(else [local246 rockCount])
					)
				y:
					(if (== gCurRoomNum 300)
						[local287 rockCount]
					else
						[local262 rockCount]
					)
				cel:
					(if
						(or
							(== gPrevRoomNum 130)
							(== gPrevRoomNum 340)
							(== gPrevRoomNum 370)
						)
						2
					else
						0
					)
				rockPointer: rockCount
				corner:
					(cond
						((and (== rockCount 3) (== gCurRoomNum 300)) 1)
						(
							(and
								(or (== rockCount 6) (== rockCount 11))
								(== gCurRoomNum 320)
							)
							1
						)
						(else 0)
					)
				capStone:
					(if
						(or
							(and (== rockCount 14) (== gCurRoomNum 320))
							(and (== rockCount 7) (== gCurRoomNum 300))
						)
						1
					else
						0
					)
				init:
				setCycle: End RockStep
			)
			(rockList add: [local200 rockCount])
			(self rockCount: (+ (self rockCount:) 1))
		)
	)

	(method (allRocksOut param1 &tmp temp0 temp1 temp2)
		(rCliffs cheatCount: 0)
		(if (== gCurRoomNum 300)
			(= temp1 9)
			(= temp2 0)
		else
			(= temp1 16)
			(= temp2 0)
		)
		(for ((= temp0 temp2)) (< temp0 temp1) ((++ temp0))
			((= [local200 temp0] (RockStep new:))
				x:
					(cond
						((== gCurRoomNum 300) [local278 temp0])
						(param1
							(- 320 [local246 temp0])
						)
						(else [local246 temp0])
					)
				y: (if (== gCurRoomNum 300) [local287 temp0] else [local262 temp0])
				cel: 3
				rockPointer: temp0
				corner:
					(cond
						((== gCurRoomNum 300)
							(if (== temp0 3) 1 else 0)
						)
						((or (== temp0 6) (== temp0 11)) 1)
						(else 0)
					)
				capStone:
					(cond
						((== gCurRoomNum 300)
							(if (== temp0 7) 1 else 0)
						)
						((== temp0 14) 1)
						(else 0)
					)
				init:
				stopUpd:
			)
			(rockList add: [local200 temp0])
			(if (< temp0 6)
				([local200 temp0] addToPic:)
			)
		)
		(UnLoad 128 300)
	)

	(method (dumpRocks &tmp temp0)
		(if rockList
			(rockList release:)
		)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(if (gCast contains: [local200 temp0])
				([local200 temp0] dispose: delete:)
				(= [local200 temp0] 0)
			)
		)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(if (gAddToPics contains: [local200 temp0])
				([local200 temp0] dispose: delete:)
				(= [local200 temp0] 0)
			)
		)
	)

	(method (newRoom)
		(gDirectionHandler delete: gCurRoom)
		(if rockList
			(rockList release: dispose:)
			(= rockList 0)
		)
		(super newRoom: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 10])
		(if
			(and
				(User controls:)
				(& (event type:) $0040) ; direction
				(!= (event message:) JOY_NULL)
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(IsObject rockList)
			)
			(if (not (= temp0 (rockList firstTrue: #onMe (User curEvent:))))
				(= temp0 (rockList firstTrue: #onMe gEgo))
			)
			(= temp1 (rockList indexOf: temp0))
			(switch (event message:)
				(JOY_UP
					(if (!= (rockList size:) (- temp1 1))
						(= temp0 (rockList at: (+ temp1 1)))
					)
				)
				(JOY_DOWN
					(if (!= temp1 0)
						(= temp0 (rockList at: (- temp1 1)))
					)
				)
				(else 0)
			)
			(if (IsObject temp0)
				(SetCursor (+ (temp0 x:) 8) (temp0 y:))
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(class RockStep of Prop
	(properties
		view 300
		loop 5
		signal 16401
		cycleSpeed 24
		corner 0
		rockPointer 0
		capStone 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 0 1 0 21) ; "Large boulders have pushed their way from the cliffs to form a rough staircase."
			)
			(5 ; Do
				(gMessager say: 6 5 0 1 0 21) ; "The steps cannot be moved any further backwards or forwards."
			)
			(2 ; Talk
				(gMessager say: 6 2 0 1 0 21) ; "The stone steps pay no heed to Alexander's voice. They remain fixed in place."
			)
			(else
				(gMessager say: 6 0 0 1 0 21) ; "There's no reason to use that on the stone steps."
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(gCurRoom makeARock:)
	)

	(method (doit)
		(if local325
			(cond
				((gEgo script:))
				((> local326 0)
					(-- local326)
				)
				(else
					(gEgo setScript: egoWobbles)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
			)
			(if
				(and
					(or (== (event message:) KEY_RETURN) (== (event type:) evMOUSEBUTTON))
					(self onMe: event)
				)
				(event claimed: 1)
				(= local325 0)
				(cond
					((== (gEgo script:) egoWobbles)
						(SetFlag 59)
						(gMessager say: 6 3 17 1 0 21) ; "Whoa! Wait a minute!"
					)
					(
						(and
							(or
								(== (gEgo view:) 900)
								(== (gEgo view:) 308)
								(== (gEgo view:) 3081)
							)
							(== (self rockPointer:) 0)
						)
						(gEgo setScript: takeFirstStep 0 [local200 0])
					)
					(
						(and
							(< (- (self y:) (gEgo y:)) 15)
							(> (- (self y:) (gEgo y:)) 2)
						)
						(gEgo
							setScript: stepDown 0 [local200 (self rockPointer:)]
						)
					)
					(
						(or
							(> (Abs (- (gEgo y:) (self y:))) 20)
							(> (Abs (- (gEgo x:) (self x:))) 64)
						)
						(gMessager say: 6 3 16 1 0 21) ; "Alexander cannot get to that step from here."
					)
					(
						(or
							(and
								(< (- (self x:) (gEgo x:)) 40)
								(> (- (self x:) (gEgo x:)) 35)
								(< (self y:) (gEgo y:))
							)
							(and
								(< (- (gEgo x:) (self x:)) 57)
								(> (- (gEgo x:) (self x:)) 54)
								(< (self y:) (gEgo y:))
							)
						)
						(gEgo
							setScript: takeStep 0 [local200 (self rockPointer:)]
						)
					)
					(
						(and
							(> (self x:) (gEgo x:))
							(< (gEgo y:) 99)
							(== gCurRoomNum 300)
							(< (self y:) (gEgo y:))
						)
						(gEgo
							setScript: takeStep 0 [local200 (self rockPointer:)]
						)
					)
					((and (> (self x:) (gEgo x:)) (< (self y:) (gEgo y:)))
						(gEgo
							setScript: takeStep 0 [local200 (self rockPointer:)]
						)
					)
					((and (< (self x:) (gEgo x:)) (< (self y:) (gEgo y:)))
						(gEgo
							setScript: takeStep 0 [local200 (self rockPointer:)]
						)
					)
				)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

(class HyroGliph of View
	(properties
		hyroVal 0
		deathButt 0
	)
)

(instance letter of HyroGliph
	(properties)
)

(class PuzzleInset of View
	(properties
		maxButtons 0
		buttNumber 0
		buttView 0
		buttTop 0
		buttLeft 0
		buttRight 0
		buttBottom 0
		buttLoop 0
		buttCel 0
		buttX 0
		buttY 0
		buttVal 0
		buttKill 0
		buttonCount 0
		correctButton 1
		savePMouse 0
		solvedPuzz 0
		lookMsg 0
		puzzNumber 0
	)

	(method (doButton param1 param2 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 buttNumber) ((++ temp0))
			(if
				(and
					(<=
						(WordAt buttLeft temp0)
						param1
						(WordAt buttRight temp0)
					)
					(<=
						(WordAt buttTop temp0)
						param2
						(WordAt buttBottom temp0)
					)
				)
				(if (== [local218 temp0] 0)
					(if (and (== gCurRoomNum 300) (== local324 3))
						(= global110 temp0)
					)
					(if (or (== puzzNumber 2) (== puzzNumber 4))
						(= temp1 2)
					else
						(= temp1 0)
					)
					(++ local324)
					(gGlobalSound3 number: 308 setLoop: 1 play:)
					((= [local218 temp0] (letter new:))
						view: buttView
						setLoop: (WordAt buttLoop temp0)
						cel: (WordAt buttCel temp0)
						x: (+ (WordAt buttX temp0) temp1)
						y: (WordAt buttY temp0)
						hyroVal: (WordAt buttVal temp0)
						deathButt: (WordAt buttKill temp0)
						setPri: 14
						init:
						stopUpd:
					)
					(= local327 1)
					(if ([local218 temp0] deathButt:)
						(= local328 1)
						(rCliffs cue:)
						(gCurRoom setScript: seeYa 0 self)
					else
						(self cue: ([local218 temp0] hyroVal:))
					)
					(return 1)
				else
					(return 1)
				)
				(break)
			)
		)
	)

	(method (puzzSolved &tmp [temp0 2])
		(gCurRoom setScript: puzzleSolvedPause 0 self)
	)

	(method (cue param1)
		(self buttonCount: (+ (self buttonCount:) 1))
		(cond
			((or (== param1 correctButton) (== param1 -1))
				(self correctButton: (+ (self correctButton:) 1))
				(if (== correctButton (+ maxButtons 1))
					(= correctButton (+ (= buttonCount 0) 1))
					(gCurRoom setScript: notifyTheRoom 0 self)
				)
			)
			((== buttonCount buttNumber)
				(gCurRoom setScript: clearTheButtons 0 self)
			)
			((!= param1 correctButton)
				(self correctButton: (+ (self correctButton:) 10))
			)
		)
	)

	(method (dumpButtons &tmp temp0)
		(for ((= temp0 0)) (< temp0 28) ((++ temp0))
			(if (!= [local218 temp0] 0)
				([local218 temp0] dispose:)
				(= [local218 temp0] 0)
			)
		)
	)

	(method (init &tmp temp0)
		(gTheIconBar disable: 3 0 4 5 6)
		(for ((= temp0 0)) (< temp0 28) ((++ temp0))
			(= [local218 temp0] 0)
		)
		(rCliffs puzzleIsUp: 1)
		(self setPri: 12 signal: 4112 ignoreActors: stopUpd:)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(rCliffs puzzleIsUp: 0)
		(self dumpButtons:)
		(= correctButton (+ (= local324 (= buttonCount 0)) 1))
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (not local328)
			(gGame handsOn:)
		)
		(gTheIconBar enable: 6)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(or
					(and (== (event message:) KEY_RETURN) (& (event type:) evKEYBOARD))
					(== (event type:) evMOUSEBUTTON)
				)
				(not (event modifiers:))
			)
			(cond
				(solvedPuzz
					(event claimed: 1)
					(self solvedPuzz: 0)
					(self dispose:)
				)
				(
					(and
						(self onMe: event)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					)
					(event claimed: 1)
					(gMessager say: lookMsg 1 0 1 0 21)
				)
				(
					(and
						(or
							(& (event type:) evMOUSEBUTTON)
							(and
								(& (event type:) evKEYBOARD)
								(== (event message:) KEY_RETURN)
							)
						)
						(self doButton: (event x:) (event y:))
					)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(gCurRoom setScript: clearTheButtons 0 self)
				)
				((and (& (event type:) evMOUSEBUTTON) (event modifiers:))
					(event claimed: 0)
				)
				((& (event type:) evKEYBOARD)
					(cond
						((== (event message:) KEY_RETURN)
							(event claimed: 1)
							(gMessager say: 8 5 7 1 0 21) ; "Nothing happens."
							(self dispose:)
						)
						(27
							(event claimed: 1)
							(gMessager say: 8 5 7 1 0 21) ; "Nothing happens."
							(self dispose:)
						)
						(else
							(event claimed: 0)
						)
					)
				)
				(else
					(event claimed: 0)
				)
			)
		else
			(event claimed: 0)
		)
		(event claimed:)
	)
)

(instance stepDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rCliffs cheatCount: (- (rCliffs cheatCount:) 1))
				(cond
					(([local200 (+ (register rockPointer:) 1)] corner:)
						(if (< (gEgo loop:) 6)
							(rCliffs stepDirection: 1)
						else
							(rCliffs stepDirection: 2)
						)
						(= ticks 4)
					)
					((== (rCliffs stepDirection:) 4)
						(gEgo
							view: 3011
							setLoop: 1
							cel: 0
							x: (+ (gEgo x:) 18)
							y: (+ (gEgo y:) 11)
						)
						(rCliffs stepDirection: 1)
						(= cycles 6)
					)
					((== (rCliffs stepDirection:) 3)
						(gEgo
							view: 3011
							setLoop: 1
							cel: 0
							x: (- (gEgo x:) 18)
							y: (+ (gEgo y:) 11)
						)
						(rCliffs stepDirection: 2)
						(= cycles 6)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (== (rCliffs stepSound:) 1)
					(rCliffs stepSound: 4)
				else
					(rCliffs stepSound: (- (rCliffs stepSound:) 1))
				)
				(gGlobalSound3
					number:
						(switch (rCliffs stepSound:)
							(1 301)
							(2 302)
							(3 303)
							(4 304)
						)
					setLoop: 1
					play:
				)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo
						view: 301
						setLoop: 7
						cel: 0
						cycleSpeed: 16
						posn: (+ (register x:) 24) (- (register y:) 13)
					)
				else
					(gEgo
						view: 301
						setLoop: 8
						cel: 0
						posn: (- (register x:) 6) (- (register y:) 13)
						cycleSpeed: 16
					)
				)
				(= cycles 6)
			)
			(2
				(gEgo cel: 1)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 19) (- (register y:) 11))
				else
					(gEgo posn: (- (register x:) 3) (- (register y:) 11))
				)
				(= cycles 5)
			)
			(3
				(gEgo cel: 2)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 23) (- (register y:) 8))
				else
					(gEgo posn: (- (register x:) 5) (- (register y:) 11))
				)
				(= cycles 5)
			)
			(4
				(gEgo cel: 3)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 18) (- (register y:) 14))
				else
					(gEgo posn: (- (register x:) 5) (- (register y:) 14))
				)
				(= cycles 5)
			)
			(5
				(gEgo cel: 4)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 19) (- (register y:) 14))
				else
					(gEgo posn: (- (register x:) 6) (- (register y:) 14))
				)
				(= cycles 5)
			)
			(6
				(gEgo cel: 5)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 19) (- (register y:) 14))
				else
					(gEgo posn: (- (register x:) 6) (- (register y:) 14))
				)
				(= cycles 5)
			)
			(7
				(gEgo cel: 6)
				(if (== (rCliffs stepDirection:) 2)
					(gEgo posn: (+ (register x:) 19) (- (register y:) 14))
				else
					(gEgo posn: (- (register x:) 4) (- (register y:) 14))
				)
				(= cycles 5)
			)
			(8
				(cond
					(
						(and
							(== (register corner:) 1)
							(== (rCliffs stepDirection:) 2)
						)
						(gEgo
							setLoop: 5
							cel: 0
							cycleSpeed: 7
							posn: (+ (register x:) 9) (+ (gEgo y:) 18)
							setCycle: End self
						)
						(rCliffs stepDirection: 3)
					)
					((== (register corner:) 1)
						(gEgo
							setLoop: 4
							cel: 0
							cycleSpeed: 7
							posn: (+ (register x:) 8) (+ (gEgo y:) 18)
							setCycle: End self
						)
						(rCliffs stepDirection: 4)
					)
					(else
						(self cue:)
					)
				)
			)
			(9
				(cond
					((and (register corner:) (== (gEgo loop:) 5))
						(gEgo
							posn: (+ (register x:) 27) (- (register y:) 2)
							setLoop: (Random 1 2)
							cel: 0
						)
					)
					((and (register corner:) (== (gEgo loop:) 4))
						(gEgo
							posn: (- (register x:) 9) (- (register y:) 1)
							setLoop: 6
							cel: 0
						)
					)
					((== (rCliffs stepDirection:) 1)
						(gEgo
							view: 301
							setLoop: (Random 1 2)
							cel: 0
							posn: (+ (register x:) 26) (- (register y:) 1)
						)
					)
					(else
						(gEgo
							view: 301
							setLoop: 6
							cel: 0
							posn: (- (register x:) 8) (- (register y:) 1)
						)
					)
				)
				(= cycles 6)
			)
			(10
				(gGame handsOn:)
				(if (!= (register corner:) 1)
					(= local325 1)
					(= local326 (Random 1000 2000))
				)
				(if (== (register rockPointer:) 0)
					(if (== ((ScriptID 21 0) cliffFace:) 0) ; rCliffs
						(gCurRoom cue: -1)
					else
						(gCurRoom cue: 0)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance takeFirstStep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo actions: egoStepVerb setMotion: MoveTo 110 112 self)
			)
			(1
				(rCliffs stepSound: 1)
				(gGlobalSound3 number: 301 setLoop: 1 play:)
				(gEgo view: 301 normal: 0 setLoop: 0 cel: 0)
				(= ticks 6)
			)
			(2
				(gEgo cel: 1)
				(= ticks 6)
			)
			(3
				(gEgo
					cel: 2
					posn: (+ (register x:) 7) (+ (register y:) 9)
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(4
				(gGame handsOn:)
				(gEgo
					posn: (+ (register x:) 26) (- (register y:) 2)
					setLoop: 2
					cel: 0
				)
				(= local325 1)
				(rCliffs stepDirection: 3)
				(= local326 (Random 1000 2000))
				(gDirectionHandler add: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance takeStep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rCliffs cheatCount: (+ (rCliffs cheatCount:) 1))
				(cond
					((== (rCliffs stepDirection:) 2)
						(gEgo
							view: 3011
							setLoop: 1
							cel: 0
							posn: (- (register x:) 19) (+ (register y:) 21)
						)
						(rCliffs stepDirection: 3)
						(= cycles 2)
					)
					((== (rCliffs stepDirection:) 1)
						(gEgo
							view: 3011
							setLoop: 1
							cel: 0
							posn: (+ (register x:) 37) (+ (register y:) 19)
						)
						(rCliffs stepDirection: 4)
						(= cycles 2)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (== (rCliffs stepSound:) 4)
					(rCliffs stepSound: 1)
				else
					(rCliffs stepSound: (+ (rCliffs stepSound:) 1))
				)
				(gGlobalSound3
					number:
						(switch (rCliffs stepSound:)
							(1 301)
							(2 302)
							(3 303)
							(4 304)
						)
					setLoop: 1
					play:
				)
				(if (== (rCliffs stepDirection:) 3)
					(gEgo
						view: 301
						cycleSpeed: 10
						setLoop: (Random 1 2)
						cel: 0
						posn: (- (register x:) 2) (+ (register y:) 10)
						setCycle: End self
					)
				else
					(gEgo
						view: 301
						setLoop: 6
						cycleSpeed: 10
						posn: (+ (register x:) 20) (+ (register y:) 11)
						setCycle: End self
					)
				)
			)
			(2
				(if (== (rCliffs stepDirection:) 3)
					(gEgo
						posn: (+ (register x:) 27) (- (register y:) 2)
						cel: 0
					)
				else
					(gEgo
						posn: (- (register x:) 9) (- (register y:) 1)
						cel: 0
					)
				)
				(= ticks 6)
			)
			(3
				(cond
					(
						(and
							(== (register corner:) 1)
							(== (rCliffs stepDirection:) 3)
						)
						(gEgo
							setLoop: 4
							cycleSpeed: 12
							posn: (+ (register x:) 7) (+ (gEgo y:) 7)
							setCycle: End self
						)
					)
					((== (register corner:) 1)
						(gEgo
							setLoop: 5
							cycleSpeed: 12
							posn: (+ (register x:) 10) (+ (gEgo y:) 5)
							setCycle: End self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(cond
					((and (register corner:) (== (rCliffs stepDirection:) 3))
						(gEgo
							posn: (- (register x:) 9) (- (register y:) 1)
							setLoop: 6
							cel: 0
						)
						(rCliffs stepDirection: 4)
					)
					((register corner:)
						(gEgo
							posn: (+ (register x:) 27) (- (register y:) 2)
							setLoop: (Random 1 2)
							cel: 0
						)
						(rCliffs stepDirection: 3)
					)
				)
				(= ticks 6)
			)
			(5
				(gGame handsOn:)
				(if (!= (register corner:) 1)
					(= local325 1)
					(= local326 (Random 1000 2000))
				)
				(if (== (register capStone:) 1)
					(if (== (rCliffs stepDirection:) 4)
						(rCliffs stepDirection: 3)
					else
						(rCliffs stepDirection: 4)
					)
					(gEgo setScript: nextScreenUp 0 register)
				)
				(self dispose:)
			)
		)
	)
)

(instance nextScreenUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (rCliffs stepSound:) 4)
					(rCliffs stepSound: 1)
				else
					(rCliffs stepSound: (+ (rCliffs stepSound:) 1))
				)
				(gGlobalSound3
					number:
						(switch (rCliffs stepSound:)
							(1 301)
							(2 302)
							(3 303)
							(4 304)
						)
					setLoop: 1
					play:
				)
				(if (== (rCliffs stepDirection:) 4)
					(gEgo
						cycleSpeed: 10
						setLoop: (Random 1 2)
						setCycle: End self
					)
				else
					(gEgo setLoop: 6 cycleSpeed: 10 setCycle: End self)
				)
			)
			(1
				(if (== (rCliffs stepDirection:) 4)
					(gEgo
						posn: (+ (register x:) 56) (- (register y:) 14)
						cel: 0
					)
				else
					(gEgo
						posn: (- (register x:) 38) (- (register y:) 13)
						cel: 0
					)
				)
				(= ticks 6)
			)
			(2
				(gGame handsOn:)
				(gEgo hide:)
				(if (== gCurRoomNum 320)
					(gCurRoom cue: 1)
					(self dispose:)
				else
					(gCurRoom newRoom: (gCurRoom north:))
				)
			)
		)
	)
)

(instance notifyTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame givePoints: 1)
				(register dispose:)
				(= cycles 1)
			)
			(1
				(switch (rCliffs cliffFace:)
					(0
						(switch gCurRoomNum
							(300
								(SetFlag 5)
							)
							(320
								(SetFlag 123)
							)
						)
					)
					(1
						(SetFlag 124)
					)
					(2
						(SetFlag 125)
					)
					(3
						(SetFlag 126)
						(SetFlag 6)
					)
				)
				(if (== gCurRoomNum 320)
					(gMessager say: 4 5 6 1 self 21) ; "The stone beneath Alexander's feet trembles as more steps emerge from the granite cliffs."
				else
					(gMessager say: 8 5 18 1 self 21) ; "Huge blocks of stone erupt from the granite cliffs."
				)
			)
			(2
				(gCurRoom notify:)
				(self dispose:)
			)
		)
	)
)

(instance egoWobbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound3 number: 305 setLoop: 1 play:)
				(if (== (gEgo loop:) 6)
					(gEgo
						view: 3011
						posn: (+ (gEgo x:) 18) (+ (gEgo y:) 10)
						cycleSpeed: 12
						setLoop: 1
					)
				else
					(gEgo
						view: 301
						posn: (- (gEgo x:) 18) (+ (gEgo y:) 7)
						cycleSpeed: (Random 4 16)
						setLoop: 3
					)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(1
				(if (== (gEgo view:) 301)
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(2
				(if (== (gEgo view:) 301)
					(gEgo
						posn: (+ (gEgo x:) 18) (- (gEgo y:) 7)
						setLoop: (Random 1 2)
					)
				else
					(gEgo
						posn: (- (gEgo x:) 18) (- (gEgo y:) 10)
						setLoop: 6
					)
				)
				(gEgo view: 301 cycleSpeed: 18 cel: 0)
				(= local326 (Random 1000 2000))
				(ClearFlag 59)
				(self dispose:)
			)
		)
	)
)

(instance seeYa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(register dispose:)
				(= ticks 4)
			)
			(1
				(gMessager say: 3 5 3 1 self 21) ; "Alexander gets the feeling that was the wrong button."
			)
			(2
				([local200 6] setCycle: Beg self)
				(gGlobalSound3 number: 300 setLoop: 1 play:)
			)
			(3
				(gMessager say: 3 5 3 2 self 21) ; "Oops!"
			)
			(4
				(gEgo
					posn: (- (gEgo x:) 10) (gEgo y:)
					ignoreActors:
					illegalBits: 0
					view: 4011
					normal: 0
					cycleSpeed: 6
					setLoop: 0
					setCycle: CT 10 1 self
				)
			)
			(5
				(gGlobalSound3 number: 306 setLoop: 1 play: self)
				(gEgo setCycle: End)
			)
			(6
				(gEgo y: 280)
				(= seconds 2)
			)
			(7
				(gGlobalSound3 number: 307 setLoop: 1 play:)
				(ShakeScreen 2 ssLEFTRIGHT)
				(= ticks 4)
			)
			(8
				(gMessager say: 3 5 3 3 self 21) ; "!!!Do not print this. Comment msg only."
			)
			(9
				(gGlobalSound4 fade: 0 5 5)
				(EgoDead 6) ; "What a riddle! Stones of stealth! Find a Guide, to keep your health!"
			)
		)
	)
)

(instance clearTheButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(register dispose:)
				(= cycles 4)
			)
			(2
				(if local327
					(gMessager say: 8 5 7 1 self 21) ; "Nothing happens."
				else
					(self cue:)
				)
			)
			(3
				(= local327 0)
				(self dispose:)
			)
		)
	)
)

(instance puzzleSolvedPause of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 8 5 8 1 self 21) ; "The correct pattern seems to be fixed into place now, and the other stones no longer move."
			)
			(2
				(if (== gCurRoomNum 320)
					(if (== (gEgo cel:) 1)
						(gEgo view: 301 setLoop: 6 cel: 0)
					else
						(gEgo view: 301 setLoop: 1)
					)
				)
				(UnLoad 128 3012)
				(self dispose:)
			)
		)
	)
)

(instance egoStepVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(return 0)
			)
			(5 ; Do
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(else
				(gMessager say: 0 0 64 1 0 899) ; "These steps are awfully precarious! Alexander had better concentrate on what he's doing and try that later!"
				(return 1)
			)
		)
	)
)

