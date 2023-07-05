;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm92 0
)

(local
	endOfGame
	aWaterfall
	aFog
	aDoor
	aCopter
)

(instance theSound of Sound
	(properties
		priority 30
		loop -1
	)
)

(instance rm92 of Rm
	(properties
		picture 92
		style 7
		horizon 5
	)

	(method (init)
		(Load rsVIEW 806)
		(Load rsVIEW 821)
		(super init:)
		((= aCopter (Act new:))
			view: 821
			ignoreActors:
			illegalBits: 0
			setPri: 6
			setCycle: Fwd
			setStep: 2 1
			setScript: islandScript
		)
		(self setScript: rm92Script)
		(cond
			((== gIslandStatus 100)
				(Load rsSOUND 17)
				(theSound number: 17 play:)
				(aCopter posn: 103 123)
				(rm92Script changeState: 16)
			)
			((== gIslandStatus 102)
				(Load rsSOUND 17)
				(theSound number: 17 play:)
				(aCopter posn: 223 93)
				(rm92Script changeState: 23)
			)
			(else
				(Load rsSOUND 102)
				(theSound number: 102 play:)
				(aCopter posn: -7 93)
				(rm92Script changeState: 1)
			)
		)
		(if (!= gIslandStatus 102)
			((= aWaterfall (Prop new:))
				view: 806
				ignoreActors:
				loop: 0
				posn: 203 88
				setPri: 10
				setCycle: Fwd
				cycleSpeed: 1
				init:
			)
			((= aFog (Prop new:))
				view: 806
				ignoreActors:
				loop: 1
				cel: 0
				posn: 206 109
				cycleSpeed: (if (== gIslandStatus 100) 1 else 5)
				setPri: 14
				init:
				hide:
			)
			((= aDoor (Prop new:))
				view: 806
				ignoreActors:
				loop: 3
				cel: 0
				posn: 205 94
				cycleSpeed: 5
				setPri: 4
				init:
			)
		)
		(aCopter init:)
		(HandsOff)
		(= gCurrentStatus 22)
	)
)

(instance rm92Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (and (== gIslandStatus 0) (not (event claimed:)))
			(gGame restart:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= cycles 30)
			)
			(2
				(Print 92 0 #at -1 15 #width 280 #time 12) ; "Meanwhile, on the beautiful tropical island paradise of Nontoonyt Island, located somewhere in the South Pacific, a formerly strange weather phenomenon occurs once again."
				(islandScript changeState: 1)
			)
			(3
				(Print 92 1 #at -1 15 #width 280 #time 12 #draw) ; "The island's native tribe has grown accustomed to these recent occurrences of dense fog, even though it appears (and dissipates) quite rapidly."
				(= cycles 20)
			)
			(4
				(aCopter setMotion: MoveTo 186 93 self)
				(= cycles 40)
			)
			(5
				(Print 92 2 #at -1 15 #width 280 #time 14 #draw) ; "What the natives don't know, however, is that the fog is just a smokescreen to cover the activities of an evil force so sinister, so sly, so slick, that the mere mention of his name brings fear to the heart of the staunchest man..."
				(Print 92 3 #font gBigFont #time 5) ; "NONOOKEE!"
				(= cycles 40)
			)
			(6
				(islandScript changeState: 3)
			)
			(8
				(islandScript changeState: 5)
			)
			(9
				(aCopter setMotion: MoveTo 223 93 self)
			)
			(10
				(islandScript changeState: 7)
			)
			(11
				(islandScript changeState: 9)
			)
			(12
				(islandScript changeState: 11)
			)
			(13
				(= cycles 20)
			)
			(14
				(Print 92 4 #at -1 15 #width 280 #time 8 #draw) ; "Inside his volcanic mountain fortress, the dirty Doctor is designing the most disgusting of his dastardly deeds."
				(= seconds 3)
			)
			(15
				(gCurRoom newRoom: 93)
			)
			(16
				(= cycles 30)
			)
			(17
				(aFog show: setScript: fogScript)
				(aCopter setMotion: MoveTo 98 93 self)
			)
			(18
				(islandScript changeState: 3)
			)
			(19
				(aCopter setMotion: MoveTo 186 93 self)
			)
			(20
				(islandScript changeState: 5)
			)
			(21
				(aCopter setMotion: MoveTo 223 93 self)
			)
			(22
				(gCurRoom newRoom: 85)
			)
			(23
				(aCopter setMotion: MoveTo 149 93)
				(= cycles 20)
			)
			(24
				(Print 92 5) ; ""Say, aren't you that guy that won that big lottery prize?" asks the pilot."
				(Print (Format @gString 92 6 gLaffer)) ; ""Yep, that's me," you reply proudly. %s"
				(= cycles 20)
			)
			(25
				(Print 92 7) ; "Well, Larry, I've got a little surprise for you. I just heard on the radio: they just went bankrupt. Kaput. Busted. I hope you saved some of that money."
				(= cycles 10)
			)
			(26
				(Print 92 8) ; "It doesn't matter," you assert, "I have the love of a beautiful woman and we can live here on this wonderful island for the rest of our lives. Why do I need money? I'll give up my leisure suit for a muumuu!"
				(= cycles 20)
			)
			(27
				(aCopter setMotion: MoveTo 246 120 self)
			)
			(28
				(= gIslandStatus 103)
				(gCurRoom newRoom: 75)
			)
		)
	)
)

(instance islandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aFog show: setCycle: End self)
			)
			(2
				(aFog stopUpd:)
				(rm92Script cue:)
			)
			(3
				(aWaterfall cycleSpeed: 2 setLoop: 2 setCycle: End self)
			)
			(4
				(aWaterfall hide:)
				(rm92Script cue:)
			)
			(5
				(aDoor setCycle: End self)
			)
			(6
				(rm92Script cue:)
			)
			(7
				(aDoor setCycle: Beg self)
			)
			(8
				(rm92Script cue:)
			)
			(9
				(aWaterfall show: setLoop: 4 cel: 0 setCycle: End self)
			)
			(10
				(aWaterfall setLoop: 0 cycleSpeed: 0 setCycle: Fwd)
				(rm92Script cue:)
			)
			(11
				(aFog show: setCycle: Beg self)
			)
			(12
				(aFog hide:)
				(rm92Script cue:)
			)
		)
	)
)

(instance fogScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(aFog setCycle: End self)
			)
			(2
				(aFog setCycle: Beg self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

