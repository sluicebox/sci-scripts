;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local0 0)
				(gEgo setMotion: MoveTo 143 125 self)
			)
			(1
				(proc0_9)
				(global110 hide:)
				(global109
					setLoop: 6 1
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
				(gEgo setMotion: MoveTo 120 151)
			)
			(2
				(proc0_7 gEgo global109)
				(global109 setLoop: 7 1 cel: 0 setCycle: End self)
			)
			(3
				(girl
					init:
					setLoop: 11 1
					setCycle: Fwd
					setMotion: MoveTo 158 135 self
				)
				(boy1
					init:
					setLoop: 1 1
					setCycle: Fwd
					setMotion: MoveTo 176 126 self
				)
				(boy2
					init:
					setLoop: 4 1
					setCycle: Fwd
					setMotion: MoveTo 130 140 self
				)
			)
			(4
				(boy1 setLoop: 2 1 cel: 0)
			)
			(5
				(girl setLoop: 12 1 cel: 0)
			)
			(6
				(boy2 setLoop: 5 1 cel: 0)
				(gLongSong stop:)
				(= seconds 2)
			)
			(7
				(global109 cycleSpeed: 10 setLoop: 8 1 setScript: bodyMotion)
				(global110 doit:)
				(global110 show: cycleSpeed: 5 setScript: headMotion)
				(note1 init: hide: setScript: noteMotion)
				(gMessager say: 1 0 0 11 0 400) ; "LITTLE TOMMY TUCKER"
				(rhymeSync init: 400 1 0 0 11)
				(= cycles 1)
			)
			(8
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format:
									{El peque+o Tom Tucker canta por su cena.}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format:
									{Little Tommy Tucker sings for his supper.}
							)
						)
					)
				)
				(= cycles 1)
			)
			(9
				(headMotion cue:)
				(noteMotion cue:)
				(note1 show:)
				(= cycles 1)
			)
			(10
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0 format: {/Qu$ comer# $l? Pan y mantequilla.})
						)
					)
					(else
						(proc0_16
							(temp0
								format:
									{What will he eat? White bread and butter.}
							)
						)
					)
				)
				(= cycles 1)
			)
			(11
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format: {/C&mo lo ir# a cortar sin un cuchillo?}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format:
									{How will he cut it without ever a knife?}
							)
						)
					)
				)
				(= cycles 1)
			)
			(12
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format: {/C&mo puede casarse sin una esposa?}
							)
						)
					)
					(else
						(proc0_16
							(temp0 format: {How can he marry without a wife?})
						)
					)
				)
				(= cycles 1)
			)
			(13
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(global110 setScript: 0 cel: 0 hide:)
					(global109
						setScript: 0
						setLoop: 9 1
						cel: 0
						setCycle: End self
					)
					(note1 setScript: 0 dispose:)
					(proc0_10)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(14
				(global109 setCycle: Beg)
				(boy1 setCycle: Fwd setLoop: 0 1 setMotion: MoveTo 250 125)
				(boy2 setCycle: Fwd setLoop: 3 1 setMotion: MoveTo 250 138 self)
			)
			(15
				(global109 setLoop: 7 1 cel: 5 setCycle: Beg self)
			)
			(16
				(global109 setLoop: 6 1 cel: 8 setCycle: Beg self)
			)
			(17
				(global109 setLoop: 0 1 cel: 8)
				(global110 show:)
				(girl
					setCycle: Fwd
					setLoop: 10 1
					setMotion: MoveTo 250 135 self
				)
			)
			(18
				(girl dispose:)
				(boy1 dispose:)
				(boy2 dispose:)
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local0 1)
			)
		)
		(temp0 dispose:)
		(if local0
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance headMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(-- state)
				(global110 setLoop: (Random 1 4) 1 cel: 0 setCycle: End self)
			)
		)
	)
)

(instance noteMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(note1
					setPri: 14
					cel:
						(cond
							((Random 0 1) 3)
							((Random 0 1) 5)
							(else 6)
						)
					posn: (Random 130 160) (Random 70 80)
					show:
				)
				(= cycles (Random 14 30))
			)
			(2
				(= state 0)
				(note1 hide:)
				(= cycles (Random 8 21))
			)
		)
	)
)

(instance bodyMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 8 1 setCycle: End)
				(= seconds 1)
			)
			(1
				(client setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance boy1 of Actor
	(properties
		x 260
		y 125
		view 87
		loop 1
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance girl of Actor
	(properties
		x 255
		y 135
		view 85
		loop 11
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance boy2 of Actor
	(properties
		x 270
		y 135
		view 87
		loop 4
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
	)
)

(instance note1 of Prop
	(properties
		x 143
		y 122
		view 85
		cel 2
	)

	(method (init)
		(super init:)
		(self setLoop: 0 1)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

