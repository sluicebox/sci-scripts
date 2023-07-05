;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room2 0
)

(synonyms
	(room cemetery)
)

(local
	local0
	local1
)

(instance Room2 of Rm
	(properties
		picture 2
	)

	(method (init)
		(= east 9)
		(super init:)
		(= local0 -1)
		(Load rsSOUND 46)
		(Load rsSOUND 48)
		(Load rsVIEW 56)
		(gAddToPics add: dijon crouton doit:)
		(self setFeatures: Yard)
		(if gDetailLevel
			(light1 setScript: showers init: hide:)
			(light2 init: hide:)
			(light3 init: hide:)
		)
		(door1 setPri: 6 ignoreActors: 1 stopUpd: init:)
		(door2 stopUpd:)
		(if (and (< (Random 1 100) 25) (== gPrevRoomNum 9))
			(Load rsSOUND 12)
			(ghost setLoop: 3 setPri: 10 setScript: Spectre init:)
			(moodMusic number: 46 loop: -1 play:)
		)
		(if (== gPrevRoomNum 57)
			(HandsOff)
			(= gTombBarred 4)
			(gEgo posn: 164 102 setMotion: MoveTo 164 108 self)
			(door2 ignoreActors: 1 cel: (door2 lastCel:))
		else
			(gEgo loop: 1 posn: 310 126)
			(door2 cel: 0 ignoreActors: 0)
		)
		(door2 init:)
		(gEgo view: 0 illegalBits: -32704 init:)
		(= local1 1)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 2 0) ; "This is an old, family graveyard behind the little chapel. Set among the various family graves and monuments, you notice two large tombs."
		)
		(cond
			((& (gEgo onControl: 1) $0010)
				(gEgo setPri: -1)
				(gCurRoom newRoom: 57)
			)
			(
				(and
					(& (gEgo onControl: 1) $0008)
					(== gTombBarred 1)
					(== (gEgo loop:) 3)
					(== (door2 cel:) 0)
				)
				(= gTombBarred 2)
				(HandsOff)
				(door2 ignoreActors: 1)
				(gEgo setMotion: MoveTo 164 104 self)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		((ScriptID 208) keep: 0) ; outsideReg
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(if
				(or
					(& (gEgo onControl:) $0020)
					(& (gEgo onControl:) $0008)
				)
				(cond
					((Said 'look<(in,around)/crypt')
						(Print 2 1) ; "You must enter the tomb to do that."
					)
					((Said '/(crypt,door)>')
						(cond
							((Said 'open')
								(cond
									((& (gEgo onControl:) $0020)
										(= local0 0)
										(HandsOff)
										(gEgo
											illegalBits: -32768
											setMotion: MoveTo 43 118 self
										)
									)
									((& (gEgo onControl:) $0008)
										(Print 2 2) ; "The tomb door is sealed. You can't enter it."
									)
								)
							)
							((Said 'unbar')
								(if
									(or
										(& (gEgo onControl:) $0020)
										(and
											(& (gEgo onControl:) $0008)
											(== gTombBarred 1)
										)
									)
									(Print 2 3) ; "The tomb door isn't locked."
								else
									(Print 2 4) ; "There is no keyhole, or handle, to the tomb door. It is sealed from the inside."
								)
							)
							((Said 'break,force')
								(if
									(or
										(& (gEgo onControl:) $0020)
										(and
											(& (gEgo onControl:) $0008)
											(== gTombBarred 1)
										)
									)
									(Print 2 3) ; "The tomb door isn't locked."
								else
									(Print 2 5) ; "The tomb door is firmly sealed. No matter what you do, you cannot open it."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
			(if (not (event claimed:))
				(cond
					((Said 'look,read/crypt')
						(Print 2 6) ; "One tomb has the name DIJON carved over the door and CROUTON has been inscribed over the door of the other."
					)
					((Said 'bang')
						(if (& (gEgo onControl: 0) $0001)
							(NotClose) ; "You're not close enough."
						else
							(self setScript: knockDoor)
						)
					)
					((Said 'look,read/epitaph,gravestone')
						(Print 2 7) ; "Each gravestone is dedicated to a member of the Crouton family."
					)
					((Said 'look,follow/path')
						(Print 2 8) ; "A path leads to the chapel from the cemetery."
					)
					((Said 'find,look/ghost')
						(Print 2 9) ; "You don't really believe in ghosts, do you?!"
					)
					((Said 'look>')
						(cond
							((Said '[<around,at][/room]')
								(Print 2 0) ; "This is an old, family graveyard behind the little chapel. Set among the various family graves and monuments, you notice two large tombs."
							)
							((Said '[<down][/dirt]')
								(Print 2 10) ; "You see several graves and monuments on the ground."
							)
							((Said '/grave,monument')
								(Print 2 11) ; "The graves and monuments belong to various members of the Crouton family, ranging from the large monument of patriarch, Francois Crouton and his wife Claudette, to the simple grave of Sarah Crouton, who was 17 when she died in 1871."
							)
							((Said '<(in,around)/crypt')
								(NotClose) ; "You're not close enough."
							)
							((Said '/door')
								(Print 2 12) ; "Granite slabs form the tomb doors."
							)
							((Said '/crypt')
								(NotClose) ; "You're not close enough."
							)
							((Said '/fence')
								(Print 2 13) ; "A rusted, wrought iron fence surrounds the old, family cemetery."
							)
							((Said '/archway')
								(Print 2 14) ; "There is a gate leading into the cemetery."
							)
							((Said '/chapel')
								(Print 2 15) ; "The small chapel accompanies the old cemetery."
							)
							((Said '/gravestone[/dirt]')
								(Print 2 16) ; "The graves all seem to belong to the Crouton family."
							)
						)
					)
					((Said 'move,get,press/gravestone,grave')
						(Print 2 17) ; "None of the gravestones move. They are firmly planted in the ground."
					)
					((Said 'get,capture/ghost')
						(Print 2 9) ; "You don't really believe in ghosts, do you?!"
					)
					((Said 'talk/ghost')
						(Print 2 18) ; "Be serious! This is no time for a seance!"
					)
					((Said 'climb/fence')
						(Print 2 19) ; "The fence is too difficult to climb."
					)
					((Said 'open/crypt,door')
						(NotClose) ; "You're not close enough."
					)
					((Said 'open/archway')
						(AlreadyOpen) ; "It is already open."
					)
					((Said 'close/archway')
						(Print 2 20) ; "The gate seems to be stuck in place."
					)
				)
			)
		)
	)

	(method (cue)
		(if (!= local0 -1)
			(switch (++ local0)
				(1
					(gEgo loop: 3)
					(door1 startUpd: setCycle: End self)
					(soundFX number: 77 loop: 1 play:)
				)
				(2
					(soundFX stop:)
					(Print 2 21) ; "Cautiously, you look inside the tomb."
					(gEgo setMotion: MoveTo 41 106 self)
				)
				(3
					(gEgo setMotion: MoveTo 18 104 self)
				)
				(4
					(Print 2 22) ; "Currently, it's just an empty tomb. One day, this will be the final resting place of Colonel Dijon."
					(gEgo setMotion: MoveTo 41 106 self)
				)
				(5
					(gEgo setMotion: MoveTo 43 118 self)
				)
				(6
					(door1 setCycle: Beg self)
					(soundFX number: 77 loop: 1 play:)
				)
				(7
					(soundFX stop:)
					(door1 stopUpd:)
					(gEgo observeControl: 64)
					(HandsOn)
				)
			)
		)
		(if (> gTombBarred 1)
			(switch (++ gTombBarred)
				(3
					(door2 startUpd: setCycle: End self)
				)
				(4
					(gEgo setPri: 5 setMotion: MoveTo 164 98)
					(= gTombBarred 1)
				)
				(5
					(door2 startUpd: ignoreActors: 0 setCycle: Beg self)
				)
				(6
					(door2 stopUpd:)
					(HandsOn)
					(= gTombBarred 1)
				)
			)
		)
	)
)

(instance Spectre of Script
	(properties)

	(method (doit &tmp temp0)
		(if (or (== state 1) (== state 2))
			(= temp0 (& (ghost cel:) $0001))
			(ghost setPri: (+ (<< temp0 $0003) 6) posn: 171 (+ temp0 100))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ghost show: setCycle: Walk setMotion: MoveTo 171 100 self)
			)
			(1
				(ghost setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(ghost setLoop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(moodMusic fade:)
				(ghost setLoop: 5 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(moodMusic number: 12 loop: -1 play:)
				(ghost dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local1 (not (ghost script:)))
					(light1 show: setCycle: Fwd)
					(light2 show: setCycle: Fwd)
					(light3 show: setCycle: Fwd)
				else
					(= state 2)
				)
				(= cycles 7)
			)
			(1
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End)
				(soundFX number: 17 loop: 1 play: self)
			)
			(2
				(if (< (Random 1 100) 25)
					(= state -1)
				)
				(= seconds 3)
			)
			(3
				(= state 1)
				(= seconds 5)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 2 23 #dispose) ; "You knock loudly on the tomb door and wait..."
				(gEgo view: 56 loop: 0 setCycle: End self)
			)
			(1
				(soundFX number: 48 loop: 1 play:)
				(gEgo loop: 2 setCycle: Fwd)
				(= cycles 6)
			)
			(2
				(gEgo view: 56 loop: 0 cel: 3 setCycle: Beg)
				(= seconds 3)
			)
			(3
				(cls)
				(Print 2 24) ; "No answer."
				(= cycles 1)
			)
			(4
				(cls)
				(gEgo view: 0 setCycle: Walk loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance crouton of PV
	(properties
		y 46
		x 165
		view 102
		loop 2
		priority 14
	)
)

(instance dijon of PV
	(properties
		y 59
		x 44
		view 102
		loop 2
		cel 1
		priority 14
	)
)

(instance door1 of Prop
	(properties
		y 117
		x 28
		view 102
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 2 25) ; "It looks like a new metal door."
		)
	)
)

(instance door2 of Prop
	(properties
		y 101
		x 154
		view 102
		loop 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 2 12) ; "Granite slabs form the tomb doors."
		)
	)
)

(instance ghost of Act
	(properties
		y 152
		x 161
		view 102
		signal 16384
		illegalBits 0
	)

	(method (handleEvent event)
		(if
			(and
				(self script:)
				(or (MousedOn self event 3) (Said 'look/ghost'))
			)
			(event claimed: 1)
			(Print 2 26) ; "That looks like a wisp of mist from the bayou."
		)
	)
)

(instance light1 of Prop
	(properties
		y 33
		x 257
		view 102
		loop 6
		signal 16384
	)
)

(instance light2 of Prop
	(properties
		y 92
		x 281
		view 102
		loop 7
		signal 16384
	)
)

(instance light3 of Prop
	(properties
		y 126
		x 262
		view 102
		loop 8
		signal 16384
	)
)

(instance moodMusic of Sound
	(properties
		number 17
	)
)

(instance soundFX of Sound
	(properties
		number 17
		priority 5
	)
)

(instance Yard of RFeature
	(properties
		nsTop 107
		nsLeft 87
		nsBottom 179
		nsRight 252
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 2 11) ; "The graves and monuments belong to various members of the Crouton family, ranging from the large monument of patriarch, Francois Crouton and his wife Claudette, to the simple grave of Sarah Crouton, who was 17 when she died in 1871."
		)
	)
)

