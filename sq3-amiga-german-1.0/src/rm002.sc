;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Timer)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm002 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm002 of Rm
	(properties
		picture 2
		horizon 70
		east 5
		south 3
	)

	(method (init &tmp [temp0 50])
		(if
			(or
				(== gPrevRoomNum 777)
				(== gPrevRoomNum 900)
				(== gPrevRoomNum 1)
				(== gPrevRoomNum 155)
				(== (GameIsRestarting) 1)
			)
			(gLongSong stop:)
			(= local4 1)
		)
		(= global193 0)
		(= global17 0)
		(if (!= gPrevRoomNum 12)
			(self setLocales: 700)
		)
		(Load rsVIEW 12)
		(Load rsVIEW 0)
		(Load rsVIEW 6)
		(Load rsSOUND 11)
		(Load rsSOUND 76)
		(if (== global149 gCurRoomNum)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gPrevRoomNum 12)
			(HandsOff)
			(Load rsVIEW 258)
			(self setScript: grabScript)
		else
			(Load rsVIEW 0)
			(gTheMenuBar state: 1 draw:)
			(SL enable:)
			(if local4
				(Load rsSCRIPT 991)
				(= local3 991)
				(Load rsVIEW 11)
				(Load rsSOUND 4)
				(Load rsSOUND 5)
				(Load rsSOUND 56)
				(gEgo
					view: 11
					loop: 0
					cel: 0
					setPri: 9
					ignoreActors: 1
					illegalBits: 0
					posn: 141 111
					get: 0 ; Glowing_Gem
				)
				(HandsOff)
				(self setScript: doorScript)
			)
			(if (and global200 (== gPrevRoomNum 900) (not local4))
				(HandsOn)
				(gEgo
					view: 0
					setLoop: -1
					loop: 2
					cel: 0
					ignoreActors: 1
					illegalBits: -32768
					setStep: 3 2
					posn: 142 141
					get: 0 ; Glowing_Gem
				)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(= global159 0)
				(gLongSong number: 11 loop: -1 priority: 127 playBed:)
			)
			(if (== gPrevRoomNum 3)
				(gEgo x: 170)
			)
			(gEgo init:)
		)
		(door init:)
		(super init:)
	)

	(method (dispose)
		(if (and (!= gPrevRoomNum 5) (!= gPrevRoomNum 12) (!= gPrevRoomNum 3))
			(DisposeScript 991)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'close/door')
						(Print 2 0) ; "Check again! It IS closed."
					)
					((Said 'look,look>')
						(cond
							(
								(Said
									'<in,through/craft,leech,pane[<escape,escape]'
								)
								(Print 2 1) ; "This task is impossible since the door is sealed from the inside and there is no light emanating from within."
							)
							((Said '/pane')
								(Print 2 2) ; "The window is clear enough to reveal the blackness inside."
							)
							((Said '/door,door')
								(Print 2 3) ; "The solidly built door looks to be locked in place."
							)
							((Said '/nozzle')
								(Print 2 4) ; "The pod's thrusters are very small, designed for minimal attitude adjustments. They have been cold for a long time."
							)
							((Said '/craft,leech[<escape,escape]')
								(Print 2 5) ; "This is the escape pod which safely whisked you away from Vohaul's burning asteroid fortress. The skin of the pod plainly registers the cumulative damage long periods of space travel can inflict on a small craft such as this."
							)
							((Said '[<at,around,in][/area]')
								(Print 2 6) ; "You are standing in a debris-cluttered junk bay. An escape pod rests in the middle of the room. There are chunks of metal lying around which seem to be small sections of old spaceware."
							)
						)
					)
					((Said 'smell,smell,smell[/area,air]')
						(Print 2 7) ; "The room bears a very metallic fragrance."
					)
					((Said 'fix,open,pry/craft,leech,door[<escape,escape]')
						(Print 2 8) ; "The door was automatically sealed when the pod shut down shortly after your exit. It has served its purpose and will be of no further use."
					)
					(
						(Said
							'hoist,hoist,move,freeze,manipulate,press,pull/craft,leech[<escape,escape]'
						)
						(Print 2 9) ; "Despite technological advances in strong, lightweight ship materials, you can't possibly budge it."
					)
					((Said 'start/leech,craft,engine')
						(Print 2 10) ; "It's not available for your use."
					)
					((Said 'break/pane,glass')
						(Print 2 11) ; "If YOU could break the glass, it and you would not have survived the journey here."
					)
					((Said 'climb/craft,leech[<escape,escape]')
						(Print 2 12) ; "You are unable to scale it."
					)
					((Said 'climb')
						(Print 2 13) ; "You are unable to scale anything here."
					)
					(
						(or
							(Said
								'climb,get,get<in,in/craft,leech[<escape,escape]'
							)
							(Said
								'enter,board,board[/craft,leech[<escape,escape]]'
							)
						)
						(Print 2 14) ; "It is locked. You are unable to gain access."
					)
					((Said 'qa')
						(if (not global200)
							(event claimed: 0)
							(return)
						)
						(switch
							(= local5
								(Print ; "Where Do You What To Start? (Press ESC to Stay Here)"
									2
									15
									#mode
									1
									#title
									{QA-O-Matic}
									#button
									{Space}
									1
									#button
									{Phleebhut}
									2
									#button
									{Ortega}
									3
									#button
									{Pestulon}
									4
									#button
									{End}
									5
								)
							)
							(1
								(= global136 4)
								((gInventory at: 3) moveTo: 14) ; Reactor
								((gInventory at: 1) moveTo: 14) ; Wire
								(= global149 0)
								(= global135 4)
								(= global203 1)
								(= global210 1)
								(= global207 1)
								(= global208 2)
								(= global206 3)
								(= gScore 134)
								(gGame changeScore: 1)
								(RedrawCast)
								(gCurRoom newRoom: 14)
							)
							(2
								(= global136 4)
								((gInventory at: 3) moveTo: 14) ; Reactor
								((gInventory at: 1) moveTo: 14) ; Wire
								(= global149 0)
								(= global135 4)
								(= global210 6)
								(= global214 39)
								(= global213 39)
								(= global161 3)
								(= global162 4)
								(= global163 3)
								(= global164 4)
								(RedrawCast)
								(gCurRoom newRoom: 21)
							)
							(3
								(= global136 4)
								((gInventory at: 3) moveTo: 14) ; Reactor
								((gInventory at: 1) moveTo: 14) ; Wire
								(= global149 0)
								(= global135 4)
								(= global210 5)
								(= global214 82)
								(= global213 82)
								(= global161 10)
								(= global162 7)
								(= global163 10)
								(= global164 7)
								(RedrawCast)
								(gCurRoom newRoom: 21)
							)
							(4
								(= global136 4)
								((gInventory at: 3) moveTo: 14) ; Reactor
								((gInventory at: 1) moveTo: 14) ; Wire
								(= global149 0)
								(= global135 4)
								(PutItem 0 0) ; Glowing_Gem
								(= global210 8)
								(= global214 69)
								(= global213 69)
								(= global161 9)
								(= global162 6)
								(= global163 9)
								(= global164 6)
								(RedrawCast)
								(gCurRoom newRoom: 21)
							)
							(5
								(= global136 4)
								((gInventory at: 3) moveTo: 14) ; Reactor
								((gInventory at: 1) moveTo: 14) ; Wire
								(= global149 0)
								(= global135 4)
								(= global210 7)
								(= global214 69)
								(= global213 69)
								(= global161 9)
								(= global162 6)
								(= global163 9)
								(= global164 6)
								(RedrawCast)
								(gCurRoom newRoom: 94)
							)
						)
					)
				)
			)
		)
	)

	(method (doit)
		(if (or (== (gEgo view:) 0) (== (gEgo view:) 6))
			(cond
				(
					(or
						(== (gEgo onControl: 0) 4)
						(== (gEgo onControl: 0) 5)
					)
					(gEgo view: 6)
				)
				((== (gEgo onControl: 0) 1)
					(gEgo view: 0)
				)
			)
		)
		(super doit:)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(= seconds 3)
			)
			(1
				(doorSound play:)
				(= cycles 20)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(door stopUpd:)
				(= cycles 8)
			)
			(4
				(gEgo setPri: 10 cycleSpeed: 1 setCycle: End self)
			)
			(5
				(= cycles 7)
			)
			(6
				(gEgo loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(7
				(= cycles 7)
			)
			(8
				(gEgo setCycle: End self)
			)
			(9
				(= cycles 10)
			)
			(10
				(gEgo loop: 2 cel: 0 setCycle: 0)
				(= cycles 10)
			)
			(11
				(gEgo loop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(12
				(gEgo
					cycleSpeed: 0
					setStep: -1 10
					setMotion: JumpTo 142 141 self
				)
			)
			(13
				(gEgo setCycle: End self)
				(thump playBed:)
			)
			(14
				(= cycles 7)
			)
			(15
				(gEgo setCel: (- (gEgo cel:) 1))
				(= cycles 5)
			)
			(16
				(gEgo
					view: 0
					loop: 2
					cel: 0
					illegalBits: -32768
					setStep: -1 2
					setCycle: Walk
					setPri: -1
				)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(= global159 0)
				(= cycles 10)
			)
			(17
				(Print 2 16 #at -1 20 #width 280) ; "You notice that the sounds from the pod grow softer until they are imperceptible. Having served its purpose and taxed its resources, the pod gives a final hum and shuts down."
				(door setPri: 9 setCycle: Beg self)
				(= cycles 2)
			)
			(18
				(doorSound number: 5 play:)
			)
			(19
				(door stopUpd:)
			)
			(20
				(door setLoop: 1 forceUpd:)
				(= seconds 2)
			)
			(21
				(HandsOn)
				(gLongSong number: 11 loop: -1 priority: 127 playBed:)
			)
		)
	)

	(method (doit)
		(if (and (== (self state:) 19) (not (doorSound handle:)))
			(self cue:)
		)
		(super doit:)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local0 (Actor new:))
					view: 258
					setLoop: (if (== global135 3) 2 else 0)
					setPri: (if global147 13 else 10)
					setStep: 1 2
					x: (if global147 166 else 72)
					y: -16
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if global147 166 else 72) 153 self
				)
			)
			(1
				(if (== global147 0)
					(local0 setPri: 13)
				)
				(Timer set: self 2)
			)
			(2
				(if (== global147 0)
					(local0 setPri: 10)
				)
				(cond
					((== global135 3)
						(= global148 4)
						(= global135 global147)
						(motivator init:)
						(= global149 gCurRoomNum)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: -15)
						(RedrawCast)
						(Print 2 17) ; "Sensing an adequate surface the claw releases its cargo and begins the ascent to the grabber unit."
					)
					((and (== global149 gCurRoomNum) (== global135 global147))
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(local0 setLoop: 2)
						(motivator hide:)
						(= global149 0)
						(= global135 3)
						(= global148 5)
						(RedrawCast)
						(Print 2 18) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 2 19) ; "Finding nothing here to carry, the claw begins the ascent to the grabber unit."
						(= global148 4)
					)
				)
				(self changeState: 3)
			)
			(3
				(local0
					setLoop: (if (== global135 3) 2 else 0)
					setMotion: MoveTo (if global147 166 else 72) -16 self
				)
			)
			(4
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance motivator of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 36
			setLoop: 0
			setCel: 0
			x: (if (== global135 1) 183 else 87)
			y: 169
			stopUpd:
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '/motivator,artifact,machine')
						(if global186
							(Print 2 20) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(PrintSplit 2 21) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,eightprong]')
							(Said '/eightprong[<8]')
						)
						(Print 2 22) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(Print 2 23) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal plates appear to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			((Said '(turn<on),start/motivator,artifact,machine')
				(Print 2 24) ; "You aren't capable of doing that."
			)
			(
				(Said
					'turn,get,get,move,freeze,manipulate,press,roll,pull/machine,motivator,artifact'
				)
				(Print 2 25) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said 'remove,pull,press,get,get/plug[<modular,8,eightprong]')
				(Print 2 26) ; "You can't. It's permanently attached."
			)
		)
	)
)

(instance door of Prop
	(properties
		view 12
	)

	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setLoop: (if local4 0 else 1)
			setPri:
				(if (or (== gPrevRoomNum 5) (== gPrevRoomNum 3) (not local4)) 9 else 10)
			ignoreActors: 1
			posn: 138 115
			stopUpd:
		)
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 10
	)
)

(instance doorSound of Sound
	(properties
		number 4
	)
)

