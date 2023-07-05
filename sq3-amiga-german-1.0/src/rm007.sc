;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
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
	rm007 0
)

(local
	local0
	local1
)

(instance rm007 of Rm
	(properties
		picture 7
		style 0
		horizon 10
		west 6
	)

	(method (init &tmp [temp0 50])
		(if (== gPrevRoomNum 11)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(self setLocales: 700)
			(Load rsVIEW 0)
			(Load rsVIEW 6)
			(Load rsVIEW 14)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
		)
		(if (== global149 gCurRoomNum)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gPrevRoomNum 6)
			(gEgo view: 0)
		else
			(Load rsSOUND 56)
		)
		(super init:)
		(self setScript: rmScript)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '[<around,at,in][/area]')
						(Print 7 0) ; "The gutted carcass of the tanker opens up to reveal even more junk. A metal head rests nearby."
					)
					((Said '<in,at,in,in/craft,stage,wreck')
						(Print 7 1) ; "It's quite dark in there, but there is a light at the end of the tunnel."
					)
					((Said '/craft,stage,wreck')
						(Print 7 2) ; "Not much remains. If there was anything of value, it was stripped away a long time ago."
					)
					((Said '/head,android,artifact,helmet')
						(Print 7 3) ; "Wow! An ancient model of a Battlebot. I bet you'd hate to run into whatever brought this big guy down. It looks like something poked it in the eye."
					)
					((Said '/eye[<broken,glass,android]')
						(Print 7 4) ; "There are two eyes on the battlebot head. One of them has been broken."
					)
					((Said '<in,in,in/android,eye[<broken,glass]')
						(Print 7 5) ; "You can't see anything from down here."
					)
					((Said '[<at,in,through,in]/grate')
						(Print 7 6) ; "They're just small air ducts for the robot."
					)
					((Said '/pyramid,(protrusion<dense,metallic)')
						(Print 7 7) ; "The pyramid is nothing more than a dense metallic protrusion."
					)
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(Print 7 8) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal appears to have been cut from a variety of sources. The floor drops off near the large robot."
					)
					((Said '/down,(edge[<deck])')
						(if (gEgo inRect: 32 156 192 189)
							(Print 7 9) ; "The piles of scrap drop off here. It looks dark and dangerous down there."
						else
							(NotClose) ; "It's not quite within reach."
						)
					)
				)
			)
			((Said 'craft')
				(Print 7 10) ; "It isn't a ship. It's an ancient model of a Battlebot. I bet you'd hate to run into whatever brought this big guy down. It looks like something poked it in the eye."
			)
			(
				(Said
					'enter,climb,crawl,go[<on,in,in,through,up,in][/android,eye,head,pane[<broken,to]]'
				)
				(if (gEgo inRect: 160 163 178 180)
					(rmScript changeState: 4)
				else
					(Print 7 11) ; "You can't from this location."
				)
			)
			((Said 'enter,climb[<in,in,up,in]/grate[<android]')
				(Print 7 12) ; "You're intellectual profile may be slim, but you still are too thick to enter that."
			)
			(
				(Said
					'move,freeze,manipulate,press,pull,hoist,hoist/head,android,helmet'
				)
				(Print 7 13) ; "Whatever you say, Superman."
			)
			((Said 'climb<down')
				(Print 7 14) ; "Get closer."
			)
			((Said 'get,get/head')
				(Print 7 15) ; "I don't think you're man enough!"
			)
			((Said 'give/head')
				(Print 7 16) ; "Sounds like you want to be doing something besides playing a dumb game."
			)
			((Said 'break,remove/android,eye[<broken,glass]')
				(Print 7 17) ; "You don't need to do that. Besides, one of them is already broken."
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

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 11)
					(self setScript: grabScript)
				else
					(gEgo setStep: -1 2)
					(if (== gPrevRoomNum 8)
						(gEgo
							view: 14
							cel: (gEgo lastCel:)
							illegalBits: 0
							posn: 195 171
							setPri: 13
							init:
							cycleSpeed: 1
						)
						(self changeState: 6)
					else
						(gEgo posn: 9 113 init:)
					)
				)
			)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					view: 17
					cel: 0
					setLoop: 2
					cycleSpeed: 2
					setCycle: End self
					setMotion: 0
				)
			)
			(2
				(thump number: 45 playBed:)
				(gEgo
					setCycle: 0
					setStep: -1 15
					setMotion: MoveTo (gEgo x:) 240 self
				)
			)
			(3
				(Print 7 18) ; "Oh, gosh! You've stepped off a metallic escarpment and tumbled into the darkness. Twisted, jagged remnants of old vehicles reach out to slow your dark descent, cutting short your life in the process."
				(EgoDead 901 0 0 1)
				(return)
			)
			(4
				(HandsOff)
				(gEgo
					illegalBits: 0
					view: 14
					cel: 0
					posn: 195 171
					setPri: 13
					setCycle: End self
					setMotion: 0
					cycleSpeed: 1
				)
			)
			(5
				(if (not global596)
					(= global596 1)
					(gGame changeScore: 5)
				)
				(gCurRoom newRoom: 8)
			)
			(6
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(7
				(thump number: 56 playBed:)
				(HandsOn)
				(gEgo
					view: 0
					setLoop: -1
					setPri: -1
					posn: 168 169
					loop: 2
					cel: 0
					setCycle: Walk
					setStep: 3 2
					illegalBits: -32768
					moveSpeed: 0
					cycleSpeed: 0
				)
			)
		)
	)

	(method (doit)
		(if (and (== (gEgo onControl: 0) 2) (!= (gEgo view:) 17))
			(self changeState: 1)
		)
		(super doit:)
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
			setStep: 1 1
			illegalBits: 0
			x: (if (== global135 1) 217 else 119)
			y: 81
			setPri: 4
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
							(Print 7 19) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(Print 7 20) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,eightprong]')
							(Said '/eightprong[<8]')
						)
						(Print 7 21) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					((Said '[<down,below,at][/dirt,deck]')
						(Print 7 22) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal appears to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			(
				(Said
					'remove,get,get,move,freeze,manipulate,press,roll,pull/motivator,artifact,machine'
				)
				(Print 7 23) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said '(turn<on),start/motivator,artifact,machine')
				(Print 7 24) ; "You aren't capable of doing that."
			)
			((Said 'remove,press,pull,get,get/plug[<modular,8,eightprong]')
				(Print 7 25) ; "You can't. It's permanently attached."
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local1 (Actor new:))
					name: {Claw}
					view: 258
					setLoop: (if (== global135 3) 2 else 0)
					setPri: 5
					setStep: 1 2
					x: (if global147 202 else 105)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if global147 202 else 105) 65 self
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
						(motivator init:)
						(= global149 gCurRoomNum)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: -15)
						(RedrawCast)
						(Print 7 26) ; "Sensing the floor the claw releases its cargo and begins the ascent to the grabber unit."
					)
					((and (== global149 gCurRoomNum) (== global135 global147))
						(local1 setLoop: 2)
						(motivator hide:)
						(= global149 0)
						(= global135 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(RedrawCast)
						(Print 7 27) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 7 28) ; "Finding nothing here the claw begins to ascend to the grabber unit."
						(= global148 4)
					)
				)
				(self changeState: 3)
			)
			(3
				(local1
					setLoop: (if (== global135 3) 2 else 0)
					setMotion: MoveTo (local1 x:) -19 self
				)
			)
			(4
				(gCurRoom newRoom: 11)
			)
		)
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 10
	)
)

