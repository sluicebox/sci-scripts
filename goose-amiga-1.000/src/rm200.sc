;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	local0 = 1
	local1 = 85
	local2 = 99
)

(instance rm200 of Rm
	(properties
		picture 300
		style 0
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(= global103 0)
		(Load rsVIEW 200)
		(super init:)
		(TheMenuBar state: 0)
		(k1 init:)
		(k2 init:)
		(k3 init:)
		(k4 init:)
		(k5 init:)
		(k6 init:)
		(k7 init:)
		(k8 init:)
		(frameOutline init: setLoop: 4)
		(self setScript: rmScript)
		(= global210 0)
		(if global131
			(gGame setSpeed: 6)
		else
			(gGame setSpeed: 4)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or global102 (event claimed:))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((<= 68 (event x:) 102)
						(cond
							((<= 64 (event y:) 106)
								(= local1 85)
								(= local2 99)
								(if (== local0 1)
									(self newRoom:)
								else
									(= local0 1)
								)
							)
							((<= 119 (event y:) 161)
								(= local1 85)
								(= local2 154)
								(if (== local0 5)
									(self newRoom:)
								else
									(= local0 5)
								)
							)
							(else
								(return)
							)
						)
					)
					((<= 118 (event x:) 152)
						(cond
							((<= 64 (event y:) 106)
								(= local1 135)
								(= local2 99)
								(if (== local0 2)
									(self newRoom:)
								else
									(= local0 2)
								)
							)
							((<= 119 (event y:) 161)
								(= local1 135)
								(= local2 154)
								(if (== local0 6)
									(self newRoom:)
								else
									(= local0 6)
								)
							)
							(else
								(return)
							)
						)
					)
					((<= 168 (event x:) 202)
						(cond
							((<= 64 (event y:) 106)
								(= local1 185)
								(= local2 99)
								(if (== local0 3)
									(self newRoom:)
								else
									(= local0 3)
								)
							)
							((<= 119 (event y:) 161)
								(= local1 185)
								(= local2 154)
								(if (== local0 7)
									(self newRoom:)
								else
									(= local0 7)
								)
							)
							(else
								(return)
							)
						)
					)
					((<= 208 (event x:) 252)
						(cond
							((<= 64 (event y:) 106)
								(= local1 235)
								(= local2 99)
								(if (== local0 4)
									(self newRoom:)
								else
									(= local0 4)
								)
							)
							((<= 119 (event y:) 161)
								(= local1 235)
								(= local2 154)
								(if (== local0 8)
									(self newRoom:)
								else
									(= local0 8)
								)
							)
							(else
								(return)
							)
						)
					)
					(else
						(return)
					)
				)
				(frameOutline posn: local1 local2)
			)
			(evKEYBOARD
				(cond
					((== (event message:) KEY_F2)
						(event claimed: 0)
					)
					((not (self script:))
						(self newRoom:)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if (> local0 4)
							(= local1 (frameOutline x:))
							(-= local2 55)
							(-= local0 4)
							(gCurRoom setScript: frameScript)
						)
					)
					(JOY_DOWN
						(if (< local0 5)
							(= local1 (frameOutline x:))
							(+= local2 55)
							(+= local0 4)
							(gCurRoom setScript: frameScript)
						)
					)
					(JOY_RIGHT
						(if (and (!= local0 4) (!= local0 8))
							(= local2 (frameOutline y:))
							(+= local1 50)
							(+= local0 1)
							(gCurRoom setScript: frameScript)
						)
					)
					(JOY_LEFT
						(if (and (!= local0 1) (!= local0 5))
							(= local2 (frameOutline y:))
							(-= local1 50)
							(-= local0 1)
							(gCurRoom setScript: frameScript)
						)
					)
				)
			)
		)
	)

	(method (newRoom)
		(clr)
		(gGlobalMGSound priority: 5 fade:)
		(RedrawCast)
		(RedrawCast)
		(RedrawCast)
		(RedrawCast)
		(RedrawCast)
		(= global114 (- local0 1))
		(gEgo view: (- local0 1))
		(= global117
			(switch global114
				(0 19)
				(1 27)
				(2 21)
				(3 29)
				(4 23)
				(5 31)
				(6 25)
				(7 33)
			)
		)
		(User canControl: 0)
		(TheMenuBar hide:)
		(SL disable:)
		(gCurRoom drawPic: 0 8)
		(++ global197)
		(super newRoom: 201)
	)
)

(instance fr1 of View ; UNUSED
	(properties
		x 85
		y 99
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f2 of View ; UNUSED
	(properties
		x 135
		y 99
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f3 of View ; UNUSED
	(properties
		x 185
		y 99
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f4 of View ; UNUSED
	(properties
		x 235
		y 99
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f5 of View ; UNUSED
	(properties
		x 85
		y 154
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f6 of View ; UNUSED
	(properties
		x 135
		y 154
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f7 of View ; UNUSED
	(properties
		x 185
		y 154
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance f8 of View ; UNUSED
	(properties
		x 235
		y 154
		view 200
		priority 4
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k1 of View
	(properties
		x 85
		y 96
		view 200
		loop 2
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k2 of View
	(properties
		x 135
		y 96
		view 200
		loop 2
		cel 1
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k3 of View
	(properties
		x 185
		y 96
		view 200
		loop 2
		cel 2
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k4 of View
	(properties
		x 235
		y 96
		view 200
		loop 2
		cel 3
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k5 of View
	(properties
		x 85
		y 151
		view 200
		loop 2
		cel 4
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k6 of View
	(properties
		x 135
		y 151
		view 200
		loop 2
		cel 5
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k7 of View
	(properties
		x 185
		y 151
		view 200
		loop 2
		cel 6
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance k8 of View
	(properties
		x 235
		y 151
		view 200
		loop 2
		cel 7
		priority 5
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance frameOutline of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 200
			setLoop: 1
			illegalBits: 0
			ignoreActors: 1
			posn: 85 99
			setStep: 8 6
			setPri: 15
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(GetSaveFiles (gGame name:) @global371 @global520)
				(User canInput: 1)
				(= cycles 2)
			)
			(1
				(if
					(<
						(= global107
							(GetInput
								@global210
								10
								{What is your name?\n}
								67
								-1
								10
							)
						)
						1
					)
					(StrCpy @global210 {Chris})
				)
				(RedrawCast)
				(HandsOn)
				(Print
					(Format @global270 {%s, please choose your kid.} @global210)
					#at
					-1
					10
					#mode
					1
					#dispose
				)
				(= seconds global120)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance frameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frameOutline posn: local1 local2)
				(= cycles 1)
			)
			(1
				(gCurRoom setScript: 0)
			)
		)
	)
)

