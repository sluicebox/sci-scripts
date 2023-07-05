;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use PolyPath)
(use Sound)
(use Motion)

(public
	enterNoStory 0
	storyIntro 1
	storyWrap 2
	dogGo 3
	openDoor 4
	begGame 5
)

(instance enterNoStory of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(switch global141
					(0
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 0) ; bookWyrm
					)
					(1
						(proc10_13 2 (ScriptID 230 2) gEgo -1 0 232 1) ; bookWyrm
						(proc10_13 2 (ScriptID 230 2) gEgo self 1 232 2) ; bookWyrm
					)
					(2
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 3) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 4) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 5) ; bookWyrm
					)
					(3
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 6) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 7) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 8) ; bookWyrm
					)
					(4
						(proc10_13
							0
							(ScriptID 230 2) ; bookWyrm
							gEgo
							-1
							0
							(Format @temp0 232 9 @global110) ; "Hi, %s. Have you met Beauty yet?"
						)
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 10) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 11) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 12) ; bookWyrm
						(= global141 -1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance dogGo of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 150) (gEgo y:) self
				)
				(global224 setMotion: 0)
			)
			(2
				(global224
					setMotion:
						PolyPath
						(- (global224 x:) 110)
						(global224 y:)
						self
				)
			)
			(3
				(global224 setAvoider: 0 setMotion: PolyPath 92 86 self)
				(gEgo
					normal: 0
					setAvoider: 0
					setCycle: Walk
					setMotion: NPFollow global224 30
				)
			)
			(4
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance storyIntro of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(switch global143
					(gCindStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 13) ; bookWyrm
					)
					(gJackStory
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 14) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 15) ; bookWyrm
					)
					(gBremenStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 16) ; bookWyrm
					)
					(gSnowStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 17) ; bookWyrm
					)
					(gBeautyStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 18) ; bookWyrm
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance storyWrap of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(switch global144
					(gCindStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 19) ; bookWyrm
					)
					(gJackStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 20) ; bookWyrm
					)
					(gBremenStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 21) ; bookWyrm
					)
					(gSnowStory
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 22) ; bookWyrm
					)
					(gBeautyStory
						(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 23) ; bookWyrm
						(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 24) ; bookWyrm
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance openDoor of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(sfx dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 146 90 self)
			)
			(1
				(sfx number: 104 play:)
				((ScriptID 230 1) setCycle: End self) ; door
			)
			(2
				(gEgo setMotion: MoveTo 137 87 self)
			)
			(3
				(gEgo ignoreActors: 1 setMotion: MoveTo 146 84 self)
			)
			(4
				(gEgo setPri: 3)
				((ScriptID 230 1) setCycle: Beg self) ; door
			)
			(5
				(sfx number: 103 play: self)
				(= seconds 3)
			)
			(6
				(gCurRoom newRoom: 235)
			)
		)
	)
)

(instance begGame of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 230 2) ; bookWyrm
					view: 230
					setLoop: 5
					setPri: 3
					cel: 0
					posn: 138 82
					init:
				)
				((ScriptID 230 1) loop: 0 cel: 6 init:) ; door
				(= ticks 1)
			)
			(1
				(gEgo setMotion: MoveTo 104 95 self)
			)
			(2
				(gEgo setHeading: 90)
				(= cycles 5)
			)
			(3
				(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 25) ; bookWyrm
				(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 26) ; bookWyrm
				(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 27) ; bookWyrm
				(proc10_13 0 (ScriptID 230 2) gEgo -1 0 232 28) ; bookWyrm
				(proc10_13 0 (ScriptID 230 2) gEgo self 1 232 29) ; bookWyrm
			)
			(4
				(= global140 1)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 104
	)
)

