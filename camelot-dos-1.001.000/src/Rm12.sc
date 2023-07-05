;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	Rm12 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 3] = [271 219 199]
	[local10 3] = [152 134 114]
	[local13 3] = [0 72 57]
	[local16 3] = [103 172 153]
	[local19 3] = [126 132 102]
	[local22 3] = [141 147 145]
	[local25 3] = [263 211 191]
	[local28 3] = [156 138 118]
	[local31 3] = [0 3 6]
	[local34 3] = [1 4 7]
	[local37 6] = [2 5 8 4 3 2]
	local43
)

(instance UseSpearIcon of View
	(properties
		y 180
		x 100
		view 406
		loop 9
		priority 15
		signal 16
	)
)

(instance Rm12 of Rm
	(properties
		picture 12
	)

	(method (init)
		(if (not (IsFlag 24))
			(Load rsSOUND 27)
			(Load rsSOUND 28)
			(Load rsSOUND 36)
			(Load rsSOUND 31)
			(Load rsSOUND 93)
		else
			(Load rsVIEW 112)
		)
		(Load rsVIEW 406)
		(Load rsVIEW 17)
		(self setRegions: 102) ; forestPerilous
		(super init:)
		(proc0_13 32)
		(gAddToPics doit:)
		(if (IsFlag 24)
			(= local6 1)
			(= global109 0)
			(deadBoar init: addToPic:)
			(db2 init: addToPic:)
			(db3 init: addToPic:)
			(flies1 setCycle: Fwd init:)
			(flies2 setCycle: Fwd init:)
			(flies3 setCycle: Fwd init:)
			(Spear init:)
		else
			(= global109 6)
		)
		(gEgo init:)
		(self setScript: EnterRoom)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local2)
				(== (gEgo view:) 17)
				(== (gEgo loop:) 1)
				(== (gEgo cel:) 3)
				(boar
					inRect:
						(- (gEgo x:) 17)
						(gEgo y:)
						(gEgo x:)
						(+ (gEgo y:) 11)
				)
				(not local3)
			)
			(= local4 1)
			(= local3 1)
			(boar setScript: BoarDead)
		)
		(cond
			((or (> (gEgo x:) 310) (> (gEgo y:) 190))
				(SetFlag 23)
				(gCurRoom newRoom: 11)
			)
			((< (gEgo x:) 10)
				(SetFlag 23)
				(gCurRoom newRoom: 13)
			)
		)
		(if (and local43 (not (gEgo mover:)))
			(= local43 0)
			(BoarMotion cue:)
		)
	)

	(method (notify)
		(if (IsFlag 75)
			(Sound pause: 1)
			(Print 12 0) ; "Listen! There is a rustling in the bushes. Something heavy approaches."
			(Sound pause: 0)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						local1
						(not (gEgo mover:))
						(not local6)
						(== (event message:) KEY_SPACE)
						(not local2)
					)
					(gEgo setScript: Spearing)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (IsFlag 24) (& (event modifiers:) emSHIFT))
					(cond
						((MouseClaimed Spear event)
							(Print 12 1) ; "The spear has sunk deeply into the carcass. Your final blow was your most powerful."
						)
						(
							(and
								(gCast contains: flies1)
								(or
									(MouseClaimed flies1 event)
									(MouseClaimed flies2 event)
									(MouseClaimed flies3 event)
								)
							)
							(Print 12 2) ; "Where there is decay, there will be flies."
						)
						(
							(or
								(OnButton event 168 106 211 121)
								(OnButton event 128 126 232 142)
								(OnButton event 241 144 283 159)
							)
							(Print 12 3) ; "Sorrow not over the death of these savage creatures. They would just as readily have gutted you."
						)
						(
							(or
								(OnButton event 8 117 19 154)
								(OnButton event 12 158 24 169)
								(OnButton event 25 145 45 183)
								(OnButton event 46 156 53 182)
								(OnButton event 54 166 78 183)
								(OnButton event 101 148 179 182)
								(OnButton event 179 160 240 182)
							)
							(Print 12 4) ; "'Tis a bush."
						)
						(
							(or
								(OnButton event 8 72 24 169)
								(OnButton event 24 102 94 182)
								(OnButton event 91 142 105 182)
							)
							(Print 12 5) ; "'Tis a rock."
						)
						(
							(or
								(OnButton event 25 7 294 20)
								(OnButton event 8 20 310 93)
								(OnButton event 152 95 310 103)
								(OnButton event 222 93 310 108)
							)
							(Print 12 6) ; "'Tis a tree."
						)
					)
				)
			)
			(evSAID
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
					(
						(or
							(Said 'talk/merlin')
							(Said 'ask/advice')
							(Said 'ask[/merlin]/advice')
						)
						(Print 12 7) ; "Continue your search."
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
									(Said 'look[<around][/room,forest]')
									(Said '//room,forest')
								)
								(Print 12 8) ; "There is the inevitable aftermath of battle -- blood and death."
							)
							((or (Said '/boar') (Said '//boar'))
								(Print 12 9) ; "You fought well, but it is not a pretty sight."
							)
							((or (Said '/body') (Said '//body'))
								(Print 12 3) ; "Sorrow not over the death of these savage creatures. They would just as readily have gutted you."
							)
							((or (Said '/spear') (Said '//spear'))
								(Print 12 10) ; "It has sunk deeply into the carcass. Your final blow was your most powerful."
							)
							((or (Said '/blood') (Said '//blood'))
								(Print 12 11) ; "There is plenty of it."
							)
							((or (Said '/tusk') (Said '//tusk'))
								(Print 12 12) ; "Boars have deadly tusks and an evil temperament to match."
							)
							((or (Said '/flea,bug') (Said '//flea,bug'))
								(Print 12 2) ; "Where there is decay, there will be flies."
							)
						)
					)
					((Said 'get,capture/flea,bug')
						(Print 12 13) ; "Ridiculous."
					)
					((Said 'use,adjust,get,throw/spear')
						(Print 12 14) ; "Forget the spear. It will serve you no more."
					)
					((Said 'kill/boar')
						(Print 12 15) ; "The battle is over."
					)
					((Said 'attack/boar')
						(Print 12 16) ; "The boars are dead. What would that accomplish?"
					)
					((Said 'pull,appropriate,remove,deliver/spear/boar<from')
						(Print 12 17) ; "It is too firmly wedged inside the boar. You must leave it there, I fear."
					)
					(
						(or
							(Said 'cut,carve/spear/deliver,loose')
							(Said 'cut,*/spear/boar<from')
						)
						(Print 12 18) ; "That would be a long, tedious and bloody job. Your mission is urgent. Leave the spear as it is."
					)
					((Said 'get,eat,cook,dress,fur/boar,meat')
						(Print 12 19) ; "Although the flesh of the wild pig is delicious, it would take much time and effort which you do not have to spare."
					)
					((Said 'make/chops,(dog<hot),(chops<extra),(chops<ham)')
						(Print 12 20) ; "Your humor leaves much to be desired."
					)
					((Said 'drink/blood')
						(Print 12 21) ; "How unsavory. Even the followers of Mithras no longer practice this. Now they drink wine instead of blood in their resurrection rituals. The Christians have followed this tradition as well."
					)
					((Said 'chase/boar')
						(Print 12 22) ; "Your ferocious battle has driven any other boars away, luckily for you."
					)
					((Said 'talk/boar')
						(Print 12 23) ; "That would be boring."
					)
					((Said 'listen')
						(if (IsFlag 23)
							(Print 12 24) ; "The normal sounds of the forest have returned, along with the buzzing of the flies."
						else
							(Print 12 25) ; "All is deathly silent in the aftermath of this struggle."
						)
					)
					((Said 'smell')
						(Print 12 26) ; "The strong, foul odor of the boars overwhelms all else."
					)
					((Said 'help/boar')
						(Print 12 27) ; "You cannot help such creatures. The giant boars of the Forest Perilous live only to kill."
					)
					((Said 'get/tusk')
						(Print 12 28) ; "If this were a hunt, perhaps it would be worth the toil, but you are on a sacred mission. It is time to move on."
					)
				)
			)
		)
	)
)

(instance EnterRoom of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			($0040 ; direction
				(if (< JOY_UP (event message:) JOY_DOWN)
					(client setScript: beatFeet)
				else
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (< (gEgo x:) (event x:))
					(client setScript: beatFeet)
				else
					(event claimed: 1)
				)
			)
			(evSAID
				(if (Said 'draw/blade')
					(= global125 2)
					(= local0 1)
					(Sound pause: 1)
					(Print 12 29) ; "Mighty as Excaliber is, it is not long enough to kill the boar before it can reach you."
					(Sound pause: 0)
				else
					(Sound pause: 1)
					(Print 12 30) ; "Listen! There is a rustling in the bushes. Something heavy approaches."
					(Sound pause: 0)
					(event claimed: 1)
				)
			)
		)
	)

	(method (doit)
		(if (and (== state 2) (== (gRmMusic prevSignal:) 10))
			(self cue:)
		)
		(if (and local0 (not (IsFlag 24)) (not global124) (not state))
			(gEgo setMotion: MoveTo [local7 local5] [local10 local5] self)
			(= local0 0)
		)
		(super doit:)
		(if (and (== state 3) (not global124) (not global125))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 13)
					(gEgo posn: 12 110 loop: 0 setMotion: MoveTo 30 110)
					(if (IsFlag 20)
						(gMuleObj
							posn: 10 125
							loop: 0
							setMotion: MoveTo 30 125
						)
					)
					(client setScript: 0)
				else
					(if (IsFlag 24)
						(= local1 0)
						(gEgo
							posn: 310 132
							loop: 1
							setMotion: MoveTo 290 132
						)
						(client setScript: 0)
					else
						(SetFlag 75)
						(User blocks: 1)
						(User canControl: 0)
						(gEgo
							posn: 303 174
							loop: 1
							setMotion:
								MoveTo
								[local7 local5]
								[local10 local5]
								self
						)
					)
					(if (IsFlag 20)
						(gMuleObj
							posn: 315 146
							loop: 1
							setMotion: MoveTo 290 146
						)
					)
				)
			)
			(1
				(Print 12 31) ; "The boars have trampled the ground here keeping it clear of the thick undergrowth which borders it."
				(= cycles 20)
			)
			(2
				(gRmMusic number: (proc0_20 27) loop: 1 play:)
			)
			(4
				(ClearFlag 75)
				(User blocks: 0)
				(HandsOff)
				(MenuBar state: 0)
				(boar init: setScript: BoarMotion)
				(client setScript: 0)
			)
		)
	)
)

(instance BoarMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boar
					view: 406
					loop: [local31 local5]
					posn: [local13 local5] [local16 local5]
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo [local19 local5] [local22 local5] self
				)
			)
			(1
				(= local43 1)
			)
			(2
				(boar setMotion: 0 loop: [local34 local5] cel: 0)
				(if (and (not local4) (gEgo has: 8)) ; boar_spear | grain | medallion
					(UseSpearIcon init:)
					(= local1 1)
					(Spear
						setCel: 2
						posn: (- (gEgo x:) 5) (- (gEgo y:) 28)
						init:
					)
				)
				(= seconds 6)
			)
			(3
				(= seconds 0)
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(= local1 1)
				)
				(boar
					loop: [local31 local5]
					setCycle: Walk
					setStep: 8 5
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo [local25 local5] [local28 local5] self
				)
			)
			(4
				(if (not local3)
					(= local2 1)
					(boar loop: [local37 local5] cel: 0 setCycle: End self)
				)
			)
			(5
				(if (not local3)
					(boar setCycle: Beg self)
					(gEgo setScript: EgoGored)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== state 2) (== (gRmMusic prevSignal:) 20))
				(gRmMusic prevSignal: 0)
				(boar setCycle: End)
			)
			((and (== (gRmMusic prevSignal:) 30) (== state 2))
				(self changeState: 3)
			)
		)
	)
)

(instance Spearing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(Spear cel: 1)
				(gEgo view: 17 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(switch global108
					(3
						(= cycles 3)
					)
					(2
						(= cycles 2)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
			)
			(3
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(= local1 1)
				)
				(gEgo setScript: 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local3 (== local5 2) (== (gEgo cel:) 4))
			(gEgo loop: 6 setCel: 0 setCycle: End)
			(self changeState: 3)
		)
	)
)

(instance BoarDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 0 0 (- 4 global108))
				(switch local5
					(0
						(gRmMusic number: 28 loop: 1 play:)
					)
					(1
						(gRmMusic number: 36 loop: 1 play:)
					)
					(2
						(gRmMusic number: 31 loop: 1 play:)
					)
				)
				(UseSpearIcon dispose:)
				(boar view: 17 loop: 0 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(if (== local5 2)
					(= local1 0)
					(Spear
						loop: 4
						setCel: 3
						posn: 201 118
						setPri: 8
						ignoreActors: 1
					)
					(= local6 1)
				)
				(boar loop: 2 cel: 0 setCycle: Fwd cycleSpeed: 3)
				(= seconds 4)
			)
			(2
				(deadBoar
					cel: (boar cel:)
					posn: (boar x:) (boar y:)
					setPri: (+ (gEgo priority:) 1)
					addToPic:
				)
				(++ local5)
				(= local1 0)
				(if (< local5 3)
					(gEgo
						view: 9
						loop: 1
						setCycle: Walk
						setMotion: MoveTo [local7 local5] [local10 local5]
					)
					(boar posn: 350 100 setScript: BoarMotion)
					(= local3 0)
					(= local2 0)
				else
					(= local1 0)
					(= global109 0)
					(SetFlag 24)
					(PutItem 8) ; boar_spear | grain | medallion
					(RedrawCast)
					(gEgo view: 9 loop: -1 loop: 1 setCycle: Walk)
					(boar dispose:)
					(MenuBar state: 1)
					(HandsOn)
				)
			)
		)
	)
)

(instance EgoGored of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gRmMusic prevSignal:) -1)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
				(gEgo view: 17 loop: 5 cel: 0 cycleSpeed: 1 setCycle: End)
				(if (gEgo has: 8) ; boar_spear | grain | medallion
					(Spear
						posn: (gEgo x:) (gEgo y:)
						loop: 3
						cel: 0
						cycleSpeed: 1
						init:
						setCycle: End
					)
				)
				(gRmMusic number: 93 loop: 1 play:)
			)
			(1
				(EgoDead 12 32) ; "The boar has gored you to the core. Alas, King Arthur is no more."
			)
		)
	)
)

(instance boar of Act
	(properties
		yStep 5
		view 406
		signal 16384
		xStep 5
	)

	(method (init)
		(self loop: [local31 local5] setCycle: Walk)
		(super init:)
	)
)

(instance deadBoar of View
	(properties
		y 156
		x 263
		view 17
		loop 2
	)
)

(instance db2 of View
	(properties
		y 138
		x 211
		view 17
		loop 2
		cel 2
	)
)

(instance db3 of View
	(properties
		y 118
		x 191
		view 17
		loop 2
		cel 4
	)
)

(instance flies1 of Prop
	(properties
		y 156
		x 260
		view 112
		loop 1
	)
)

(instance flies2 of Prop
	(properties
		y 139
		x 208
		view 112
		loop 1
	)
)

(instance flies3 of Prop
	(properties
		y 118
		x 188
		view 112
		loop 1
	)
)

(instance Spear of Prop
	(properties
		y 118
		x 201
		view 17
		loop 4
		cel 3
		signal 16384
	)

	(method (doit)
		(if (and (== (gEgo view:) 9) (gEgo has: 8) (not local2)) ; boar_spear | grain | medallion
			(self
				setPri: (gEgo priority:)
				setCel: 2
				posn: (- (gEgo x:) 5) (- (gEgo y:) 28)
			)
		)
		(super doit:)
	)
)

(instance beatFeet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 11)
			)
		)
	)
)

