;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm155 0
)

(local
	local0
	local1
)

(instance rm155 of Rm
	(properties
		picture 155
		horizon 1
	)

	(method (init &tmp [temp0 50])
		style
		16
		(Load rsPIC 156)
		(Load rsPIC 777)
		(Load rsVIEW 8)
		(Load rsVIEW 9)
		(Load rsSOUND 100)
		(Load rsSOUND 64)
		(Load rsSOUND 65)
		(Load rsSOUND 66)
		(super init:)
		(self setScript: rmScript)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (event type:)
			(= global230 gNormalCursor)
			(gGame setCursor: gNormalCursor (HaveMouse))
			(Display 155 0 dsRESTOREPIXELS local0)
			(eyes dispose:)
			(bub0 dispose:)
			(bub1 dispose:)
			(bub2 dispose:)
			(bub3 dispose:)
			(gLongSong stop:)
			(gCurRoom drawPic: 777)
			(RedrawCast)
			(gCurRoom newRoom: 2)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 64 loop: 1 play:)
				(eyes init:)
				(= seconds 4)
			)
			(1
				(ShakeScreen 3)
				(= local0
					(Display 155 1 dsWIDTH 250 dsCOORD 36 100 dsALIGN alCENTER dsFONT 300 dsCOLOR 14 dsSAVEPIXELS) ; "The small pod is jarred by a sudden shock which triggers the Sleep Chamber's Revive Mode. As the glass shroud slides back, Roger slowly begins to regain consciousness."
				)
			)
			(2
				(Display 155 0 dsRESTOREPIXELS local0)
				(gCurRoom drawPic: 156 3)
				(doorSound play:)
				(= seconds 4)
			)
			(3
				(doorSound stop:)
				(gLongSong number: 66 loop: 1 play:)
				(eyes setCycle: CT 3 1 self)
			)
			(4
				(= seconds 3)
			)
			(5
				(eyes cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(= cycles 15)
			)
			(7
				(eyes cel: 0)
				(= cycles 2)
			)
			(8
				(eyes setCycle: End self)
			)
			(9
				(bub0 init:)
			)
			(10
				(eyes setLoop: 1 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(11
				(eyes setCycle: Beg self)
			)
			(12
				(eyes setCycle: End self)
			)
			(13
				(eyes setCycle: CT 2 -1 self)
			)
			(14
				(eyes setCel: 2 stopUpd:)
				(= seconds 3)
			)
			(15
				(eyes setLoop: 0 setCel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(16
				(eyes setCycle: Beg self)
			)
			(17
				(eyes setCycle: End self)
			)
			(18
				(eyes stopUpd:)
				(= cycles 2)
			)
			(19
				(eyes stopUpd:)
			)
			(20
				(= global230 gNormalCursor)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(gLongSong stop:)
				(eyes dispose:)
				(gCurRoom drawPic: 777)
				(RedrawCast)
				(gCurRoom newRoom: 2)
			)
		)
	)

	(method (doit)
		(if (== (gLongSong prevSignal:) -1)
			(if
				(and
					(== (gLongSong number:) 64)
					(!= (gLongSong state:) 3)
					(== (self state:) 1)
				)
				(self cue:)
			)
			(if (and (== (gLongSong number:) 66) (!= (gLongSong state:) 3))
				(if (< (self state:) 19)
					(gLongSong play:)
				)
				(if (== (self state:) 19)
					(self cue:)
				)
			)
		)
		(super doit:)
	)
)

(instance bubScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bub1 init: stopUpd:)
				(= cycles 3)
			)
			(1
				(bub2 init: stopUpd:)
				(= cycles 3)
			)
			(2
				(whereSound play:)
				(bub3 init: stopUpd:)
				(= seconds 5)
			)
			(3
				(rmScript cue:)
				(bub0 dispose:)
				(bub1 dispose:)
				(bub2 dispose:)
				(bub3 dispose:)
			)
		)
	)
)

(instance bub0 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 9
			setCel: 0
			ignoreActors: 1
			posn: 184 51
			setPri: 15
			setScript: bubScript
		)
	)
)

(instance bub1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 9 setCel: 1 ignoreActors: 1 posn: 197 47 setPri: 15)
	)
)

(instance bub2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 9 setCel: 2 ignoreActors: 1 posn: 215 42 setPri: 15)
	)
)

(instance bub3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 9 setCel: 3 ignoreActors: 1 posn: 243 34 setPri: 15)
	)
)

(instance eyes of Act
	(properties
		y 88
		x 145
		view 8
	)

	(method (init)
		(super init:)
		(self
			loop: 0
			cel: 0
			ignoreActors: 1
			setPri: 9
			cycleSpeed: 4
			illegalBits: 0
		)
	)
)

(instance whereSound of Sound
	(properties
		number 100
		priority 5
	)
)

(instance doorSound of Sound
	(properties
		number 65
		priority 5
	)
)

