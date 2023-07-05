;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
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
	local4
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
)

(procedure (localproc_0)
	(HandsOff)
	(gCurRoom newRoom: 203) ; chAlloc
)

(procedure (localproc_1)
	(switch local11
		(1
			(local13 setCel: 0 posn: 64 127 stopUpd:)
			(mageScript changeState: 0)
			(thiefScript changeState: 0)
			(fighterScript changeState: 1)
		)
		(2
			(local13 setCel: 0 posn: 158 127 stopUpd:)
			(fighterScript changeState: 0)
			(thiefScript changeState: 0)
			(if local16
				(local1 setLoop: 1 setCel: 3)
				(local2 show:)
			else
				(mageScript changeState: 1)
			)
		)
		(3
			(local13 setCel: 0 posn: 252 127 stopUpd:)
			(fighterScript changeState: 0)
			(mageScript changeState: 0)
			(thiefScript changeState: 1)
		)
	)
)

(procedure (localproc_2)
	(switch local11
		(1
			(= gHeroType 0) ; Fighter
			(localproc_0)
		)
		(2
			(= gHeroType 1) ; Magic User
			(localproc_0)
		)
		(3
			(= gHeroType 2) ; Thief
			(localproc_0)
		)
	)
)

(instance selChar of Rm
	(properties
		picture 905
		style 8
	)

	(method (init)
		(Load rsSOUND (SoundFX 73))
		(User canInput: 0)
		((= local13 (View new:))
			view: 506
			setLoop: 0
			setCel: 0
			posn: 0 1000
			setPri: 5
			init:
			ignoreActors:
			stopUpd:
		)
		((= local0 (Prop new:))
			view: 505
			setPri: 5
			init:
			ignoreActors:
			stopUpd:
			setScript: fighterScript
		)
		((= local2 (Prop new:))
			view: 505
			setLoop: 3
			setCel: 0
			posn: 158 84
			setPri: 6
			init:
			ignoreActors:
		)
		((= local1 (Prop new:))
			view: 505
			setPri: 5
			init:
			ignoreActors:
			stopUpd:
			setScript: mageScript
		)
		((= local3 (Prop new:))
			view: 505
			setPri: 5
			init:
			ignoreActors:
			stopUpd:
			setScript: thiefScript
		)
		((= local4 (View new:))
			view: 506
			setLoop: 1
			setCel: 0
			posn: 83 25
			init:
			ignoreActors:
			stopUpd:
		)
		((= local5 (View new:))
			view: 506
			setLoop: 1
			setCel: 1
			posn: 146 27
			init:
			ignoreActors:
			stopUpd:
		)
		((= local6 (View new:))
			view: 506
			setLoop: 1
			setCel: 2
			posn: 220 27
			init:
			ignoreActors:
			stopUpd:
		)
		((= local7 (View new:))
			view: 506
			setLoop: 1
			setCel: 3
			posn: 65 155
			init:
			ignoreActors:
			stopUpd:
		)
		((= local8 (View new:))
			view: 506
			setLoop: 1
			setCel: 4
			posn: 159 147
			init:
			ignoreActors:
			stopUpd:
		)
		((= local9 (View new:))
			view: 506
			setLoop: 1
			setCel: 6
			posn: 161 163
			init:
			ignoreActors:
			stopUpd:
		)
		((= local10 (View new:))
			view: 506
			setLoop: 1
			setCel: 5
			posn: 252 153
			init:
			ignoreActors:
			stopUpd:
		)
		(self setScript: selScript)
		(super init:)
		(gMouseHandler add: self)
		(gKeyHandler add: self)
		(gDirHandler add: self)
		(if (or (== (gContMusic state:) 0) (!= (gContMusic number:) (SoundFX 61)))
			(gContMusic number: (SoundFX 73) loop: -1 play:)
		)
		(gContMusic prevSignal: 0)
		(Joystick 12 30)
	)

	(method (dispose)
		(Joystick 12 0)
		(super dispose:)
	)

	(method (doit)
		(cond
			(
				(and
					local17
					(or
						(== (gContMusic signal:) 2)
						(== (gContMusic prevSignal:) 2)
					)
				)
				(= local17 0)
				(gContMusic stop:)
				(gContMusic number: (SoundFX 73) loop: -1 play:)
			)
			((and local15 (== (gContMusic prevSignal:) 3))
				(gContMusic prevSignal: 0)
				(if (== local11 3)
					(= local11 1)
				else
					(++ local11)
				)
				(= local14 0)
				(localproc_1)
			)
			(local16
				(= local16 0)
				(localproc_2)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 60])
		(if local14
			(if (== (event type:) evKEYBOARD)
				(= local15 0)
				(switch (event message:)
					(KEY_TAB
						(event type: $0040) ; direction
						(event message: JOY_RIGHT)
					)
					(KEY_SHIFTTAB
						(event type: $0040) ; direction
						(event message: JOY_LEFT)
					)
					(KEY_RETURN
						(event claimed: 1)
						(= local16 1)
					)
				)
			)
			(switch (event type:)
				(evMOUSEBUTTON
					(= temp1 (event x:))
					(= temp2 (event y:))
					(= temp0 (OnControl CONTROL temp1 temp2))
					(= local15 0)
					(event claimed: 1)
					(cond
						((& temp0 $4000)
							(= local11 1)
							(= local16 1)
						)
						((& temp0 $2000)
							(= local11 2)
							(= local16 1)
						)
						((& temp0 $1000)
							(= local11 3)
							(= local16 1)
						)
						(else
							(event claimed: 0)
						)
					)
					(event claimed: 1)
					(= local14 0)
					(localproc_1)
				)
				($0040 ; direction
					(switch (event message:)
						(JOY_LEFT
							(if (== local11 1)
								(= local11 3)
							else
								(-- local11)
							)
						)
						(JOY_RIGHT
							(if (== local11 3)
								(= local11 1)
							else
								(++ local11)
							)
						)
					)
					(event claimed: 1)
					(= local15 0)
					(= local14 0)
					(localproc_1)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance fighterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= cycles 0))
				(local0 setLoop: 4 setCel: 0 posn: 64 117)
			)
			(1
				(= seconds (= cycles 0))
				(= local11 1)
				(local0 setLoop: 0 setCel: 1)
				(= local14 1)
				(= cycles 5)
			)
			(2
				(local0 setCel: 0)
				(= cycles 5)
			)
			(3
				(fighterScript changeState: 1)
			)
		)
	)
)

(instance mageScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= cycles 0))
				(local1 setLoop: 4 setCel: 1 posn: 158 117)
				(local2 stopUpd: hide:)
			)
			(1
				(= seconds (= cycles 0))
				(= local11 2)
				(local1 setLoop: 1 setCel: 0)
				(= local14 1)
				(= cycles 3)
			)
			(2
				(local1 setCel: -1 setCycle: End self)
			)
			(3
				(local2 show: setCycle: Fwd startUpd:)
				(= seconds 3)
			)
			(4
				(self changeState: 3)
			)
		)
	)
)

(instance thiefScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= cycles 0))
				(local3 setLoop: 4 setCel: 2 posn: 252 117)
			)
			(1
				(= seconds (= cycles 0))
				(= local11 3)
				(local3 setLoop: 2 setCel: 0)
				(= local14 1)
				(= seconds 2)
			)
			(2
				(local3 setCel: -1 setCycle: End)
				(= seconds 2)
			)
			(3
				(local3 setCycle: Beg self)
			)
			(4
				(thiefScript changeState: 1)
			)
		)
	)
)

(instance selScript of Script
	(properties)

	(method (doit)
		(if (and (== state 3) (not local15) (== (gContMusic prevSignal:) 3))
			(gContMusic prevSignal: 0)
			(= local14 1)
			(= local15 1)
			(fighterScript changeState: 1)
			(self dispose:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(++ local12)
				(local4 hide:)
				(local5 hide:)
				(local6 hide:)
				(= cycles 3)
			)
			(2
				(local4 show:)
				(local5 show:)
				(local6 show:)
				(= cycles 3)
			)
			(3
				(gContMusic prevSignal: 0)
				(if (< local12 2)
					(self changeState: 1)
				)
			)
		)
	)
)

