;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 118)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Full)
(use Interface)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm118 0
)

(local
	[msgString 200]
)

(procedure (OmarPrint whoToCue)
	(if (not argc)
		(= whoToCue 0)
	)
	(omarHead setCycle: Fwd)
	(Print &rest #dispose whoToCue #window omarWin #title {Omar:} #width 300 #time 15)
)

(instance rm118 of Rm
	(properties
		picture 110
		style 6
	)

	(method (init &tmp [str 20])
		(LoadMany rsVIEW 110 118 119)
		(SolvePuzzle 603 3)
		(omarHead view: 118 x: 193 y: 64 init:)
		(jaAfar init:)
		(super init:)
		(flame1 init:)
		(flame2 init:)
		(musician init: cycleSpeed: 2 setCycle: Fwd)
		(InitAddToPics egoSilhouette omarFeet lamp1 lamp2 pillow)
		(gCSound number: 106 loop: -1 priority: 0 playBed:)
		(StartTimer jaAfarTimer 3 10)
		(ClearFlag 2) ; fInMainGame
		(switch gDay
			(3
				(self setScript: poem1S)
			)
			(11
				(self setScript: poem2S)
			)
			(16
				(self setScript: poem3S)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(SetFlag 2) ; fInMainGame
		(super dispose:)
	)
)

(instance poem1S of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(OmarPrint self 118 0) ; "In the Month of the Serpent,   in the Year of the Djinn A shadow passed over the Katta's Tail Inn Astrologers foretell that Doom shall come to dwell And Shapeir shall be but sand upon the wind."
			)
			(1
				(self setScript: readS self)
			)
			(2
				(OmarPrint self 118 1) ; "Comes a hero from the North,   riding on the very air, And this is sign the first to then beware, For Darkness soon shall fall and shadow cover all, The city and the ones now living there."
			)
			(3
				(self setScript: readS self)
			)
			(4
				(OmarPrint self 118 2) ; "The first Doom shall be Fire,   which shall burn the very stone, The next is Air, and rocks are overthrown, Earth shall be the third,   then the final Doom is heard, The Water gone, the city parched like bone."
			)
			(5
				(self setScript: readS self)
			)
			(6
				(OmarPrint self 118 3) ; "Unless the one called Hero is a Hero true indeed, Who comes to help the city in its need, Then will face the depths of Doom   in the darkness of the Tomb, From the Elemental's Master, we are freed."
			)
			(7
				(self setScript: bowS self)
			)
			(8
				(gCSound fade:)
				(SetFlag 161) ; fSeenShow
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance poem2S of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(OmarPrint self 118 4) ; "Came a Hero drawing near   to our land of fair Shapeir, The Katta called and carried that one here. I shall tell an allegory   'bout a Quest for Love and Glory Which I shall relate if you will lend an ear."
			)
			(1
				(self setScript: readS self)
			)
			(2
				(OmarPrint self 118 5) ; "The Hero first faced fire   which was making matters dire, For the flames he fought were flitting ever higher. With water first he fought it   and into a lamp he caught it 'Ere our city of Shapeir became our pyre."
			)
			(3
				(self setScript: readS self)
			)
			(4
				(OmarPrint self 118 6) ; "The next he faced was Air,   which I'm sure that you're aware, Was blustering and blowing here and there. Before the Winds became our bane   as a fearsome hurricane, With a bellows then he caught it fair and square."
			)
			(5
				(self setScript: readS self)
			)
			(6
				(OmarPrint self 118 7) ; "So let us raise a cheer for the Hero of Shapeir, And remember that our praise is quite sincere, For in the Quest for Glory as related by this story, Is a Hero who has saved us from our fear, Is a Hero who's a Hero without peer!"
			)
			(7
				(self setScript: bowS self)
			)
			(8
				(gCSound fade:)
				(SetFlag 161) ; fSeenShow
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance poem3S of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(OmarPrint self 118 8) ; "In the Month of the Serpent,   in the Year of the Spear, Darkness passed over the town of Raseir, And the rumor had been said   that the old Emir was dead, For Arus al-Din had seemed to disappear."
			)
			(1
				(self setScript: readS self)
			)
			(2
				(OmarPrint self 118 9) ; "The Emir had a brother,   who quickly took the throne, but the Shadow lurking under soon was known For the Katta were exiled,   and Raseir was then defiled, By the rules and regulations that were shown."
			)
			(3
				(self setScript: readS self)
			)
			(4
				(OmarPrint self 118 10) ; "The Sultan sent his men to restore Raseir to right, But they did not even have a chance to fight, For as they crossed the land,   a tremendous storm of sand, Forced his forces to retreat from their plight."
			)
			(5
				(self setScript: readS self)
			)
			(6
				(OmarPrint self 118 11) ; "So now the rumor's told of the city of Raseir, That the Darkness shadows everything in fear. And He that now does rule has the Emir as his tool, Disobedience brings punishment severe."
			)
			(7
				(self setScript: readS self)
			)
			(8
				(OmarPrint self 118 12) ; "The moral of this story as the best of tales must tell Of the horrors of the orders that befell, Is the simple corollary that the Hero must be wary, 'Ere He journeys to that Shadow's Citadel, And we bid him luck and wish him to fare well."
			)
			(9
				(OmarPrint self (Format @msgString 118 13 @gUserName)) ; "As you travel to Raseir, %s, know that all of us in Shapeir wish for your safety and the success of your mission."
			)
			(10
				(self setScript: bowS self)
			)
			(11
				(gCSound fade:)
				(SetFlag 161) ; fSeenShow
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance readS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(omarHead setLoop: 1 setCycle: End)
				(= cycles 12)
			)
			(1
				(omarHead setCycle: Beg)
				(= cycles 12)
			)
			(2
				(omarHead setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance bowS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gestureTimer dispose:)
				(omarHead setLoop: 1 setCel: 0 setCycle: End self)
				(omarBody setLoop: 5 setCel: 0 setCycle: End)
			)
			(1
				(= cycles 8)
			)
			(2
				(omarHead setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance jaAfarLooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jaAfar setCycle: End)
				(= cycles 10)
			)
			(1
				(jaAfar setCycle: Beg)
				(= cycles 10)
			)
			(2
				(StartTimer jaAfarTimer 3 10)
				(self dispose:)
			)
		)
	)
)

(instance omarHead of Prop
	(properties
		view 118
		signal 16400
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(omarBody init:)
		(StartTimer gestureTimer 2 3)
	)
)

(instance omarBody of Prop
	(properties
		x 191
		y 83
		view 118
		loop 4
	)

	(method (cue)
		(StartTimer gestureTimer 2 3)
	)
)

(instance omarFeet of PicView
	(properties
		x 191
		y 108
		view 118
		loop 6
	)
)

(instance omarWin of BotWindow
	(properties
		color 5
		back 0
	)
)

(instance jaAfar of Actor
	(properties
		x 71
		y 107
		view 119
		cycleSpeed 4
	)
)

(instance musician of Prop
	(properties
		x 113
		y 88
		view 111
		loop 1
		signal 528
	)
)

(instance egoSilhouette of PicView
	(properties
		x 249
		y 167
		view 110
		loop 2
	)
)

(instance lamp1 of PicView
	(properties
		x 87
		y 115
		view 110
		loop 1
	)
)

(instance lamp2 of PicView
	(properties
		x 222
		y 156
		view 110
		loop 1
		cel 1
	)
)

(instance flame1 of Actor
	(properties
		x 222
		y 138
		view 110
		loop 3
		cel 1
	)
)

(instance flame2 of Actor
	(properties
		x 87
		y 102
		view 110
		loop 3
		cel 2
	)
)

(instance pillow of PicView
	(properties
		x 63
		y 89
		view 110
		loop 1
	)
)

(instance jaAfarTimer of Timer
	(properties)

	(method (cue)
		(jaAfar setScript: jaAfarLooks)
	)
)

(instance gestureTimer of Timer
	(properties)

	(method (cue)
		(cond
			((omarBody cel:)
				(omarBody setCycle: Beg omarBody)
			)
			((> (Random 1 10) 5)
				(omarBody
					setLoop: (Random 2 4)
					setCel: 0
					setCycle: Full 1 omarBody
				)
			)
			(else
				(omarBody
					setLoop: (Random 2 4)
					setCel: 0
					setCycle: End omarBody
				)
			)
		)
	)
)

