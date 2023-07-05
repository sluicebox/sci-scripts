;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm004 0
)

(local
	local0
)

(instance rm004 of Rm
	(properties
		picture 4
		style 0
		west 3
	)

	(method (init &tmp [temp0 50])
		(if (!= gPrevRoomNum 9)
			(self setLocales: 700)
		else
			(HandsOff)
		)
		(SL enable:)
		(Load rsVIEW 13)
		(if (== global149 gCurRoomNum)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gPrevRoomNum 9)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(Load rsVIEW 0)
			(Load rsVIEW 6)
			(gEgo init:)
		)
		(Load rsSOUND 41)
		(gLongSong number: 41 loop: -1 priority: 1 play:)
		(bucket init:)
		(super init:)
		(if (== gPrevRoomNum 9)
			(gEgo setScript: grabScript)
		else
			(HandsOn)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look,look>')
						(cond
							(
								(Said
									'/bucket,conveyer,conveyer,machine,elevator,hoist,hoist[/belt]'
								)
								(Print 4 0) ; "Buckets are attached to a conveyer. They haul metal debris to a horizontal conveyer above."
							)
							((Said '[<around,at,in][/area]')
								(Print 4 1) ; "You are overwhelmed by the variety of space trash around each corner. A large bucket conveyer carries shredded ships to a horizontal conveyer high above."
							)
							(
								(Said
									'[<at]/hand,appendage,finger,appendage,branch[<android,big]'
								)
								(Print 4 2) ; "Somewhere there's an oversized android missing a limb."
							)
							((Said '/jup,craft,craft,2,leech')
								(Print 4 3) ; "It says Jupiter 2. This baby must have been floating around out there for a long time. It doesn't hold your interest for very long."
							)
							(
								(Said
									'[<in,in,through,at]/craft,craft,pane,port,jup,2,leech'
								)
								(Print 4 4) ; "The viewport is too high. Besides, you'd not see anything interesting."
							)
							((Said '/nozzle')
								(Print 4 5) ; "None are visible."
							)
							((Said '/cog,wheel')
								(Print 4 6) ; "Hoooo boy! It's a big one."
							)
							((Said '/box,block,toaster,pole')
								(Print 4 7) ; "The item in question is just another piece in a fine collection of worthless junk carelessly splashed around the picture by the graphic artist. (You know who you are.)"
							)
							((Said '/pit')
								(Print 4 8) ; "You peer up and down the conveyer shaft. The view down is obstructed by the tight fit of the conveyer. The view up show it to lead to a horizontal conveyer above."
							)
						)
					)
					(
						(Said
							'stop,(turn<off),(close<down)/conveyer,conveyer,elevator,hoist,hoist'
						)
						(Print 4 9) ; "That's not within your power."
					)
					(
						(Said
							'break,open/pane,glass,dome,port,(cavity<port),finger,hand,appendage,appendage'
						)
						(Print 4 10) ; "You can't do that, nor would it be helpful."
					)
					(
						(Said
							'board,board,enter,(get,get<on,on,in,in),(climb,step,stair<in,up,in,on,on)/bucket,conveyer,conveyer,tower'
						)
						(Print 4 11) ; "Looks dangerous but go ahead, you thrill seeker, you. You'll need to get closer though."
					)
					((Said 'climb[<on,up]/craft,craft,leech,jup,2')
						(Print 4 12) ; "You are not skilled in ship climbing."
					)
					(
						(Said
							'hoist,hoist,move,freeze,manipulate,press,pull/craft,craft,leech,jup,2'
						)
						(Print 4 13) ; "Despite technological advances in strong, lightweight ship materials, you can't possibly budge it."
					)
					(
						(Said
							'bite,bite,tickle,buff/hand,appendage,appendage[<android,big,green,green]'
						)
						(Print 4 14) ; "Sounds a little kinky. Maybe you should do that when no one else is around."
					)
					(
						(Said
							'get,get,move,freeze,manipulate,pull,press,hoist,hoist[<up]/box,block,toaster,pole'
						)
						(Print 4 15) ; "The item in question, which is just another piece in a fine collection of worthless junk carelessly splashed around the picture by the graphic artist, isn't needed by you."
					)
					(
						(Said
							'get,get,move,freeze,manipulate,pull,press,hoist,hoist,get,get,climb/hand,appendage,appendage,finger[<android,big]'
						)
						(Print 4 16) ; "No."
					)
					((Said 'get,get>')
						(if (Said '/cog,wheel')
							(Print 4 17) ; "Yeah, right! That's just what you need."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 9)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
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
		(if
			(and
				(gCast contains: gEgo)
				(== (gEgo onControl: 0) 3)
				(> (bucket y:) 89)
				(< (bucket y:) 105)
			)
			(HandsOff)
			(gEgo dispose:)
			(bucket setCel: 2)
			(if (not global239)
				(= global239 1)
				(gGame changeScore: 5)
			)
			(= global132 1)
		)
		(super doit:)
	)
)

(instance bucket of Act
	(properties)

	(method (init)
		(super init:)
		(bucket
			view: 13
			setPri: 6
			setCel: (Random 0 1)
			setLoop: 0
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			posn: 242 65
			setStep: -1 2
			moveSpeed: 1
			setCycle: 0
			setMotion: MoveTo 242 -3 self
			setScript: bScript
		)
	)
)

(instance bScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bucket setPri: 6)
			)
			(1
				(if (== (bucket cel:) 2)
					(gCurRoom newRoom: 9)
				else
					(bucket
						setCel: (Random 0 1)
						posn: 242 107
						setMotion: MoveTo 242 -3 self
					)
					(self state: (- state 1))
				)
			)
		)
	)
)

(instance motivator of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 36
			setLoop: 0
			setCel: 0
			x: (if (== global135 1) 227 else 102)
			y: 128
			setPri: 9
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
							(Print 4 18) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(Print 4 19) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,eightprong]')
							(Said '/eightprong[<8]')
						)
						(Print 4 20) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					((Said '[<down,below,at][/dirt,deck]')
						(Print 4 21) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal plates appear to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			((Said 'pull,press,remove,get,get/plug[<modular,8,eightprong]')
				(Print 4 22) ; "You can't. It's permanently attached."
			)
			(
				(Said
					'turn,get,get,move,freeze,manipulate,press,roll,pull/motivator,artifact,machine'
				)
				(Print 4 23) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said '(turn<on),start/motivator,artifact,machine')
				(Print 4 24) ; "You aren't capable of doing that."
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local0 (Act new:))
					name: {Claw}
					view: 258
					setLoop: (if (== global135 3) 2 else 0)
					setPri: 9
					setStep: 1 2
					x: (if global147 211 else 88)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if global147 211 else 88) 112 self
				)
			)
			(1
				(Timer set: self 2)
			)
			(2
				(cond
					((== global135 3)
						(= global148 4)
						(= global135 global147)
						(clunkTune play:)
						(gGame changeScore: -15)
						(motivator init:)
						(RedrawCast)
						(= global149 gCurRoomNum)
						(Print 4 25) ; "Sensing the floor, the claw releases its cargo and begins the ascent to the grabber unit."
					)
					((and (== global149 gCurRoomNum) (== global135 global147))
						(local0 setLoop: 2)
						(motivator hide:)
						(= global149 0)
						(clunkTune play:)
						(gGame changeScore: 15)
						(= global135 3)
						(= global148 5)
						(RedrawCast)
						(Print 4 26) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 4 27) ; "Finding nothing here, the claw begins to ascend to the grabber unit."
						(= global148 4)
					)
				)
				(self changeState: 3)
			)
			(3
				(local0
					setLoop: (if (== global135 3) 2 else 0)
					setMotion: MoveTo (local0 x:) -19 self
				)
			)
			(4
				(gCurRoom newRoom: 9)
			)
		)
	)
)

(instance clunkTune of Sound
	(properties
		number 76
		priority 15
	)
)

