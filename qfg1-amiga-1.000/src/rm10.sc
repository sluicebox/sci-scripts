;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use n007)
(use Extra)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm10 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(HighPrint 10 0) ; "In a hole, hidden beneath the ancient stone, someone has placed a scroll."
)

(procedure (localproc_1)
	(cond
		((IsFlag 141)
			(HighPrint 10 1) ; "The scroll is no longer here."
		)
		((not local1)
			(HighPrint 10 2) ; "You see no scroll here."
		)
		((not (gEgo inRect: 92 126 150 149))
			(NotClose)
		)
		(else
			(HighPrint 10 3) ; "The scroll vanishes even as you read the magical runes upon it.  You now have the knowledge to cast a "Calm" spell."
			(SetFlag 141)
			(gEgo get: 10 1) ; note
			(gEgo learn: 22 10) ; calmSpell
			(SolvePuzzle 614 4 1)
		)
	)
)

(procedure (localproc_2)
	(HighPrint 10 4) ; "Your hunger has been totally satisfied. You don't need another piece of fruit."
)

(procedure (localproc_3)
	(switch local4
		(1
			(HighPrint 10 5) ; "The stone has the words "Guruka's Peace" carved upon the top. Funny. You thought it said something else the last time you looked at it."
		)
		(2
			(HighPrint 10 6) ; "The stone has the words "Erana's Peace" carved upon the top. Maybe you need glasses."
		)
		(else
			(HighPrint 10 7) ; "The stone has the words "Erana's Peace" carved upon the top. There are some runes carved along the side."
		)
	)
	(++ local4)
)

(procedure (localproc_4)
	(HighPrint 10 8) ; "It reads: "If thy Will is Magic, so shall I share. Open this Stone and claim what is there.""
)

(procedure (localproc_5)
	(HighPrint 10 9) ; "No amount of physical effort will be able to move this stone."
)

(instance rm10 of Rm
	(properties
		picture 10
		style 0
		south 12
	)

	(method (dispose)
		(SetFlag 0)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 10)
		(Load rsSOUND (SoundFX 24))
		(super init:)
		(SL enable:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(gEgo posn: 160 188 init: setMotion: MoveTo 160 170)
		(magicStone posn: 109 145 init:)
		(fruit1 init: setPri: 5)
		(fruit2 init: setPri: 5)
		(fruit3 init: setPri: 5)
		(fruit4 init: setPri: 5)
		(fruit5 init: setPri: 5)
		(fruit6 init: setPri: 5)
		(fruit7 init: setPri: 5)
		(fruit8 init: setPri: 5)
		(fruit9 init: setPri: 5)
		(fruit10 init: setPri: 5)
		(fruit11 init: setPri: 5)
		(fruit12 init: setPri: 5)
		(fruit13 init: setPri: 5)
		(fruit14 init: setPri: 5)
		(gContMusic stop: number: (SoundFX 24) loop: -1 play:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/scenery,clearing]')
								(HighPrint 10 10) ; "The meadow lies covered with a blanket of flowers, unusual for this early in the spring. It is warm, even though surrounded by the late snows of winter."
								(HighPrint 10 11) ; "The air has the fresh, clean scent of the mountains, accompanied by numerous perfume-like fragrances."
								(HighPrint 10 12) ; "A large, carved stone lies flat on the ground. You feel as though someone gentle was watching over you. You feel that you are safe here."
							)
							((Said '/flower,grass')
								(if (gEgo has: 22) ; flower
									(event claimed: 0)
								else
									(HighPrint 10 13) ; "All kinds of colorful and fragrant flowers and grasses cover the meadow."
								)
							)
							((or (Said '<up') (Said '/sky,cloud,star'))
								(HighPrint 10 14) ; "The sky is clear."
								(if gNight
									(HighPrint 10 15) ; "The stars shine."
								else
									(HighPrint 10 16) ; "The sun feels warm."
								)
							)
							((or (Said '<down') (Said '/ground'))
								(HighPrint 10 13) ; "All kinds of colorful and fragrant flowers and grasses cover the meadow."
							)
							((Said '/tree,bush')
								(HighPrint 10 17) ; "The small tree is most amazing. It bears blossoms and fruit at the same time, and the fruit on its boughs seems to shyly appear and disappear, shimmering."
							)
							((Said '/blossom')
								(HighPrint 10 18) ; "The tree's blossoms are soft, green and fragrant."
							)
							((Said '/apple')
								(if gNight
									(HighPrint 10 19) ; "The fruit glows and shimmers in the moonlight. It produces a fragrance like a sun-ripened strawberry."
								else
									(HighPrint 10 20) ; "The fruit sparkles in the sunlight, yet it appears soft and fuzzy."
								)
							)
							((Said '/hill,north,dragon,smoke,peak')
								(HighPrint 10 21) ; "To the north, the high, snowy peaks of the Dragon Smoke mountains are clearly visible."
							)
							((Said '/cliff,cliff,east,west')
								(HighPrint 10 22) ; "The meadow is an oasis at the edge of the snowline. The rocky hillside looks very steep and slippery."
							)
							((Said '/ice')
								(HighPrint 10 23) ; "You are at the snowline. All around you, except for the forest, the rocks and mountains glisten with slippery snow."
							)
							((Said '/south,forest')
								(HighPrint 10 24) ; "To the south, you see the deep forest through which you came to this meadow."
							)
							((Said '/boulder,brick')
								(if local1
									(HighPrint 10 25) ; "The stone has been moved."
								else
									(HighPrint 10 26) ; "The large stone appears to be ancient and deliberately placed."
								)
							)
							((Said '/word,carving,mark')
								(if (< (gEgo distanceTo: magicStone) 50)
									(localproc_3)
								else
									(NotClose)
								)
							)
							((Said '/rune')
								(if (< (gEgo distanceTo: magicStone) 50)
									(localproc_4)
								else
									(NotClose)
								)
							)
							((Said '/scroll')
								(localproc_1)
							)
							((Said '/chasm')
								(cond
									((not local1)
										(HighPrint 10 27) ; "You see no holes."
									)
									((not (IsFlag 141))
										(localproc_0)
									)
									((gEgo inRect: 80 115 160 160)
										(HighPrint 10 28) ; "The hole that was beneath the stone is empty."
									)
									(else
										(NotClose)
									)
								)
							)
						)
					)
					((Said 'read>')
						(cond
							((Said '/boulder,brick,word,carving,mark')
								(if (< (gEgo distanceTo: magicStone) 50)
									(localproc_3)
								else
									(NotClose)
								)
							)
							((Said '/rune')
								(if (< (gEgo distanceTo: magicStone) 50)
									(localproc_4)
								else
									(NotClose)
								)
							)
							((Said '/scroll')
								(localproc_1)
							)
						)
					)
					((Said 'open,force,move/brick,boulder')
						(localproc_5)
					)
					((Said 'eat/apple')
						(cond
							((> gFreeMeals 2)
								(localproc_2)
							)
							((not (gEgo inRect: 109 88 223 106))
								(HighPrint 10 29) ; "Go over to the tree and pick some."
							)
							(else
								(HighPrint 10 30) ; "The sweet, juicy fruit of the tree is amazingly satisfying and refreshing."
								(= gFreeMeals 4)
								(ClearFlag 124)
								(ClearFlag 125)
								(SolvePuzzle 645 2)
							)
						)
					)
					((Said 'lockpick,get>')
						(cond
							((Said '/blossom')
								(HighPrint 10 31) ; "The lovely blossoms should stay on the tree."
							)
							((Said '/apple')
								(cond
									((not (gEgo inRect: 109 88 223 106))
										(NotClose)
									)
									((> gFreeMeals 2)
										(localproc_2)
									)
									(else
										(HighPrint 10 32) ; "The fruit is very soft and juicy.  It would be impossible to keep in your pack."
									)
								)
							)
							((Said '/grass')
								(HighPrint 10 33) ; "The grasses in the meadow are covered over with flowers."
							)
							((Said '/boulder,brick')
								(localproc_5)
							)
							((Said '/scroll')
								(localproc_1)
							)
							((Said '/flower')
								(if (IsFlag 140)
									(HighPrint 10 34) ; "You take another handful of the lovely, fragrant flowers."
								else
									(HighPrint 10 35) ; "As you pick a variety of the sweet-smelling flowers, they seem to glow in your hands. You put them safely away."
								)
								(SetFlag 140)
								(gEgo get: 22 5) ; flower
							)
						)
					)
					((Said 'odor/flower,blossom,grass,clearing')
						(HighPrint 10 36) ; "The smell reminds you of laughter."
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(17
								(cond
									(local1
										(HighPrint 10 37) ; "There is no further purpose in casting the Open spell."
									)
									((CastSpell temp0)
										(gEgo setScript: moveStoneAway)
									)
								)
							)
							(18
								(if (CastSpell temp0)
									(HighPrint 10 38) ; "There is an aura of magic throughout this meadow. It seems to be benevolent and restorative."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((or (Said 'nap') (Said 'go[<to]/nap'))
						(if (not (CanSleep))
							(HighPrint 10 39) ; "You just can't sleep during the daytime."
							(DisposeScript 7)
						else
							(SolvePuzzle 615 5 1)
							(gEgo setScript: goToSleep)
						)
					)
					((Said 'climb')
						(HighPrint 10 40) ; "The rock faces are slippery with melted snow, and there is no need to climb the little tree."
					)
					((Said 'throw')
						(HighPrint 10 41) ; "The atmosphere here is peaceful and calm.  There is no need to throw anything."
					)
				)
			)
		)
	)
)

(instance goToSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (gEgo x:))
				(= local3 (gEgo y:))
				(= global61 1)
				(gCurRoom drawPic: 10 6)
				(gEgo view: 10 setLoop: 4 setCel: 0)
				(= seconds 3)
			)
			(1
				(TimePrint 3 10 42) ; "You sleep comfortably among the fragrant flowers."
				(= seconds 3)
			)
			(2
				(EgoSleeps 6 0)
				(= global61 0)
				(gCurRoom drawPic: 10 7)
				(gEgo posn: local2 local3 setLoop: 2)
				(magicStone forceUpd:)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance moveStoneAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 521 loop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 15)
			)
			(1
				(++ local0)
				(if (> (gEgo y:) 140)
					(magicStone
						posn: (+ (magicStone x:) 5) (- (magicStone y:) 2)
					)
				else
					(magicStone
						posn: (- (magicStone x:) 5) (+ (magicStone y:) 2)
					)
				)
				(= cycles 1)
			)
			(2
				(if (== local0 6)
					(= local0 0)
					(HandsOn)
					(= local1 1)
					(if (not (IsFlag 141))
						(localproc_0)
					)
					(NormalEgo)
					(gEgo loop: 2 setScript: 0)
				else
					(self changeState: 1)
				)
			)
		)
	)
)

(instance fruit1 of Extra
	(properties
		y 43
		x 166
		view 10
		loop 3
		cycleType 1
		minPause 50
		maxPause 100
		minCycles 1
		maxCycles 1
	)
)

(instance fruit2 of Extra
	(properties
		y 60
		x 139
		view 10
		loop 1
		cycleType 1
		minPause 60
		maxPause 110
		minCycles 1
		maxCycles 1
	)
)

(instance fruit3 of Extra
	(properties
		y 49
		x 154
		view 10
		loop 2
		cycleType 1
		minPause 70
		maxPause 120
		minCycles 1
		maxCycles 1
	)
)

(instance fruit4 of Extra
	(properties
		y 50
		x 175
		view 10
		loop 3
		cycleType 1
		minPause 80
		maxPause 130
		minCycles 1
		maxCycles 1
	)
)

(instance fruit5 of Extra
	(properties
		y 43
		x 184
		view 10
		loop 1
		cycleType 1
		minPause 90
		maxPause 140
		minCycles 1
		maxCycles 1
	)
)

(instance fruit6 of Extra
	(properties
		y 60
		x 191
		view 10
		loop 2
		cycleType 1
		minPause 100
		maxPause 150
		minCycles 1
		maxCycles 1
	)
)

(instance fruit7 of Extra
	(properties
		y 66
		x 208
		view 10
		loop 1
		cycleType 1
		minPause 40
		maxPause 90
		minCycles 1
		maxCycles 1
	)
)

(instance fruit8 of Extra
	(properties
		y 48
		x 136
		view 10
		loop 3
		cycleType 1
		minPause 30
		maxPause 80
		minCycles 1
		maxCycles 1
	)
)

(instance fruit9 of Extra
	(properties
		y 71
		x 163
		view 10
		loop 3
		cycleType 1
		minPause 20
		maxPause 70
		minCycles 1
		maxCycles 1
	)
)

(instance fruit10 of Extra
	(properties
		y 49
		x 208
		view 10
		loop 2
		cycleType 1
		maxPause 60
		minCycles 1
		maxCycles 1
	)
)

(instance fruit11 of Extra
	(properties
		y 80
		x 190
		view 10
		loop 3
		cycleType 1
		minPause 20
		maxPause 70
		minCycles 1
		maxCycles 1
	)
)

(instance fruit12 of Extra
	(properties
		y 43
		x 148
		view 10
		loop 1
		cycleType 1
		minPause 30
		maxPause 80
		minCycles 1
		maxCycles 1
	)
)

(instance fruit13 of Extra
	(properties
		y 70
		x 128
		view 10
		loop 2
		cycleType 1
		minPause 40
		maxPause 90
		minCycles 1
		maxCycles 1
	)
)

(instance fruit14 of Extra
	(properties
		y 79
		x 145
		view 10
		loop 1
		cycleType 1
		minPause 50
		maxPause 100
		minCycles 1
		maxCycles 1
	)
)

(instance magicStone of View
	(properties
		view 10
	)
)

