;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 514)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	regPan 0
)

(synonyms
	(kiss kiss embrace)
	(pan pan pan man pan pan person animal pan)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance panCage of Cage
	(properties)
)

(instance panTheme of Sound
	(properties)
)

(instance luteMusic of Sound
	(properties
		number 54
	)
)

(instance regPan of Rgn
	(properties)

	(method (init)
		(super init:)
		(if ((Inv at: 0) ownedBy: 201) ; Silver_Flute
			(= local0 157)
			(= local5
				(+ (* (- global160 global211) 60) (- global159 global212))
			)
			(if (and (<= (Random 1 100) 40) (>= local5 2))
				(panCage
					left: 0
					right: 319
					bottom: 189
					top: (gCurRoom horizon:)
					init:
				)
				(Load rsVIEW 157)
				(if (gEgo has: 9) ; Lute
					(Load rsVIEW 54)
					(Load rsVIEW 150)
				)
				(= global172 (Act new:))
				(global172
					posn: (Random 10 300) (Random (+ (gCurRoom horizon:) 20) 169)
					xStep: 2
					yStep: 1
					setCycle: Fwd
					observeBlocks: panCage
					setScript: panActions
					setMotion: Wander 1500
					view: local0
					init:
					yourself:
				)
				(= local4 (Prop new:))
				(local4
					view: 888
					cycleSpeed: 1
					ignoreActors:
					setCycle: Fwd
					init:
				)
				(panTheme number: 7 loop: -1 play:)
			else
				(= global172 0)
			)
		else
			(= global172 0)
		)
	)

	(method (doit)
		(super doit:)
		(if (gCast contains: global172)
			(if (or (== (global172 view:) 158) (== (global172 view:) 157))
				(local4
					setPri: (global172 priority:)
					x: (+ (global172 x:) 8)
					y: (- (global172 y:) 22)
				)
			)
			(if (not (global172 inRect: 0 0 319 219))
				(global172 dispose:)
				(if (IsObject local4)
					(local4 dispose:)
				)
				(panTheme loop: 1 changeState:)
			)
		)
	)

	(method (dispose)
		((ScriptID 0 4) dispose: delete:) ; timer1
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (gCast contains: global172))
			(cond
				((Said 'play/lute')
					(if (gEgo has: 9) ; Lute
						(if (== (global172 view:) 157)
							(gEgo setScript: playLute)
							(playLute changeState: 1)
						else
							(Print 514 0) ; "You've already attracted Pan's attention."
						)
					else
						(Print 800 2) ; "You don't have it."
					)
				)
				((Said 'play/flute')
					(if (gEgo has: 0) ; Silver_Flute
						(if (== (panTheme state:) 3)
							(Print 514 1) ; "You wouldn't want to interfere with Pan's lute music."
						else
							(event claimed: 0)
						)
					else
						(Print 800 2) ; "You don't have it."
					)
				)
				((Said 'hum')
					(Print 514 2) ; "You hum along with Pan, but he doesn't pay any attention."
				)
				((Said 'kill/pan')
					(Print 514 3) ; "You are NOT a murderous girl, Rosella!"
				)
				((Said 'play<with/pan')
					(Print 514 4) ; "You'd like to...but how do you play with a satyr?"
				)
				((Said 'dance')
					(Print 514 5) ; "You couldn't keep up with him, Rosella."
				)
				((Said 'get/pan')
					(Print 514 6) ; "You can't get a satyr!"
				)
				((Said 'capture/pan')
					(Print 514 7) ; "You can't catch a satyr!"
				)
				((Said 'give/lute')
					(if (gEgo has: 9) ; Lute
						(if local2
							(if (< (gEgo distanceTo: global172) 22)
								((Inv at: 9) moveTo: 201) ; Lute
								(Print 514 8) ; "Ok. Pan gratefully accepts your gift of the lute, and in return he gives you his flute. Happy now, he dances away with it."
								((Inv at: 0) moveTo: gEgo) ; Silver_Flute
								(gGame changeScore: 3)
								(gEgo setMotion: 0)
								(global172 view: 158 setMotion: Wander 3000)
								(= local0 158)
								(panTheme number: 8 loop: -1 play:)
								(local4 show:)
							else
								(Print 800 1) ; "You're not close enough."
							)
						else
							(Print 514 9) ; "He isn't paying any attention to you."
						)
					else
						(Print 800 2) ; "You don't have it."
					)
				)
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 514 10) ; "Pan would not be interested in it."
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 514 11) ; "You can't give that."
						(event claimed: 1)
					)
				)
				((Said 'kiss')
					(Print 514 12) ; "He's too strange to kiss."
				)
				((== (global172 view:) 157)
					(cond
						((Said 'look/pan')
							(Print 514 13) ; "You see a lively creature who is, at the same time, both man and goat. He is a satyr, and his name is Pan. He seems to be greatly enjoying his flute music."
						)
						((Said 'talk[/pan]')
							(Print 514 14) ; "You attempt to speak to Pan, but he pays you no mind; he's too wrapped up in his flute music."
						)
						((Said 'get/flute')
							(Print 514 15) ; "You can't. Pan won't give it to you."
						)
						((Said 'rob/flute')
							(Print 514 16) ; "It's not nice to steal."
						)
					)
				)
				((== (global172 view:) 158)
					(cond
						((Said 'get,rob/lute')
							(Print 514 17) ; "You gave it to Pan. It belongs to him."
						)
						((Said 'look/pan')
							(Print 514 18) ; "Pan seems to be quite happy with his new lute. As he plays it, he dances and frolics to the music."
						)
						((Said 'talk[/pan]')
							(Print 514 19) ; "You try to speak to Pan, but he pays no attention to you; he's too involved with his lute music."
						)
					)
				)
				((== (global172 view:) 150)
					(cond
						((Said 'talk[/pan]')
							(Print 514 20) ; "You speak to Pan, but he doesn't respond; he only stares at you expectantly."
						)
						((Said 'look/pan')
							(Print 514 21) ; "Pan has ceased his dancing and now looks at you, and the lute, curiously."
						)
						((Said 'get/flute')
							(Print 514 15) ; "You can't. Pan won't give it to you."
						)
					)
				)
			)
		)
	)
)

(instance playLute of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(panTheme client: 0 stop:)
				(luteMusic play: self)
				(gEgo view: 54 setLoop: 0 setCycle: Fwd)
				(= local3 (Prop new:))
				(local3
					view: 888
					setPri: (gEgo priority:)
					cycleSpeed: 1
					setCycle: Fwd
					posn: (+ (gEgo x:) 15) (- (gEgo y:) 25)
					init:
				)
				(global172
					view: 150
					setAvoider: Avoid
					setCycle: Walk
					setMotion: Follow gEgo 55
				)
				(local4 hide:)
			)
			(2
				(Print 514 21 #at -1 20 #draw) ; "Pan has ceased his dancing and now looks at you, and the lute, curiously."
				(gEgo view: 2 setLoop: -1 setCycle: Walk)
				(if (IsObject local3)
					(local3 dispose:)
				)
				(LookAt gEgo global172)
				(= local2 1)
				(HandsOn)
			)
		)
	)
)

(instance panActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 25)
			)
			(1
				(global172 ignoreBlocks: panCage)
			)
		)
	)
)

