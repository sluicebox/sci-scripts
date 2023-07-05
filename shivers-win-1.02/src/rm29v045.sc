;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29045)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Jump)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	rm29v045 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
)

(instance rm29v045 of ShiversRoom
	(properties
		picture 29042
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= local4 (IntArray newWith: 12))
		(= local5 (IntArray newWith: 4))
		(= local1 -1)
		(= local0 -1)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(local5
				at:
					temp0
					((View new:)
						view: 29042
						loop: temp0
						setPri: 7 1
						init:
						hide:
						yourself:
					)
			)
		)
		(if (or (== gPrevRoomNum 990) (== gPrevRoomNum 992)) ; shiversOptions, viewingInv
			(= temp6 (File new:))
			(temp6 name: {shiversp.tmp})
			(PrintDebug {name:%s} (temp6 name:))
			(temp6 open: 1)
			(for ((= temp0 0)) (< temp0 12) ((++ temp0))
				(local4
					at:
						temp0
						((saButton new:)
							loop: (temp6 readWord:)
							setPos: (temp6 readWord:)
							init:
							yourself:
						)
				)
			)
			(temp6 close:)
		else
			(= temp2 (+ 5 (* (Random 0 1) 2)))
			(= temp1 (Random 0 11))
			(for ((= temp0 0)) (< temp0 12) ((++ temp0))
				(= temp3 (mod (+ temp1 (* temp0 temp2)) 12))
				(local4
					at:
						temp0
						((saButton new:)
							loop: temp0
							setPos: temp3
							init:
							yourself:
						)
				)
			)
		)
		(for ((= temp4 0)) (< temp4 4) ((++ temp4))
			(= temp7 1)
			(for ((= temp5 0)) (< temp5 3) ((++ temp5))
				(= temp0 (+ temp5 (* temp4 3)))
				(if (!= ((local4 at: temp0) pos:) temp0)
					(= temp7 0)
					(PrintDebug {wrong: %d} temp0)
					(break)
				)
			)
			(if temp7
				((local5 at: temp4) show:)
				(gSounds play: 12911 0 82 0)
			else
				((local5 at: temp4) hide:)
			)
		)
		(efExitLeft init: 8)
		(efExitRight init: 8)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber &tmp temp0 temp1 temp2)
		(if (or (== newRoomNumber 990) (== newRoomNumber 992)) ; shiversOptions, viewingInv
			(= temp2 (File new:))
			(temp2 name: {shiversp.tmp})
			(PrintDebug {name: %s} (temp2 name:))
			(temp2 open: 2)
			(for ((= temp0 0)) (< temp0 12) ((++ temp0))
				(= temp1 (local4 at: temp0))
				(temp2 writeWord: (temp1 loop:))
				(temp2 writeWord: (temp1 pos:))
			)
			(temp2 close:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(class saButton of Actor
	(properties
		priority 10
		fixPriority 1
		view 29040
		signal 18433
		pos 0
	)

	(method (init)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (setPos param1 &tmp temp0 temp1)
		(= temp0 (/ (= pos param1) 3))
		(= temp1 (mod param1 3))
		(= x (+ 63 (* temp1 36)))
		(= y (+ 27 (* temp0 30)))
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
			)
			(event claimed: 1)
			(self doVerb:)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(= local0 local1)
		(if (== (= local1 loop) local0)
			(PrintDebug {unselect:%d} loop)
			(= local1 -1)
			(= local0 -1)
			(gSounds play: 12904 0 82 0)
			(self setCycle: Beg setPri: 10 1)
		else
			(PrintDebug {select:%d} loop)
			(if (!= local0 -1)
				(gCurRoom setScript: sSwap)
			else
				(gSounds play: 12902 0 82 0)
				(self setCycle: End setPri: 125 1)
			)
		)
	)
)

(instance sSwap of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 12902)
				((local4 at: local1) setCycle: End self setPri: 125 1)
				(gSounds play: 12902 0 82 0)
			)
			(1
				(= temp2 ((local4 at: local0) pos:))
				(= temp5 (/ ((local4 at: local1) pos:) 3))
				(= temp6 (mod ((local4 at: local1) pos:) 3))
				(= temp0 (+ 63 (* temp6 36)))
				(= temp1 (+ 27 (* temp5 30)))
				((local4 at: local0)
					pos: ((local4 at: local1) pos:)
					setPri: 100 1
					setMotion: JumpTo temp0 (- temp1 5) self
				)
				(= temp5 (/ temp2 3))
				(= temp6 (mod temp2 3))
				(= temp0 (+ 63 (* temp6 36)))
				(= temp1 (+ 27 (* temp5 30)))
				((local4 at: local1)
					pos: temp2
					setMotion: JumpTo temp0 (- temp1 5) self
				)
				(gSounds play: 12903 0 82 0)
			)
			(2)
			(3
				((local4 at: local0)
					setPos: ((local4 at: local0) pos:)
					setMotion: 0
				)
				((local4 at: local1)
					setPos: ((local4 at: local1) pos:)
					setMotion: 0
				)
				(= cycles 1)
			)
			(4
				((local4 at: local1) setCycle: Beg self setPri: 10 1)
				((local4 at: local0) setCycle: Beg setPri: 10 1)
				(gSounds play: 12904 0 82 0)
			)
			(5
				(= temp3 1)
				(for ((= temp5 0)) (< temp5 4) ((++ temp5))
					(= temp7 1)
					(for ((= temp6 0)) (< temp6 3) ((++ temp6))
						(= temp4 (+ temp6 (* temp5 3)))
						(if (!= ((local4 at: temp4) pos:) temp4)
							(= temp3 0)
							(= temp7 0)
							(PrintDebug {wrong: %d} temp4)
							(break)
						)
					)
					(if temp7
						(if (not ((local5 at: temp5) isNotHidden:))
							(gSounds play: 12911 0 82 0)
						)
						((local5 at: temp5) show:)
					else
						((local5 at: temp5) hide:)
					)
				)
				(= local0 -1)
				(= local1 -1)
				(if (== temp3 1)
					(SetFlag 68)
					(proc951_15 6750)
					(FrameOut)
					(= seconds 3)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(6
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 29040)
				((Prop new:)
					view: 29041
					setPri: 25 1
					cel: 5
					cycleSpeed: 3
					setCycle: Beg
					init:
				)
				(FrameOut)
				(gSounds play: 12910 0 82 self)
			)
			(7
				(gGame handsOn:)
				(gCurRoom newRoom: 29030) ; rm29v030
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29040
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29040
	)

	(method (init)
		(self createPoly: 240 0 262 0 262 144 240 144 240 0)
		(super init: &rest)
	)
)

