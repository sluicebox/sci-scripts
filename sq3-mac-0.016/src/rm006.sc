;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm006 0
)

(local
	local0
)

(instance rm006 of Rm
	(properties
		picture 6
		style 0
		horizon 10
	)

	(method (init &tmp [temp0 50])
		(self setLocales: 700)
		(Load rsVIEW 7)
		(Load rsVIEW 15)
		(Load rsVIEW 18)
		(Load rsVIEW 751)
		(Load rsVIEW 192)
		(Load rsVIEW 0)
		(Load rsSOUND 77)
		(gEgo view: 0 setStep: -1 1)
		(super init:)
		(gEgo
			setAvoider: (Avoid new:)
			x: (if (== gPrevRoomNum 5) -6 else 326)
			y: 147
			setMotion: MoveTo (if (== gPrevRoomNum 5) 400 else -400) 147
			init:
		)
		(User prevDir: (if (== gPrevRoomNum 5) 3 else 7))
		(shadow init:)
		(if (IsItemAt 1) ; Wire
			(wire init:)
		)
	)

	(method (handleEvent event)
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
									(Said '[<up,above,at]/ceiling')
									(Said '<up,above[/ceiling]')
								)
								(Print 6 0) ; "You see another boring ceiling."
							)
							((Said '/partition')
								(Print 6 1) ; "The walls are made of metal. Missing panels reveal old frayed wires."
							)
							((Said '/door,console[<absent]')
								(Print 6 2) ; "One panel lies wedged against the wall. The other remaining panels are welded in place and are quite uninteresting in appearance."
							)
							((Said '<below/console[<absent]')
								(Print 6 3) ; "It's against the wall covering only more wall."
							)
							(
								(or
									(Said '[<down,below,at]/dirt,deck')
									(Said '<down,below[/dirt,deck]')
								)
								(Print 6 4) ; "You see another boring floor."
							)
							(
								(Said
									'[<around,at,in][/area,tube,cave,pit,stage,!*]'
								)
								(Print 6 5) ; "Someone (or someTHING) has done a real job on this tanker. Was this the result of some space battle? Or perhaps you're not the only one roaming around in here."
							)
							((Said '/cable<left,fine')
								(if (IsItemAt 1) ; Wire
									(Print 6 6) ; "It looks to have survived better than its co-conductors."
								)
							)
							((Said '/cable[<bad,jagged,all]')
								(if (IsItemAt 1) ; Wire
									(Print 6 7) ; "Except for the one on the left, most of the wires here look dangerously worn."
								else
									(Print 6 8) ; "All the wires here look dangerously worn."
								)
							)
							((Said '[<in,at,through,in]/grate')
								(Print 6 9) ; "You see nothing but darkness."
							)
							((Said '/mice,animal')
								(cond
									((gCast contains: rat)
										(Print 6 10) ; "You only are able to see gray, furry blur. It looks like a rat."
									)
									(global131
										(Print 6 11) ; "The fur-bearing pocket prober isn't currently present."
									)
									(else
										(Print 6 12) ; "Funny. I don't see that in this picture."
									)
								)
							)
							((Said '[<in,in,through,at]/cavity')
								(Print 6 13) ; "You don't notice a hole."
							)
							((Said '/conduit')
								(Print 6 14) ; "The pipes are useless, as they are punctured in many places."
							)
						)
					)
					((Said 'climb/craft,pit,craft,side')
						(Print 6 15) ; "There is nowhere for you to climb to."
					)
					((Said 'get,(pull[<on])/cable')
						(if (IsItemAt 1) ; Wire
							(if (gEgo inRect: 64 147 85 149)
								(self setScript: wireScript)
							else
								(Print 6 16) ; "There are no decent wires within reach."
							)
						else
							(Print 6 17) ; "There is no other wire here worthy of your acquisition."
						)
					)
					((Said 'get/conduit')
						(Print 6 18) ; "They're useless."
					)
					((Said 'get,climb,crawl,hide[<in,in,through,below]/grate')
						(Print 6 19) ; "You can't."
					)
					(
						(Said
							'press,hoist,manipulate,open,get,remove/console,(iron[<sheet])'
						)
						(Print 6 20) ; "The panel is of no use."
					)
				)
			)
			(evMOUSEBUTTON
				(if (== (User controls:) 0)
					(return)
				)
				(gEgo
					setMotion:
						MoveTo
						(cond
							((< (event x:) 30) -30)
							((> (event x:) 295) 330)
							(else
								(event x:)
							)
						)
						(gEgo y:)
				)
				(event claimed: 1)
			)
			($0040 ; direction
				(if (== (User controls:) 0)
					(return)
				)
				(switch (event message:)
					(JOY_UP
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWN
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			(
				(and
					(gEgo has: 3) ; Reactor
					(gEgo inRect: 160 146 171 150)
					(not global131)
					(not (gCast contains: rat))
				)
				(rat init:)
			)
			((< (gEgo x:) -6)
				(gCurRoom newRoom: 5)
			)
			((> (gEgo x:) 326)
				(gCurRoom newRoom: (if global157 27 else 7))
			)
		)
		(super doit:)
	)
)

(instance wireScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 192
					loop: (if (< (gEgo x:) (wire x:)) 1 else 0)
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(wire dispose:)
				(gEgo get: 1) ; Wire
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 cycleSpeed: 0 setCycle: Walk)
				(= cycles 2)
				(gGame changeScore: 5)
			)
			(5
				(Print 6 21) ; "You take the only decent piece of wire available."
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance shadowScript of Script
	(properties)

	(method (doit)
		(if
			(or
				(gEgo inRect: -9 145 56 150)
				(gEgo inRect: 281 145 329 150)
			)
			(shadow loop: (gEgo loop:) cel: (gEgo cel:))
			(if (gEgo inRect: -9 145 56 150)
				(shadow view: 7)
			else
				(shadow view: 18)
			)
			(shadow
				posn:
					(if (gEgo inRect: -9 145 56 150)
						(+ (gEgo x:) 12)
					else
						(- (gEgo x:) 12)
					)
					147
			)
			(if (!= local0 1)
				(shadow show:)
				(= local0 1)
			)
		else
			(shadow hide:)
			(= local0 0)
		)
		(super doit:)
	)
)

(instance ratScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rat setMotion: MoveTo 197 (+ (gEgo y:) 4) self)
				(= global131 1)
			)
			(1
				(User canInput: 0)
				(rat
					setStep: -1 5
					setLoop: -1
					loop: 1
					setCycle: Walk
					setMotion: Chase gEgo 4 self
				)
			)
			(2
				(HandsOff)
				(rumbleSound play:)
				(gEgo setMotion: 0)
				(rat
					setStep: 1 1
					posn: (gEgo x:) (- (gEgo y:) 4)
					setLoop: 3
					setCycle: Fwd
					setPri: 14
				)
				(= seconds 2)
			)
			(3
				(biff init:)
				(= seconds 2)
			)
			(4
				(biff setCel: 1 posn: (+ (rat x:) 17) (- (rat y:) 12))
				(= seconds 2)
				(if (gEgo has: 3) ; Reactor
					(PutItem 3 15) ; Reactor
					(gGame changeScore: -15)
				)
				(if (gEgo has: 1) ; Wire
					(PutItem 1 15) ; Wire
					(gGame changeScore: -5)
				)
			)
			(5
				(biff dispose:)
				(= seconds 2)
			)
			(6
				(gEgo view: 751 loop: 0)
				(rat
					setLoop: 0
					x: (+ (gEgo x:) 13)
					y: (+ (gEgo y:) 4)
					setStep: 10
					setMotion: MoveTo 310 (+ (gEgo y:) 4) self
				)
				(rumbleSound stop:)
			)
			(7
				(rat dispose:)
				(RedrawCast)
				(HandsOn)
				(gEgo view: 0 setDirection: 0)
				(RedrawCast)
				(Print 6 22) ; "You seem to have been mugged by some type of large rat. As you pick loose fur from your teeth you notice a less bulky feeling."
			)
		)
	)
)

(instance rat of Act
	(properties
		view 15
	)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			illegalBits: 0
			setLoop: 2
			posn: 197 78
			setStep: 5 15
			setMotion: MoveTo 197 (+ (gEgo y:) 4) self
			setScript: ratScript
		)
	)
)

(instance wire of View
	(properties
		view 192
		loop 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 posn: 77 124)
	)
)

(instance shadow of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (if (== gPrevRoomNum 5) 7 else 18)
			setLoop: (if (== gPrevRoomNum 5) 0 else 1)
			ignoreActors: 1
			x: (if (== gPrevRoomNum 5) 6 else 314)
			y: 147
			setPri: 4
			setScript: shadowScript
			ignoreActors: 1
		)
	)
)

(instance biff of View
	(properties
		view 15
	)

	(method (init)
		(super init:)
		(self
			setLoop: 4
			setCel: 0
			setPri: 15
			ignoreActors: 1
			posn: (- (rat x:) 15) (- (rat y:) 22)
		)
	)
)

(instance rumbleSound of Sound
	(properties
		number 77
		priority 5
		loop -1
	)
)

