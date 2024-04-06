;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64911)
(include sci.sh)
(use Main)
(use Interface)
(use DText)
(use System)

(class DButton of DText
	(properties
		state 3
		fore 255
		back 0
		font 0
		hiliteColor -1
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if (& state $0001)
			(if
				(or
					(and
						(== (= temp1 (event type:)) evKEYBOARD)
						(== (event message:) key)
					)
					(and (== temp1 evMOUSEBUTTON) (self onMe: event))
				)
				(event claimed: 1)
				(= temp0 (self track: event))
			else
				(self onMe: event)
			)
		)
		(return temp0)
	)

	(method (init)
		(if (!= view -1)
			(= borderColor -1)
			(= back skip)
		)
		(super init: &rest)
	)

	(method (onMe)
		(if (super onMe: &rest)
			(if (!= global118 self)
				(= global118 self)
				(if global161
					(gTheCursor
						view: (global161 hiliteView:)
						loop: (global161 loop:)
						cel: (global161 cel:)
					)
				else
					(gTheCursor loop: 0 cel: 0)
				)
				(gTheCursor init:)
			)
			(return 1)
		else
			(if (== global118 self)
				(= global118 0)
				(if global161
					(gTheCursor
						view: (global161 loliteView:)
						loop: (global161 loop:)
						cel: (global161 cel:)
					)
				else
					(gTheCursor loop: 0 cel: 1)
				)
				(gTheCursor init:)
			)
			(return 0)
		)
	)

	(method (dispose)
		(if (== global118 self)
			(= global118 0)
			(if global161
				(gTheCursor
					view: (global161 loliteView:)
					loop: (global161 loop:)
					cel: (global161 cel:)
				)
			else
				(gTheCursor loop: 0 cel: 1)
			)
			(gTheCursor init:)
		)
		(super dispose: &rest)
	)

	(method (hilite bool &tmp temp0 temp1)
		(= temp1 -1)
		(= temp0 fore)
		(if (and argc bool)
			(&= state $fff7)
			(cond
				((!= view -1)
					(= cel 0)
				)
				((!= hiliteColor -1)
					(= temp0 fore)
					(= fore hiliteColor)
					(if (!= borderColor -1)
						(= temp1 borderColor)
						(= borderColor hiliteColor)
					)
				)
			)
		else
			(&= state $fff7)
			(cond
				((!= view -1)
					(= cel 1)
				)
				((!= hiliteColor -1)
					(= fore temp0)
				)
			)
		)
		(self draw:)
		(UpdateScreenItem self)
		(FrameOut)
		(if (!= hiliteColor -1)
			(if (== fore hiliteColor)
				(= fore temp0)
			)
			(if (== borderColor hiliteColor)
				(= borderColor temp1)
			)
		)
	)

	(method (draw)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)

	(method (track event &tmp in lastIn)
		(if (== 1 (event type:))
			(= lastIn 0)
			(repeat
				(= event (Event new: 32768))
				(event localize: plane)
				(if (!= (= in (self onMe: event)) lastIn)
					(if in
						(= cel 2)
						(++ textTop)
						(++ textBottom)
					else
						(= cel 0)
						(-- textTop)
						(-- textBottom)
					)
					(self hilite: 1)
					(= lastIn in)
				)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(self hilite: 0)
			(if in
				(-- textTop)
				(-- textBottom)
			)
			(return (if in self else 0))
		else
			(return self)
		)
	)
)

