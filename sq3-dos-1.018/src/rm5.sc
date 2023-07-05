;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm5 0
)

(local
	local0
)

(instance rm5 of Rm
	(properties
		picture 5
		style 0
		horizon 10
		west 2
	)

	(method (init &tmp [temp0 50])
		(if (!= gPrevRoomNum 9)
			(self setLocales: 700)
		)
		(SL enable:)
		(if (== gPrevRoomNum 9)
			(HandsOff)
		)
		(if (== global149 gCurRoomNum)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gPrevRoomNum 9)
			(Load rsSOUND 76)
			(Load rsVIEW 258)
		else
			(Load rsVIEW 0)
			(gEgo init:)
		)
		(super init:)
		(self setScript: rmScript)
	)

	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							(
								(or
									(Said '<in,in,through/craft,stage[<eva]')
									(Said '[<in,in,through,at]/pit,tube')
								)
								(Print 5 0) ; "It's quite dark in there, but there is a light at the end of the tunnel."
							)
							((Said '[<at]/craft,stage')
								(Print 5 1) ; "Not much remains. If there was anything of value, it was stripped away a long time ago."
							)
							(
								(or
									(Said
										'[<at]/bone,android,protrusion[<metallic]'
									)
									(Said
										'[<at]/appendage,head[<bone,android,protrusion[<metallic]]'
									)
								)
								(Print 5 2) ; "It looks to be another metallic menace whose time has come and gone. Hopefully, fate will be kinder to you."
							)
							((Said '/mog,finger,head,appendage[<android,man]')
								(Print 5 3) ; "Its metallic parts are frozen in place. I'll bet you're glad you weren't around when it was functional."
							)
							((Said '[<around,at,in][/area,!*]')
								(Print 5 4) ; "You are quite impressed by the size of this junk freighter. The skeletal remains of a stripped-down space tanker stage lie half buried in scrap."
							)
						)
					)
					((Said 'talk/man,mog,android')
						(Print 5 5) ; "It falls on non-existent ears."
					)
					((Said 'climb,crawl/craft,stage')
						(Print 5 6) ; "The gutted ship is unsafe for any such action."
					)
					((Said 'crawl/console')
						(Print 5 7) ; "You don't fit"
					)
					((Said 'get/toaster')
						(Print 5 8) ; "You can't."
					)
					(
						(Said
							'get,explore,climb[<on,onto,up]/bone,android,protrusion[<metallic]'
						)
						(Print 5 9) ; "Let the poor thing rest in peace. It can't help you anyway."
					)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(not (event claimed:))
						(gEgo inRect: 0 137 310 145)
						(> (event x:) 174)
						(< (event y:) 149)
					)
					(gEgo setMotion: MoveTo (event x:) (gEgo y:))
					(event claimed: 1)
				)
			)
		)
	)

	(method (doit)
		(if (and (gEgo inRect: 152 138 292 148) (>= (gEgo x:) 289))
			(gCurRoom newRoom: 6)
		)
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

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(global157
						(gEgo setMotion: MoveTo 292 144)
					)
					((== gPrevRoomNum 9)
						(motivator setScript: grabScript)
					)
					((== gPrevRoomNum 6)
						(gEgo setStep: -1 2 posn: 288 142 init:)
					)
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
			x: (if (== global135 1) 147 else 46)
			y: 127 species 9
			stopUpd:
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '/motivator,artifact,device')
						(if global186
							(Print 5 10) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(Print 5 11) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(Print 5 12) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					((Said '[<down,below,at][/dirt,deck]')
						(Print 5 13) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal plates appear to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			(
				(Said
					'turn,get,manipulate,press,roll,pull/motivator,artifact,device'
				)
				(Print 5 14) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said '(turn<on),start/motivator,artifact,device')
				(Print 5 15) ; "You aren't capable of doing that."
			)
			((Said 'press,pull,remove,get/plug[<modular,8,spaceware]')
				(Print 5 16) ; "You can't. It's permanently attached."
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
					view: 258
					setLoop: (if (== global135 3) 2 else 0)
					setPri: 9
					setStep: 1 2
					x: (if global147 134 else 30)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if global147 134 else 30) 110 self
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
						(Print 5 17) ; "Sensing the floor the claw releases its cargo and begins the ascent to the grabber unit."
					)
					((and (== global149 gCurRoomNum) (== global135 global147))
						(local0 setLoop: 2)
						(motivator hide:)
						(= global149 0)
						(= global135 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(RedrawCast)
						(Print 5 18) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 5 19) ; "Finding nothing here the claw begins to ascend to the grabber unit."
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

