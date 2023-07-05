;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	proc301_0 0
)

(local
	local0
)

(procedure (proc301_0)
	(gCurRoom setScript: flyIn)
)

(instance guard1 of Actor
	(properties
		yStep 8
		signal 24576
		cycleSpeed 3
		illegalBits 0
		xStep 12
	)
)

(instance guard2 of Actor
	(properties
		yStep 8
		signal 24576
		cycleSpeed 3
		illegalBits 0
		xStep 12
	)
)

(instance dummyEgo of Actor
	(properties)
)

(instance flyIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(gTheIconBar disable:)
				(dummyEgo
					view: 3511
					setStep: 12 8
					ignoreHorizon: 1
					posn: 340 -40
					init:
					setCycle: Fwd
					setMotion: MoveTo 228 56 self
				)
			)
			(1
				(dummyEgo view: 3512 cel: 0 posn: 195 91 setCycle: End self)
				(UnLoad 128 3511)
			)
			(2
				(UnLoad 128 3512)
				(guard1 view: 3013 loop: 0 cel: 1 posn: 169 128 init: stopUpd:)
				(guard2
					view: 3013
					loop: 0
					cel: 0
					posn: 173 132
					setPri: (- (guard1 priority:) 2)
					init:
					stopUpd:
				)
				(gEgo
					reset: 1
					cel: 4
					posn: 162 129
					setPri: (- (guard1 priority:) 1)
					show:
					setMotion: MoveTo 145 129 self
				)
				(dummyEgo dispose:)
				(gGlobalSound fade:)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(guard1
					view: 344
					loop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (guard1 x:) 15) (guard1 y:)
				)
				(guard2
					view: 343
					loop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (guard2 x:) 15) (guard2 y:) self
				)
			)
			(5
				(gGlobalSound
					number: 915
					setLoop: -1
					setVol: 0
					play:
					fade: 127 10 10
				)
				(gEgo setHeading: 90 self)
			)
			(6
				(gEgo view: 3013 loop: 0 cel: 2)
				(UnLoad 128 900)
				(= cycles 8)
			)
			(7
				(guard1 view: 349 loop: 0 cel: 0 setCycle: End)
				(UnLoad 128 344)
				(guard2 view: 348 loop: 0 cel: 0 setCycle: End self)
				(UnLoad 128 343)
			)
			(8
				(guard1
					view: 3491
					loop: 0
					cel: 0
					posn: 195 74
					setCycle: Fwd
					setStep: 12 8
					cycleSpeed: 3
					setMotion: MoveTo 345 -15 self
				)
				(UnLoad 128 349)
				(guard2
					view: 3481
					loop: 0
					cel: 0
					posn: 219 80
					setCycle: Fwd
					setStep: 12 8
					cycleSpeed: 3
					setMotion: MoveTo 375 -15
				)
				(UnLoad 128 348)
			)
			(9
				(if (not (== gPrevRoomNum 380))
					(Cursor showCursor: 1)
				)
				(gEgo reset: 0)
				(guard1 setCycle: 0 setMotion: 0 delete: dispose:)
				(guard2 setCycle: 0 setMotion: 0 delete: dispose:)
				(gTheIconBar enable:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

