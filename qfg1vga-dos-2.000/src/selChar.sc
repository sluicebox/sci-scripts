;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use PseudoMouse)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	selChar 0
)

(local
	local0
	local1
	local2
	local3
	[local4 6] = [18 202 201 18 212 201]
	[local10 6] = [146 156 146 153 160 153]
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (fightChar cel:)
		(if (< gHowFast 2)
			(fightChar setCel: 0 cue:)
		else
			(fightChar setCycle: Beg fightChar)
		)
	)
	(if (mageChar cel:)
		(if (< gHowFast 2)
			(mageChar setCel: 0 cue:)
		else
			(mageArm cel: 5 stopUpd:)
			(mageChar setCycle: Beg mageChar)
		)
	)
	(if (thiefChar cel:)
		(if (< gHowFast 2)
			(thiefChar setCel: 0 cue:)
		else
			(thiefChar setCycle: Beg thiefChar)
		)
	)
	(theTitle setLoop: 1 cel: param1 x: [local4 param1] y: [local10 param1])
	(if (or (theTitle onMe: (= temp0 (Event new:))) (not local2))
		(ClearFlag 359)
		(gGame
			setCursor:
				999
				1
				(switch param1
					(0 50)
					(1 140)
					(else 235)
				)
				150
		)
	)
	(temp0 dispose:)
)

(instance selChar of Rm
	(properties
		picture 905
	)

	(method (dispose)
		(= gUseSortedFeatures 1)
		(= gPMouse PseudoMouse)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gTheIconBar disable:)
		(= gUseSortedFeatures 0)
		(= gPMouse 0)
		(gMouseDownHandler add: theTitle fightChar mageChar mageArm thiefChar self)
		(gKeyDownHandler add: self theTitle fightChar mageChar mageArm thiefChar)
		(gDirectionHandler add: self)
		(fightChar init: stopUpd:)
		(mageChar init: stopUpd:)
		(thiefChar init: stopUpd:)
		(theTitle loop: (if (== gPrevRoomNum 203) 0 else 3) init:) ; chAlloc
		(roundRobin start: (if (== gPrevRoomNum 203) 2 else 0)) ; chAlloc
		(self setScript: roundRobin)
		(if (and (not (gLongSong handle:)) (!= (gLongSong number:) 61))
			(gLongSong loop: -1 number: 61 play:)
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (handleEvent event)
		(if (or (event claimed:) local3)
			(event claimed: 1)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_TAB
					(event type: $0040) ; direction
					(event message: JOY_RIGHT)
				)
				(KEY_SHIFTTAB
					(event type: $0040) ; direction
					(event message: JOY_LEFT)
				)
			)
		)
		(if (& (event type:) $0040) ; direction
			(switch (event message:)
				(JOY_LEFT
					(event claimed: 1)
					(script
						state:
							(switch (- (theTitle cel:) 1)
								(0 1)
								(1 3)
								(else 6)
							)
						cue:
					)
				)
				(JOY_RIGHT
					(event claimed: 1)
					(script
						state:
							(switch (+ (theTitle cel:) 1)
								(1 3)
								(2 6)
								(else 1)
							)
						cue:
					)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance fightChar of Prop
	(properties
		x 68
		y 129
		view 526
		signal 4096
	)

	(method (doVerb)
		(return 0)
	)

	(method (handleEvent event)
		(if
			(and
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(self onMe: (event x:) (event y:))
					)
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_ESCAPE KEY_RETURN)
					)
				)
				(not local3)
				(!= (roundRobin state:) 2)
			)
			(event claimed: 1)
			(if (== (roundRobin register:) 1)
				(theTitle cue:)
			else
				(roundRobin changeState: 2)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (init)
		(super init:)
		(if (< gHowFast 2)
			(self view: 206)
		else
			(self view: 526)
		)
	)
)

(instance mageChar of Prop
	(properties
		x 158
		y 129
		view 527
		signal 4096
	)

	(method (doVerb)
		(return 0)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (roundRobin state:))
		(if
			(and
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(self onMe: (event x:) (event y:))
					)
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_ESCAPE KEY_RETURN)
					)
				)
				(not local3)
				(!= temp0 4)
				(!= temp0 5)
			)
			(event claimed: 1)
			(if (== (roundRobin register:) 2)
				(theTitle cue:)
			else
				(roundRobin changeState: 4)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (init)
		(super init:)
		(if (< gHowFast 2)
			(self view: 207)
		else
			(self view: 527)
		)
	)
)

(instance mageArm of Prop
	(properties
		x 162
		y 73
		view 527
		loop 1
		priority 15
		signal 4112
	)

	(method (doVerb)
		(return 0)
	)
)

(instance thiefChar of Prop
	(properties
		x 248
		y 130
		view 528
		signal 4096
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (roundRobin state:))
		(if
			(and
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(self onMe: (event x:) (event y:))
					)
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_ESCAPE KEY_RETURN)
					)
				)
				(not local3)
				(!= temp0 7)
			)
			(event claimed: 1)
			(if (== (roundRobin register:) 3)
				(theTitle cue:)
			else
				(roundRobin changeState: 7)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (init)
		(super init:)
		(if (< gHowFast 2)
			(self view: 208)
		else
			(self view: 528)
		)
	)
)

(instance theTitle of Prop
	(properties
		x 10
		y 138
		view 506
		loop 3
	)

	(method (doVerb)
		(return 0)
	)

	(method (cue)
		(super cue:)
		(= gHeroType cel)
		(= local3 1)
		(roundRobin state: 9 cue:)
		(self setLoop: 2 x: [local4 (+ cel 3)] y: [local10 (+ cel 3)])
	)

	(method (handleEvent event)
		(if
			(and
				local2
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(self onMe: (event x:) (event y:))
					)
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_ESCAPE KEY_RETURN)
					)
				)
			)
			(event claimed: 1)
			(self cue:)
		else
			(super handleEvent: event)
		)
	)
)

(instance roundRobin of Script
	(properties)

	(method (doit)
		(cond
			((< gHowFast 2) 0)
			((and local0 (== (fightChar cel:) 2))
				(gLongSong2 number: 993 setVol: 127 loop: 1 play:)
				(= local0 0)
			)
			((and local1 (== (thiefChar cel:) 2))
				(gLongSong2 number: 109 setVol: 127 loop: 1 play:)
				(= local1 0)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gTheCursor 0)
				(SetFlag 359)
				(= seconds 6)
			)
			(1
				(Load rsSOUND 993)
				(= register 1)
				(theTitle loop: 0)
				(= seconds 3)
			)
			(2
				(= register 1)
				(= seconds 0)
				(if (IsFlag 359)
					(ClearFlag 359)
					(gGame setCursor: gTheCursor 1 50 150)
				)
				(localproc_0 0)
				(= local2 1)
				(= local0 1)
				(if (< gHowFast 2)
					(fightChar setCel: 1)
					(= ticks 20)
				else
					(fightChar setCycle: End self)
				)
			)
			(3
				(= register 1)
				(= seconds 3)
			)
			(4
				(if (> gHowFast 1)
					(Load rsSOUND 992)
				)
				(= register 2)
				(= seconds 0)
				(localproc_0 1)
				(if (< gHowFast 2)
					(mageChar setCel: 1)
					(= ticks 10)
				else
					(mageChar setCycle: End self)
				)
			)
			(5
				(= register 2)
				(mageChar stopUpd:)
				(gCast eachElementDo: #stopUpd)
				(if (> gHowFast 1)
					(mageArm init: setCycle: End self)
					(gLongSong2 number: 992 setVol: 127 loop: 1 play:)
				else
					(= ticks 20)
				)
			)
			(6
				(= register 2)
				(= seconds 3)
			)
			(7
				(= seconds 0)
				(= register 3)
				(localproc_0 2)
				(= local1 1)
				(if (< gHowFast 2)
					(thiefChar setCel: 1)
					(= ticks 10)
				else
					(Load rsSOUND 109)
					(thiefChar setCycle: End self)
				)
			)
			(8
				(= seconds (= register 3))
			)
			(9
				(= state 1)
				(self cue:)
			)
			(10
				(if
					(or
						(and (== gHeroType 0) (fightChar cycler:)) ; Fighter
						(and (== gHeroType 1) (mageChar cycler:)) ; Magic User
						(and (== gHeroType 2) (thiefChar cycler:)) ; Thief
					)
					0
				else
					(self cue:)
				)
			)
			(11
				(switch (theTitle cel:)
					(0
						(fightChar addToPic:)
					)
					(1
						(mageChar addToPic:)
					)
					(2
						(thiefChar addToPic:)
					)
				)
				(gGame setCursor: gTheCursor 0)
				(SetFlag 359)
				(= cycles 5)
			)
			(12
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= seconds 5)
				(gLongSong2 number: 28 setVol: 127 loop: 1 play:)
			)
			(13
				(gCurRoom newRoom: 203) ; chAlloc
			)
		)
	)
)

