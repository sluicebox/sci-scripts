;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm28 0
)

(local
	local0
	local1
)

(instance redSign of Prop
	(properties
		view 28
	)
)

(instance greenSign of Prop
	(properties
		view 28
		loop 1
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance rm28 of Rm
	(properties
		picture 28
		horizon 115
		north 29
		west 27
	)

	(method (dispose)
		(SetFlag 18)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 28)
		(Load rsVIEW 530)
		(rm28
			style:
				(switch gPrevRoomNum
					(27 3)
					(else 16)
				)
		)
		(super init:)
		(gContMusic fade:)
		(SL enable:)
		(NormalEgo)
		(gEgo init:)
		(switch gPrevRoomNum
			(27
				(gEgo posn: 1 160 setMotion: MoveTo 15 160)
			)
			(else
				(if (not (IsFlag 142))
					(gEgo posn: 254 123 setMotion: MoveTo 254 130)
				)
			)
		)
		(if (IsFlag 142)
			(Magic
				posn: 98 160
				setPri: (+ (gEgo priority:) 1)
				ignoreActors:
				init:
			)
			(gEgo setScript: teleport)
		)
		(greenSign posn: 219 141 init:)
		(redSign setPri: 3 z: 23 posn: 251 124 init:)
	)

	(method (doit)
		(cond
			(
				(and
					(== (gEgo loop:) 0)
					(not local0)
					(== (gEgo onControl: 1) 4096)
				)
				(= local0 1)
				(greenSign setScript: showGreenSign)
			)
			(
				(and
					(!= (gEgo loop:) 2)
					(not local1)
					(== (gEgo onControl: 1) 2048)
				)
				(= local1 1)
				(redSign setScript: showRedSign)
			)
			((and (== (gEgo onControl: 1) 16384) local1)
				(= local1 0)
			)
			(
				(and
					local0
					(or
						(== (gEgo onControl: 1) 8192)
						(== (gEgo onControl: 1) 16384)
					)
				)
				(showGreenSign cue:)
			)
			((and (== (gEgo onControl: 1) 1) local0)
				(= local0 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'spit')
						(SetFlag 142)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*]')
								(HighPrint 28 0) ; "The air is crisp here and you can see your breath as you walk. There is a path leading up to a dark mountain, atop which is precariously perched a purple house."
							)
							((Said '/path,road')
								(HighPrint 28 1) ; "The path seems to be carved out of the rock. It forms a steep trail up to the house on the mountain."
							)
							((Said '/hill,peak')
								(HighPrint 28 2) ; "All of the mountains you can see are covered with snow except for the one to which the path leads."
							)
							((Said '/ice')
								(HighPrint 28 3) ; "The drifts of snow look several feet high in some places."
							)
							((Said '/north,mansion,house')
								(HighPrint 28 4) ; "Looking north, you see the strange house nestled on its craggy peak. It is hard to see much at this distance. All you can tell is that the house is very large, very purple, and very strange."
							)
							((Said '/forest,west')
								(HighPrint 28 5) ; "To the east is the forest."
							)
							((Said '/east,south')
								(HighPrint 28 6) ; "You see the surrounding mountains."
							)
							((or (Said '<up') (Said '/cloud,sky'))
								(HighPrint 28 7) ; "The clouds skirt the mountain edges."
							)
							((or (Said '<down') (Said '/ground'))
								(HighPrint 28 8) ; "There is a rocky path through the snow."
							)
						)
					)
					((Said 'throw/')
						(HighPrint 28 9) ; "There is nothing here to throw it at."
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(HighPrint 28 10) ; "You detect a strange, magical aura in this place."
								)
							)
							(20
								(if (CastSpell temp0)
									(HighPrint 28 11) ; "There's nothing here to dazzle."
								)
							)
							(23
								(if (CastSpell temp0)
									(HighPrint 28 12) ; "The magical aura around this place prevents you from casting a flame dart."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance showGreenSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(greenSign ignoreActors: 0 setCycle: End self)
			)
			(1
				(if (not (IsFlag 156))
					(HighPrint 28 13) ; "A sign appears. It reads:"
				)
				(switch (Random 1 3)
					(1
						(HighPrint 28 14) ; "Willkommen auf Zauberberg!"
					)
					(2
						(HighPrint 28 15) ; "Welcome to Magic Mountain!"
					)
					(3
						(HighPrint 28 16) ; ""Bienvenu a Mont Magie!"
					)
				)
				(SetFlag 156)
			)
			(2
				(greenSign ignoreActors: setCycle: Beg setScript: 0)
			)
		)
	)
)

(instance showRedSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(redSign ignoreActors: 0 setCycle: End self)
			)
			(1
				(gEgo setMotion: 0)
				(if (not (IsFlag 155))
					(HighPrint 28 17) ; "Another sign appears. It reads:"
				)
				(switch (Random 1 3)
					(1
						(HighPrint 28 18) ; "Trespassers will be toad!"
					)
					(2
						(HighPrint 28 19) ; "Now go home!"
					)
					(3
						(HighPrint 28 20) ; "Proceed at your own risk!"
					)
				)
				(SetFlag 155)
				(redSign ignoreActors: setCycle: Beg setScript: 0)
			)
		)
	)
)

(instance teleport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 98 160 loop: 2 cel: 1 hide:)
				(Magic setCycle: CT 6 1 self)
			)
			(1
				(gEgo show:)
				(Magic setCycle: End self)
			)
			(2
				(ClearFlag 142)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

