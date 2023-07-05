;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use Interface)
(use Path)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	walkabout 0
)

(synonyms
	(butler person man)
)

(local
	[local0 36] = [0 0 0 0 100 174 167 163 205 163 260 130 0 0 0 0 260 130 70 170 0 0 0 0 114 124 80 170 20 47 100 168 0 0 0 0]
	[local36 36] = [0 0 0 0 -20 140 340 163 340 163 340 130 0 0 140 125 140 125 140 240 0 0 0 0 111 124 -20 170 -40 47 -20 168 0 0 0 0]
	[local72 36] = [0 0 0 0 -20 176 -20 161 -20 150 154 144 0 0 0 0 303 101 0 0 0 0 0 0 0 0 340 175 80 47 340 168 0 0 0 0]
	[local108 18] = [53 12 4 10 3 9 58 58 9 13 69 69 13 21 22 23 12 35]
	[local126 7] = [32 152 66 124 114 124 -32768]
	[local133 7] = [66 124 32 162 340 162 -32768]
	[local140 8] = [66 143 64 174 -20 174 -32768 0]
)

(instance walkabout of Rgn
	(properties)

	(method (init &tmp [temp0 50])
		(super init:)
		(|= global195 $0400)
		(Load rsSCRIPT 985)
		(Load rsSCRIPT 983)
		(if (== [gCycleTimers 2] 0)
			(= [gCycleTimers 2] 1800)
		)
		(Jeeves
			setAvoider: ((Avoid new:) offScreenOK: 1)
			setCycle: Walk
			loop: 1
			init:
			hide:
		)
		(= global131 0)
		(if
			(and
				(== [local108 (- 17 global155)] gCurRoomNum)
				(> [gCycleTimers 2] (* (- 16 global155) 100))
			)
			(if global390
				(= [local0 (* global155 2)] global390)
				(= [local0 (+ (* global155 2) 1)] global391)
			)
			(Jeeves
				posn: [local0 (* global155 2)] [local0 (+ (* global155 2) 1)]
				show:
			)
			(self setScript: walkThru)
		)
	)

	(method (doit &tmp [temp0 50])
		(if
			(and
				(== (mod [gCycleTimers 2] 100) 0)
				(== [local108 (/ [gCycleTimers 2] 100)] gCurRoomNum)
			)
			(= global155 (- (- 18 (/ [gCycleTimers 2] 100)) 1))
			(if (and (not (& (gEgo onControl: 0) $0010)) (== global155 8))
				(self setScript: outTheDoor)
			else
				(Jeeves
					posn:
						[local36 (* global155 2)]
						[local36 (+ (* global155 2) 1)]
					show:
				)
				(if (== gCurRoomNum 23)
					(= [local72 (* global155 2)] 0)
				)
				(self setScript: walkThru)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if script
			(= global390 (Jeeves x:))
			(= global391 (Jeeves y:))
		else
			(= global390 0)
			(= global391 0)
		)
		(super dispose:)
		(DisposeScript 985)
		(DisposeScript 983)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
	)
)

(instance walkThru of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(Jeeves show:)
				(if (== [local72 (* global155 2)] 0)
					(cond
						((and (== gCurRoomNum 9) (== global155 9))
							(Jeeves setMotion: room9a self)
						)
						((and (== gCurRoomNum 9) (== global155 12))
							(Jeeves setMotion: room9b self)
						)
						((== gCurRoomNum 23)
							(Jeeves setMotion: room23 self)
						)
					)
				else
					(Jeeves
						setMotion:
							MoveTo
							[local72 (* global155 2)]
							[local72 (+ (* global155 2) 1)]
							self
					)
				)
			)
			(1
				(if (== global155 5)
					(if (== (global373 cel:) 0)
						(HandsOff)
						(global373 cycleSpeed: 3 setCycle: End self)
						(global374 number: 107 play:)
					else
						(= state 0)
						(= cycles 1)
					)
				else
					(++ global155)
					(= [gCycleTimers 2] (- 1700 (* global155 100)))
					(Jeeves hide:)
					(client setScript: 0)
				)
			)
			(2
				(HandsOn)
				(Jeeves setPri: 2 setMotion: MoveTo 140 125 self)
			)
			(3
				(global373 cycleSpeed: 3 setCycle: Beg self)
				(global374 number: 107 play:)
			)
			(4
				(++ global155)
				(= [gCycleTimers 2] (- 1700 (* global155 100)))
				(global373 stopUpd:)
				(Jeeves setPri: -1 hide:)
				(client setScript: 0)
			)
		)
	)
)

(instance outTheDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global373 cycleSpeed: 3 setCycle: End self)
				(global374 number: 107 play:)
				(Jeeves show: posn: 140 125 setPri: 2 loop: 2)
			)
			(1
				(Jeeves setPri: -1 setMotion: MoveTo 164 144 self)
			)
			(2
				(HandsOn)
				(Jeeves setMotion: MoveTo 303 101 self)
				(global373 setCycle: Beg)
				(global374 number: 108 play:)
			)
			(3
				(global373 stopUpd:)
				(++ global155)
				(= [gCycleTimers 2] (- 1700 (* global155 100)))
				(Jeeves setPri: -1 hide:)
				(client setScript: 0)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 131
		x 286
		view 440
	)

	(method (handleEvent event)
		(= global213 11)
		(cond
			((or (MousedOn self event 3) (Said 'look/butler'))
				(event claimed: 1)
				(if (& global207 $0400)
					(Print 381 0) ; "Jeeves seems to be busy doing his chores."
				else
					(|= global207 $0400)
					(Say 0 381 1) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
				)
				(event claimed: 1)
			)
			((Said 'flirt//butler<with')
				(Print 381 2) ; "He's not your type!"
			)
			((Said 'ask,tell//*<about')
				(Print 381 3) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
			)
			((Said 'show,give/*')
				(if (and global219 global224)
					(Print 381 4) ; "Jeeves pays no attention to you as he continues his rounds."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/butler>')
				(cond
					((Said 'talk')
						(Print 381 3) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
					)
					((Said 'get')
						(Print 381 5) ; "You wouldn't want him!!"
					)
					((Said 'kill')
						(Print 381 6) ; "Now, now! There's no need for that!"
					)
					((Said 'kiss')
						(Print 381 7) ; "He's too strange."
					)
					((Said 'embrace')
						(Print 381 8) ; "He doesn't appeal to you."
					)
				)
			)
		)
	)
)

(instance room9a of Path
	(properties)

	(method (at param1)
		(return [local126 param1])
	)
)

(instance room9b of Path
	(properties)

	(method (at param1)
		(return [local133 param1])
	)
)

(instance room23 of Path
	(properties)

	(method (at param1)
		(return [local140 param1])
	)
)

