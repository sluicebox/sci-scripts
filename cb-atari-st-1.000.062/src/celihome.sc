;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 262)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	celihome 0
)

(synonyms
	(celie person woman)
)

(local
	local0
	local1
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 40 10 #font 4 #mode 1 #draw #dispose)
)

(instance Celie of Act
	(properties
		view 480
	)
)

(instance CHead of Prop
	(properties
		y 102
		x 227
		view 489
		loop 1
		priority 10
		signal 16
	)
)

(instance celihome of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(Load rsVIEW 489)
		(Load rsFONT 4)
		(LoadMany rsVIEW 480 901)
		(= global213 2)
		(if global108
			(Celie
				view: 480
				illegalBits: 0
				loop: 4
				cel: 0
				posn: 123 147
				init:
				setScript: cook
			)
		else
			(Celie posn: 123 147 init: setScript: sitDown)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/celie')
					(= global213 2)
					(if (& global207 $0002)
						(if global108
							(Print 262 0) ; "A wonderful-smelling gumbo bubbles on the woodstove while Celie stirs it."
						else
							(Print 262 1) ; "Celie has changed her hostile attitude. She actually appears very friendly and nice!"
						)
					else
						(Say 0 262 2) ; "Celie is the Colonel's cook. She is an overweight black lady who, on the surface, seems to be distant and unfriendly. However, you sense that she is probably a very nice person just "mindin' her own bizness." You have heard that Celie practices voodoo and you wonder about this."
					)
				)
				((Said 'talk>')
					(if (Said '/celie')
						(= global213 2)
						(if global108
							(switch local0
								(0
									(Say 1 262 3) ; "I don't know why, but I'm havin' a real bad feelin' in mah bones. I think there's a bad moon a'risin'."
								)
								(1
									(Say 1 262 4) ; "I think I'll jus' stay in mah cabin tonight. Mebbe I'll whip up a gris-gris to scare off the evil spirits."
								)
								(2
									(Say 1 262 5) ; "If'n I wuz you, Missy, I'd jus' go to mah room and stay there tonight!"
								)
								(3
									(Say 1 262 6) ; "Why don't you go on back to the big house, chile? There's some things I gotta 'ttend to."
								)
								(4
									(Say 1 262 7) ; "Are you a'hearin' me, Missy Laura? I said I think you oughtta go back to the big house and stay put. This ain't no night for you to be a'wanderin' 'round."
								)
								(else
									(Say 1 262 8) ; "Skedaddle, chile!"
								)
							)
							(++ local0)
						else
							(switch local0
								(0
									(Say 1 262 9) ; "I wanna thank you for bringin' back my healin' necklace. I've been feelin' kinda poorly lately."
								)
								(1
									(Say 1 262 10) ; "I knows you never been here befo', but...you like a good story? Let me tell you an ol' tale 'round these parts."
									(Say 1 262 11) ; "A looong time ago, right befo' the Civil War, this place wuz a bustlin' sugar cane plantation. But, durin' the war, this place wuz ruined and the owners killed."
									(Say 1 262 12) ; "They had a daughter, Sarah, who wuz away at school durin' all the trouble, and folks 'round here say that they hid the family jewels somewheres on this here prop'ty for her to someday find. She never did, though. Not long afterward, the poor girl died of a turrible fever."
									(Say 1 262 13) ; "They say Sarah haunts the ol' graveyard like she's still a'lookin' for the missin' treasure."
									(Say 1 262 14) ; "'Course, it's just a story. Folks 'round here like to believe it, but I ain't never seen nothin'... 'cept..."
									(Say 1 262 15) ; "Nah, it wuzn't anythin'."
								)
								(2
									(Say 1 262 16) ; "I'd be mighty careful walkin' 'round out here if I wuz you, Missy Laura."
								)
								(3
									(Say 1 262 17) ; "You seem a nice, quiet girl...not at all like Missy Lillian."
								)
								(4
									(Say 1 262 18) ; "I'm kinda confused why you came all the way out here for Missy Lillian's family gatherin'? S'far as I know, you just a stranger here."
								)
								(5
									(Say 1 262 19) ; "I have a bad feelin' tonight. You'd best watch out for yourse'f."
								)
								(6
									(Say 1 262 20) ; "It's been nice chattin', but I'm a'gettin' kinda tired. Why don't you go on back to the big house?"
								)
								(else
									(Print 262 21) ; "Celie would like to rest now. It would be best to leave her alone."
								)
							)
							(++ local0)
						)
					)
				)
				((Said 'listen/celie')
					(Print 262 22) ; "She's waiting for you to say something."
				)
			)
		)
	)
)

(instance cook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie
					setCycle: Walk
					illegalBits: 0
					setAvoider: (Avoid new:)
					setMotion: MoveTo 192 127 self
				)
			)
			(1
				(Celie
					view: 482
					loop: 4
					setAvoider: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(global373 hide:)
				(Celie loop: 5 cycleSpeed: 1 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(3
				(global373 show:)
				(Celie loop: 4 cel: 3 setCycle: Beg)
				(= state 0)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie
					setCycle: Walk
					illegalBits: 0
					setAvoider: (Avoid new:)
					setMotion: MoveTo 213 138 self
				)
			)
			(1
				(Celie view: 489 setAvoider: 0 cel: 0 setCycle: End self)
				(DisposeScript 985)
			)
			(2
				(= global213 2)
				(Say 1 262 23) ; "If'n you want, you can sit a spell and we'll visit."
				(Celie loop: 2)
				(CHead init:)
				(cls)
				(= seconds (Random 6 12))
			)
			(3
				(CHead setCycle: End)
				(= seconds (Random 6 12))
			)
			(4
				(CHead setCycle: Beg)
				(= state 2)
				(= seconds (Random 6 12))
			)
		)
	)
)

