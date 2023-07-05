;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm76 0
)

(local
	local0
)

(instance stone1 of Act
	(properties
		y 128
		x 186
		yStep 1
		view 176
		signal 16384
		illegalBits 0
	)

	(method (cue)
		(HandsOn)
	)
)

(instance stone2 of Act
	(properties
		y 128
		x 186
		yStep 1
		view 176
		cel 1
		signal 16384
		illegalBits 0
	)
)

(instance Rm76 of Rm
	(properties
		picture 76
	)

	(method (init)
		(Load rsVIEW 176)
		(super init:)
		(if (not (IsFlag 208))
			(if (IsFlag 207)
				(if (not (IsFlag 208))
					(self setRegions: 177) ; stoneDove
				)
			else
				(self setRegions: 186) ; SaracenRgn
			)
		)
		(self setRegions: 135) ; Temple
		(self setRegions: 181) ; Thief
		(switch gPrevRoomNum
			(133 ; finalBattle
				(gEgo posn: (gEgo x:) (gEgo y:))
				(stone1 init: setPri: 1 stopUpd:)
				(stone2 init: setPri: 1 stopUpd:)
			)
			(75
				(gEgo posn: (gEgo x:) 180)
				(if (< (gEgo x:) 95)
					(gEgo x: 95)
				)
				(stone1 init: setPri: 1 stopUpd:)
				(stone2 init: setPri: 1 stopUpd:)
			)
			(77
				(gEgo posn: 10 (gEgo y:))
				(stone1 init: setPri: 1 stopUpd:)
				(stone2 init: setPri: 1 stopUpd:)
			)
			(else
				(gEgo posn: 220 175 setPri: 2 setScript: partTheRocks)
			)
		)
		(if (IsFlag 202)
			(gEgo view: 92 setStep: 6 4)
		)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 10)
				(gCurRoom newRoom: 77)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 75)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(global193
				(cond
					(
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,(are<where)>')
							(Said 'ask[/merlin]/*>')
						)
						(cond
							((or (Said '/bandit') (Said '//bandit'))
								(Print 76 0) ; "Hurry! You must not let him out of your sight for an instant!"
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 76 1) ; "You will never see it again unless you catch that Thief!"
							)
							(else
								(Print 76 2) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
								(event claimed: 1)
							)
						)
					)
					(
						(Said
							'stop,get,kill,annihilate,attack,prevent,search/bandit'
						)
						(Print 76 3) ; "First, you must catch him!"
					)
					((Said 'capture/bandit')
						(Print 76 4) ; "Do not stand there then! Chase him!"
					)
					((Said 'talk[<to]/bandit')
						(Print 76 5) ; "First you must catch him and quickly!"
					)
					((Said 'get,get/grail')
						(Print 76 6) ; "Aye, you must, but only if you catch the Thief!"
					)
					((Said 'draw/blade')
						(Print 76 7) ; "First catch the Thief, then decide how to deal with him."
						(gEgo setScript: (ScriptID 198 1)) ; sheathSwordAndRun
					)
					((Said 'fuck')
						(Print 76 8) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(else
						(Print 76 2) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
						(event claimed: 1)
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(OnButton event 12 29 64 65)
							(OnButton event 95 29 146 72)
							(OnButton event 59 39 101 55)
							(OnButton event 144 36 194 77)
							(OnButton event 195 44 308 93)
							(OnButton event 278 90 310 113)
							(OnButton event 217 79 266 124)
						)
						(if (IsFlag 208)
							(Print 76 9) ; "Each broken pillar looks much the same as its neighbor. You must find the right one by your wits."
						else
							(Print 76 10) ; "The elegant marble pillars which once held a roof have all been broken and thrown down, the work of those who would destroy the worship of Aphrodite."
						)
					)
					(
						(or
							(OnButton event 60 71 73 81)
							(OnButton event 87 80 94 84)
							(OnButton event 103 81 113 86)
							(OnButton event 25 119 44 129)
							(OnButton event 101 120 112 127)
							(OnButton event 64 162 74 169)
							(OnButton event 106 151 139 162)
							(OnButton event 142 113 150 123)
							(OnButton event 179 144 194 156)
							(OnButton event 252 153 265 161)
						)
						(Print 76 11) ; "They are common weeds, of no interest."
					)
					(
						(or
							(OnButton event 8 165 25 169)
							(OnButton event 25 167 83 183)
						)
						(Print 76 12) ; "The round pedestal in the center of the temple's ruins must have once held an altar or statue, but is empty now."
					)
					(
						(or
							(OnButton event 26 7 293 20)
							(OnButton event 7 20 310 60)
						)
						(Print 76 13) ; "The walls which encompass these ruins have deliberately been build without windows or doors, to enclose and hide this ruin."
					)
				)
			)
			((Said 'open/door,passage,trap,slab')
				(Print 76 14) ; "It closed solidly behind you. Only the Goddess herself could reopen it."
			)
		)
	)
)

(instance partTheRocks of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local0) (== (gRegMusic prevSignal:) 10))
			(= local0 1)
			(if (== state 5)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo has: 9) ; herbs | bone
					(PutItem 9) ; herbs | bone
					(SetFlag 212)
				)
				(= global109 6)
				(stone1 init: setLoop: 1 setPri: 1)
				(stone2 init: setLoop: 1 setPri: 1)
				(= cycles 4)
			)
			(1
				(gRegMusic number: 108 loop: -1 play:)
				(stone2 setMotion: MoveTo 186 132)
				(stone1 setMotion: MoveTo 186 132 self)
			)
			(2
				(stone1 setCel: 0 setPri: 0 setMotion: MoveTo 155 119)
				(stone2 setCel: 1 setPri: 0 setMotion: MoveTo 229 144 self)
			)
			(3
				(= seconds 4)
			)
			(4
				(gEgo
					moveSpeed: 1
					cycleSpeed: 1
					setLoop: 1
					ignoreActors: 1
					setMotion: MoveTo 168 117 self
				)
			)
			(5
				(gEgo
					moveSpeed: 0
					cycleSpeed: 0
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 105 137 stone1
				)
				(if local0
					(self cue:)
				)
			)
			(6
				(stone1 setMotion: MoveTo 186 132)
				(stone2 setMotion: MoveTo 186 132 self)
			)
			(7
				(stone2 setLoop: 0 setPri: 1 setMotion: MoveTo 186 128)
				(stone1 setLoop: 0 setPri: 1 setMotion: MoveTo 186 128 self)
			)
			(8
				(stone1 stopUpd:)
				(stone2 stopUpd:)
				(Print 76 15) ; "The stairs bring you to the surface and into blessed light and fresh air."
				(Print 76 16) ; "Around you is the ruin of a circular temple. Once there was a famous Temple of Aphrodite in Jerusalem. Perhaps this was it."
				(Print 76 17) ; "The marble stones are ancient and weather-worn. The marble pillars are toppled and an empty round pedestal in the middle may have once held a statue or altar."
				(Print 76 18) ; "Walls without doors or windows have been built entirely around the temple, right up to the very edge of the ruins."
				(= global109 0)
				(self dispose:)
			)
		)
	)
)

