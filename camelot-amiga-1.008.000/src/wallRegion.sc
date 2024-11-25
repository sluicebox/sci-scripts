;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Motion)
(use Game)
(use System)

(public
	wallRegion 0
	muleFollow 1
)

(synonyms
	(cut opening)
)

(local
	local0
	local1
)

(instance wallRegion of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 971)
	)

	(method (init)
		(Load rsVIEW 35)
		(Load rsSCRIPT 116)
		(Load rsSCRIPT 971)
		(super init:)
		(if (!= (gRegMusic number:) 62)
			(gRegMusic number: 62 priority: 1 loop: -1 play:)
		)
		(if (== gPrevRoomNum 0)
			(SetFlag 20)
		)
		(if (or (== gCurRoomNum global206) (IsFlag 20))
			(gCurRoom setRegions: 116) ; muleReg
			(gMuleObj illegalBits: $8006 setScript: muleFollow)
		)
	)

	(method (doit)
		(cond
			((and (== (gEgo onControl: 1) 2) (not (gEgo script:)))
				(= local1 1)
				(gCurRoom goingOut: 1)
				(gEgo setScript: fallDown)
			)
			((and (== (gEgo onControl: 1) 4) (not (gEgo script:)))
				(gCurRoom goingOut: 1)
				(gEgo setScript: fallDown)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((or (Said 'look<up') (Said 'look/sky,cloud,sun'))
				(Print 123 0) ; "I would not look up into the blindingly bright sky too often, if I were you."
			)
			((Said 'climb[/wall,!*]')
				(Print 123 1) ; "In your armour? Without ladder or scaling gear? Do not be absurd."
			)
			((Said 'look<above[/wall]')
				(Print 123 2) ; "The walls are far too high for that."
			)
			((Said 'cut,get/aloe')
				(Print 123 3) ; "I can see no purpose in that."
			)
			((Said 'drink,eat,nibble/aloe')
				(Print 123 4) ; "You would not enjoy that. Trust me."
			)
			((Said 'draw/blade')
				(Print 123 5) ; "Draw your sword only when absolutely necessary, or you may attract attention you do not want. Remember the captain's warning."
				(= global125 2)
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(Print 123 6) ; "Let us pray that the end of your mission will lie within these walls."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'get/clue>')
					(Said 'look>')
				)
				(cond
					((or (Said '/city,jerusalem') (Said '//city,jerusalem'))
						(Print 123 7) ; "You cannot actually see much of the city from outside the walls."
					)
					((or (Said '/door,gate[<!*]') (Said '//door,gate[<!*]'))
						(if global202
							(Print 123 8) ; "At least you know what to expect this time."
						else
							(Print 123 9) ; "Let us hope that other gates will not be as inhospitable as the one you passed."
						)
					)
					(
						(or
							(Said '/dirt,path,path')
							(Said '//dirt,path,path')
							(Said '<down')
						)
						(Print 123 10) ; "The narrow path around the walls of Jerusalem is hard packed soil. It drops off quite steeply, so be careful."
					)
					((or (Said '[<at]/wall,slab') (Said '//wall,slab'))
						(Print 123 11) ; "The walls of Jerusalem are made of huge blocks of a buff-colored stone."
					)
					((or (Said '/boulder') (Said '//boulder'))
						(Print 123 12) ; "Aye, they are rocks. There is a lot of rock in this country."
					)
					((or (Said '/zion') (Said '//zion'))
						(Print 123 13) ; "The Zion Gate is a small gate in the south wall of Jerusalem."
					)
					((or (Said '/jaffa') (Said '//jaffa'))
						(Print 123 14) ; "The Jaffa Gate is the main gate in the western wall of Jerusalem."
					)
					((or (Said '/bush,plant') (Said '//bush,plant'))
						(Print 123 15) ; "Some of the spiny plants are Aloe Vera. The others are some Eastern desert varieties unknown to me."
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 123 16) ; "Trees do not seem to fare well around here. I see nothing but shrubs."
					)
					((or (Said '/aloe') (Said '//aloe'))
						(Print 123 17) ; "Aloe Vera is originally from Africa. The leaves have a bitter, astringent juice within."
					)
				)
			)
		)
	)
)

(instance fallDown of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global124
					(= global124 0)
				)
				(if (IsFlag 20)
					(gMuleObj illegalBits: $8006)
				)
				(gTObj endTalk:)
				(if
					(or
						(and (== gCurRoomNum 51) (> (gEgo x:) 240))
						(== gCurRoomNum 54)
					)
					(= temp0 gCurRoomNum)
				else
					(= temp0 0)
				)
				(gEgo
					view: 35
					illegalBits: 0
					setPri:
						(switch temp0
							(51 13)
							(54 12)
							(else 9)
						)
					setLoop: (if local1 1 else 0)
					setCel: 1
				)
				(= cycles 2)
			)
			(1
				(gSFX number: 76 loop: 1 priority: 5 play:)
				(gEgo setCel: 2)
				(= cycles 2)
			)
			(2
				(Print 123 18 #dispose) ; "My that IS a steep drop."
				(gEgo
					setCel: 3
					posn:
						(if local1
							(+ (gEgo x:) 15)
						else
							(- (gEgo x:) 15)
						)
						(+ (gEgo y:) 24)
				)
				(= cycles 2)
			)
			(3
				(gEgo
					setCel: 4
					posn:
						(if local1
							(+ (gEgo x:) 3)
						else
							(- (gEgo x:) 3)
						)
						(+ (gEgo y:) 17)
				)
				(= cycles 2)
			)
			(4
				(gEgo
					posn:
						(if local1
							(+ (gEgo x:) 7)
						else
							(- (gEgo x:) 7)
						)
						(+ (gEgo y:) 15)
				)
				(= cycles 10)
			)
			(5
				(clr)
				(ShakeScreen 5)
				(= cycles 10)
			)
			(6
				(= cycles 10)
			)
			(7
				(Print 123 19) ; "There is no cause to swear at me, Arthur. It was your own clumsiness that caused it."
				(Print 123 20) ; "Now pick yourself up, dust yourself off, and we shall start all over again."
				(if (== gCurRoomNum 51)
					(= cycles 20)
				else
					(= cycles 2)
				)
			)
			(8
				(if (== gCurRoomNum 51)
					(if (and (IsFlag 20) (> (gMuleObj y:) 175))
						(gMuleObj
							setMotion:
								MoveTo
								(gMuleObj x:)
								(- (gMuleObj y:) 25)
						)
					)
					(gEgo
						view: 0
						setLoop: -1
						setPri: -1
						setMotion: 0
						setCycle: Walk
						illegalBits: $8000
						cycleSpeed: 0
						moveSpeed: 0
						setStep: 3 2
						ignoreActors: 0
						posn: 205 235
						setMotion: MoveTo 205 185 self
					)
					(SetFlag 80)
				else
					(if (IsFlag 20)
						(if (== gCurRoomNum 55)
							(= global206 54)
						else
							(= global206 gCurRoomNum)
						)
						(ClearFlag 20)
					)
					(switch gCurRoomNum
						(52
							(= gCurRoomNum 49)
							(SetFlag 80)
							(gCurRoom newRoom: 51)
						)
						(53
							(= gCurRoomNum 49)
							(SetFlag 80)
							(gCurRoom newRoom: 51)
						)
						(54
							(if (gCurRoom script:)
								(gCurRoom setScript: 0)
							)
							(= gCurRoomNum 52)
							(gCurRoom newRoom: 53)
						)
						(55
							(= gCurRoomNum 53)
							(gCurRoom newRoom: 54)
						)
					)
				)
			)
			(9
				(gCurRoom goingOut: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance muleFollow of Script
	(properties)

	(method (doit)
		(if
			(and
				(not (gCurRoom goingOut:))
				(not (gCurRoom comingIn:))
				(not local0)
				(gEgo mover:)
				(> (gEgo distanceTo: gMuleObj) 50)
			)
			(= local0 1)
			(gMuleObj setStep: 3 2 setMotion: Follow gEgo 50 setScript: 0)
		)
		(super doit:)
	)
)

