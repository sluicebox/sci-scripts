;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 169)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	hanoi 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 3] = [33 99 168]
	[local9 3] = [42 51 42]
	[local12 3] = [36 45 36]
	[local15 3] = [7 73 141]
	local18 = 32
	[local19 2] = [41 32]
	[local21 3] = [110 119 110]
	[local24 3]
	[local27 3] = [240 248 254]
	[local30 8] = [69 0 0 0 1 2 2 3]
	local38
	[local39 3] = [15 31 127]
)

(instance hanoiWin of SysWindow
	(properties
		top 13
		left 54
		bottom 184
		right 266
		back 53
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 168 0 0 0 21 -1)
	)
)

(instance hanoi of PuzzleBar
	(properties
		puzzleHeight 169
		hintFlag 54
		solvedFlag 4
		noun 6
		personalID 15
	)

	(method (init)
		(= window hanoiWin)
		(= puzzleCast (Set new:))
		(puzzleCast add: disc wedge)
		(= local38 0)
		(= highlightedIcon 0)
		(= showCast 1)
		(for ((= local0 0)) (< local0 3) ((++ local0))
			(self
				add:
					((= [local24 local0] (topdisc new:))
						value: local0
						modifiers: (if local0 0 else [local27 gDifficulty])
						cursor: (if local0 0 else 7)
						yourself:
					)
			)
		)
		(for ((= local0 0)) (< local0 3) ((++ local0))
			(self
				add:
					((pole new:)
						nsTop: [local9 local0]
						nsLeft: [local6 local0]
						nsBottom: (+ [local9 local0] 90)
						nsRight: (+ [local6 local0] 10)
						value: local0
						yourself:
					)
			)
		)
		(LoadMany rsSOUND 106 128 207 104 240 236)
		(super init: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (event type:) $0040) ; direction
			(= temp1
				(if highlightedIcon
					(self indexOf: highlightedIcon)
				else
					0
				)
			)
			(switch (event message:)
				(JOY_UP
					(cond
						((< temp1 3)
							(+= temp1 (- size 3))
						)
						((> temp1 (- size 4))
							(-= temp1 3)
						)
						((not ((self at: (- temp1 3)) cursor:))
							(+= temp1 3)
						)
						(else
							(-= temp1 3)
						)
					)
				)
				(JOY_DOWN
					(cond
						((< temp1 3)
							(+= temp1 3)
						)
						((< temp1 6)
							(+= temp1 3)
						)
						((not ((self at: (- temp1 (- size 3))) cursor:))
							(-= temp1 3)
						)
						(else
							(-= temp1 (- size 3))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((> temp1 (- size 4))
							(if (>= (++ temp1) size)
								(= temp1 (- size 3))
							)
						)
						((> temp1 2)
							(if (> (++ temp1) (- size 4))
								(-= temp1 3)
							)
						)
						(else
							(while (not ((self at: (mod (++ temp1) 3)) cursor:))
							)
							(= temp1 (mod temp1 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((> temp1 (- size 4))
							(if (< (-- temp1) (- size 3))
								(= temp1 (- size 1))
							)
						)
						((> temp1 2)
							(if (< (-- temp1) 3)
								(+= temp1 3)
							)
						)
						(else
							(while
								(not ((self at: (mod (+= temp1 2) 3)) cursor:))
							)
							(= temp1 (mod temp1 3))
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $030f)) ; evJOYUP | evJOYDOWN | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (doit)
		(disc hide:)
		(wedge hide:)
		(super doit: &rest)
	)

	(method (solvePuzzle &tmp temp0 temp1)
		(gCSoundFX number: 106 setVol: 0 play: 127)
		(DrawCel 168 8 0 94 153 -1)
		(Wait 0)
		(cond
			((== local38 [local39 gDifficulty])
				(if (= temp0 (Message msgSIZE 160 6 27 17 1)) ; "Great! You've solved this puzzle with the minimum number of moves which is %d."
					(= temp1 (Memory memALLOC_CRIT (+ temp0 15)))
				)
				(Message msgGET 160 6 27 17 1 temp1) ; "Great! You've solved this puzzle with the minimum number of moves which is %d."
				(proc15_4 self 99 temp1 local38)
			)
			((< (- local38 [local39 gDifficulty]) 10)
				(if (= temp0 (Message msgSIZE 160 6 27 17 2)) ; "Wow! That was close. You solved this puzzle in %d moves. Actually, the minimum number of moves is %d. Perhaps you'd like to make this your goal next time."
					(= temp1 (Memory memALLOC_CRIT (+ temp0 15)))
				)
				(Message msgGET 160 6 27 17 2 temp1) ; "Wow! That was close. You solved this puzzle in %d moves. Actually, the minimum number of moves is %d. Perhaps you'd like to make this your goal next time."
				(proc15_4 self 99 temp1 local38 [local39 gDifficulty])
			)
			(else
				(if (= temp0 (Message msgSIZE 160 6 27 17 3)) ; "Great! You completed this puzzle in %d moves. Next time, you might like to solve this puzzle with fewer moves. In fact, the minimum number of moves is %d."
					(= temp1 (Memory memALLOC_CRIT (+ temp0 15)))
				)
				(Message msgGET 160 6 27 17 3 temp1) ; "Great! You completed this puzzle in %d moves. Next time, you might like to solve this puzzle with fewer moves. In fact, the minimum number of moves is %d."
				(proc15_4 self 99 temp1 local38 [local39 gDifficulty])
			)
		)
		(if temp0
			(Memory memFREE temp1)
		)
		(super solvePuzzle: &rest)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(Say self noun 21 0 0) ; "Count the number of disks in a stack. If this is an odd number, move the top disk to the destination pole (on the far right). If this is an even number, move the top disk to a temporary pole (in the center or on the left)."
		)
	)
)

(instance disc of Actor
	(properties
		x 500
		y 500
		yStep 6
		view 168
		cel 2
		priority 15
		signal 18448
		illegalBits 0
		xStep 6
		moveSpeed 1
	)
)

(instance wedge of View
	(properties
		view 168
		loop 9
		cel 2
		priority 15
		signal 18456
	)

	(method (doit)
		(if (disc script:)
			(if (<= (disc y:) (+ [local9 local1] 5))
				(wedge
					cel: 1
					x: (+ (disc x:) 30)
					y: (+ (disc y:) [local30 (disc loop:)])
					show:
				)
			else
				(wedge hide:)
			)
		)
	)
)

(instance topdisc of CodeIcon
	(properties
		view 168
		cursor 0
		upClick 240
	)

	(method (highlight param1 &tmp temp0)
		(if (== modifiers [local27 2])
			(= temp0 1)
		else
			(= temp0 0)
		)
		(cond
			((disc script:))
			(param1
				(DrawCel view loop 0 nsLeft nsTop -1)
				(if temp0
					(DrawCel view 9 0 (+ nsLeft 30) (+ nsTop [local30 7]) -1)
				)
			)
			((== local4 self)
				(DrawCel view loop 1 nsLeft nsTop -1)
				(if temp0
					(DrawCel view 9 1 (+ nsLeft 30) (+ nsTop [local30 7]) -1)
				)
			)
			(else
				(DrawCel view loop 2 nsLeft nsTop -1)
				(if temp0
					(DrawCel view 9 2 (+ nsLeft 30) (+ nsTop [local30 7]) -1)
				)
			)
		)
	)

	(method (select param1 &tmp [temp0 2] temp2)
		(cond
			((not (super select: &rest)) 0)
			((not local4)
				(= cel 1)
				(= local4 self)
				(DrawCel view loop cel nsLeft nsTop -1)
			)
			((== local4 self)
				(= local4 (= cel 0))
				(DrawCel view loop cel nsLeft nsTop -1)
			)
			(else
				(= temp2 local4)
				(= local4 self)
				(= cel 1)
				(temp2 cel: 2 highlight: 0)
				(DrawCel view loop cel nsLeft nsTop -1)
			)
		)
	)

	(method (show &tmp temp0 [temp1 2] temp3)
		(= temp3 (if argc argc else 0))
		(= nsLeft [local15 value])
		(= nsTop [local21 value])
		(if (or cursor temp3)
			(= cursor 0)
			(if temp3
				(PicNotValid 1)
				(DrawCel view 11 value [local15 value] [local12 value] -1)
			)
			(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
				(if (& (<< $0001 temp0) modifiers)
					(DrawCel 168 temp0 2 nsLeft nsTop -1)
					(-= nsTop 13)
					(= cursor temp0)
				)
			)
			(= loop cursor)
			(+= nsTop 13)
			(= nsRight (+ nsLeft 61))
			(= nsBottom (+ nsTop 20))
			(if (== modifiers [local27 2])
				(self highlight: 0)
			)
			(PicNotValid 0)
		else
			(= nsRight -100)
		)
	)

	(method (onMe)
		(if (not cursor)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (mask))
)

(instance pole of CodeIcon
	(properties
		downClick 0
		upClickOff 0
	)

	(method (show))

	(method (highlight))

	(method (select &tmp temp0)
		(= local5 value)
		(cond
			((not (super select: &rest)) 0)
			((not local4)
				(gMessager say: 25 4 16) ; "You must first select a disk (from the top of a stack) before selecting a pole."
			)
			(else
				(if
					(and
						([local24 value] modifiers:)
						(> ([local24 value] modifiers:) (local4 modifiers:))
					)
					(= temp0 1)
				else
					(= temp0 0)
				)
				(= local3 (local4 value:))
				(wedge show:)
				(disc
					loop: (local4 loop:)
					x: (+ (local4 nsLeft:) 54)
					y: (+ (local4 nsTop:) 15)
					show:
					setScript: moveDisc 0 temp0
				)
			)
		)
	)
)

(instance moveDisc of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(++ local38)
				(hanoi pHandsOff: 1)
				(= local1 local3)
				(= local2 (local4 cursor:))
				(local4
					modifiers: (& (local4 modifiers:) (~ (<< $0001 local2)))
					show: 1
				)
				(client setMotion: MoveTo (+ [local15 local3] 54) local18 self)
			)
			(1
				(client setMotion: MoveTo (+ [local15 local5] 54) local18 self)
			)
			(2
				(= local1 local5)
				(if register
					(client
						setMotion:
							MoveTo
							(+ [local15 local5] 54)
							(- (- (+ ([local24 local5] nsTop:) 13) 13) 6)
							self
					)
				else
					(client
						setMotion:
							MoveTo
							(+ [local15 local5] 54)
							(- (+ ([local24 local5] nsTop:) 15) 13)
							self
					)
				)
			)
			(3
				(if register
					(gCSoundFX number: 136 setLoop: 0 play:)
					(client setScript: moveDiscBack)
				else
					(gCSoundFX number: 128 setLoop: 1 play:)
					(= temp1 [local24 local5])
					(temp1
						modifiers: (| (temp1 modifiers:) (<< $0001 local2))
						cursor: local2
					)
					(temp1 show:)
					(disc hide:)
					(if (== ([local24 2] modifiers:) [local27 gDifficulty])
						(hanoi animateOnce:)
						(hanoi solvePuzzle:)
					)
					(= local4 0)
					(hanoi pHandsOff: 0)
					(client hide:)
					(wedge hide:)
					(self dispose:)
				)
			)
		)
	)
)

(instance moveDiscBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(hanoi pHandsOff: 1)
				(client setMotion: MoveTo (+ [local15 local5] 54) local18 self)
			)
			(1
				(client setMotion: MoveTo (+ [local15 local3] 54) local18 self)
			)
			(2
				(= local1 local3)
				(client
					setMotion:
						MoveTo
						(+ [local15 local3] 54)
						(- (+ (local4 nsTop:) 15) 13)
						self
				)
			)
			(3
				(local4
					modifiers: (| (local4 modifiers:) (<< $0001 local2))
					cursor: local2
					show:
				)
				(= local4 0)
				(hanoi pHandsOff: 0)
				(client hide:)
				(wedge hide:)
				(self dispose:)
			)
		)
	)
)

