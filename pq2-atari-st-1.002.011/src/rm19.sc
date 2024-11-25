;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm19 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm19 of Rm
	(properties
		picture 19
		style 0
	)

	(method (dispose)
		(stallScript dispose:)
		(floodScript dispose:)
		(marshallScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= global212 2)
		(= global211 1)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 256)
		(Load rsVIEW 80)
		(Load rsPIC 35)
		(gEgo
			posn: 269 140
			view: (if global204 7 else 1)
			setStep: 3 2
			init:
			illegalBits: $a000
			setMotion: MoveTo 0 140
		)
		(self setScript: rm19Script)
		(self setLocales: 153)
	)
)

(instance rm19Script of Script
	(properties)

	(method (doit)
		(if (> local12 0)
			(-- local12)
		)
		(cond
			((> (gEgo x:) 270)
				(gCurRoom newRoom: 16)
			)
			((<= (gEgo y:) 126)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(if (and local13 local15 (not (gEgo inRect: 174 115 225 138)))
			(= local15 0)
			(localproc_0 19 0) ; "You left the water running in the sink."
		)
		(if (and local13 (gEgo inRect: 174 115 225 138))
			(= local15 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SL enable:)
				(HandsOn)
				(User prevDir: 7)
				(if (and (== global100 13) (not local10) (not (IsFlag 150)))
					((= local0 (Act new:))
						view: 21
						posn:
							(if (IsFlag 151) 192 else 138)
							(if (IsFlag 151) 119 else 120)
						init:
						illegalBits: 0
						setCycle: Walk
						setScript: marshallScript
					)
				)
				((= local9 (Prop new:))
					view: 80
					loop: 3
					cel: 0
					cycleSpeed: 4
					setPri: 7
					ignoreActors:
					posn: 136 137
					init:
					stopUpd:
					setScript: floodScript
				)
				((= local2 (Prop new:))
					view: 80
					loop: 0
					cel: 0
					posn: 92 143
					cycleSpeed: 2
					setPri: 10
					init:
					stopUpd:
				)
				((= local3 (Prop new:))
					view: 80
					loop: 1
					cel: 0
					cycleSpeed: 2
					posn: 109 133
					setPri: 9
					init:
					stopUpd:
				)
				((= local4 (Prop new:))
					view: 80
					loop: 2
					cel: 0
					cycleSpeed: 2
					posn: 115 122
					setPri: 8
					init:
					stopUpd:
				)
				((View new:)
					view: 80
					loop: 5
					cel: 0
					posn: 210 114
					setPri: 7
					init:
					addToPic:
				)
				(if local10
					(switch local11
						(1
							(self changeState: 1)
						)
						(2
							(self changeState: 5)
						)
						(3
							(self changeState: 9)
						)
					)
				)
			)
			(1
				(HandsOff)
				(local2 startUpd: setCycle: End self)
				(= local11 1)
			)
			(2
				(gEgo ignoreActors: illegalBits: 0)
				(if local10
					(= local10 0)
					(= local11 0)
					(gEgo setMotion: MoveTo 110 143 self)
				else
					(gEgo setMotion: MoveTo 64 143 self)
				)
			)
			(3
				(gEgo ignoreActors: 0 illegalBits: $a000)
				(local2 ignoreActors: setCycle: Beg self)
			)
			(4
				(HandsOn)
				(local2 stopUpd:)
			)
			(5
				(HandsOff)
				(local3 startUpd: setCycle: End self)
				(= local11 2)
			)
			(6
				(gEgo ignoreActors: illegalBits: 0)
				(if local10
					(= local11 0)
					(= local10 0)
					(gEgo setMotion: MoveTo 125 131 self)
				else
					(gEgo setMotion: MoveTo 86 131 self)
				)
			)
			(7
				(gEgo ignoreActors: 0 illegalBits: $a000)
				(local3 ignoreActors: setCycle: Beg self)
			)
			(8
				(HandsOn)
				(local3 stopUpd:)
			)
			(9
				(local4 startUpd: setCycle: End self)
				(HandsOff)
				(= local11 3)
			)
			(10
				(gEgo ignoreActors: illegalBits: 0)
				(if local10
					(= local11 0)
					(= local10 0)
					(gEgo setMotion: MoveTo 135 120 self)
				else
					(gEgo setMotion: MoveTo 108 120 self)
				)
			)
			(11
				(gEgo ignoreActors: 0 illegalBits: $a000)
				(local4 ignoreActors: setCycle: Beg self)
			)
			(12
				(HandsOn)
				(local4 stopUpd:)
			)
			(13
				(switch local11
					(2
						(if (and (IsItemAt 31) (>= global100 6) (< global100 8)) ; jailer_s_revolver
							(localproc_0 19 1) ; "Whoosh-clink-ssss clink-sshh-glugg."
							(floodScript changeState: 1)
							(= global128 1)
						else
							(localproc_0 19 2) ; "Whooooooooosssssshhhhh...... gurgle, gurgle."
						)
					)
					(0
						(localproc_0 19 3) ; "Your arms aren't nearly long enough."
					)
					(else
						(localproc_0 19 2) ; "Whooooooooosssssshhhhh...... gurgle, gurgle."
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						local11
						(or
							(== (event message:) KEY_F6)
							(== (event message:) KEY_F8)
							(== (event message:) KEY_F10)
						)
					)
					(event claimed: 1)
					(Print 19 4) ; "You can't do that now."
				)
			)
			(evSAID
				(cond
					(
						(or
							(Said 'open[/booth,stall,door]')
							(and (not local11) (Said 'enter[/booth,stall]'))
							(and
								local11
								(or
									(Said 'exit[/booth,stall]')
									(Said 'get<out')
								)
							)
						)
						(cond
							((and (not local11) global204)
								(Print 19 5) ; "Put away your gun first."
							)
							((gEgo inRect: 117 116 140 126)
								(self changeState: 9)
							)
							((gEgo inRect: 104 126 130 136)
								(self changeState: 5)
							)
							((gEgo inRect: 86 136 118 149)
								(self changeState: 1)
							)
							((== local11 1)
								(= local10 1)
								(self changeState: 1)
							)
							((== local11 2)
								(= local10 1)
								(self changeState: 5)
							)
							((== local11 3)
								(= local10 1)
								(self changeState: 9)
							)
							(else
								(localproc_0 19 6) ; "You aren't close enough."
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/dirt')
								(localproc_0 19 7) ; "The ground is outside. In the new, modern Lytton Airport, they've put in floors."
							)
							((Said '/draw')
								(if local11
									(localproc_0 19 8) ; "If this was an "R" rated program like "Leisure Suit Larry", we might show it to you, but....!"
								else
									(localproc_0 19 9) ; "There are no bathroom drawings out here."
								)
							)
							((Said '/wall')
								(if local11
									(localproc_0 19 10) ; "The stall is furnished with a stool for your sitting pleasure and toilet paper for your comfort."
									(localproc_0 19 11) ; "There seems to be some graffiti scrawled on the wall of the stall... You can just barely read it."
								else
									(localproc_0 19 12) ; "On the walls, you see a paper towel dispenser, an electric hand dryer, a mirror, and a vent mounted above the stalls."
								)
							)
							((Said '/water')
								(if local11
									(localproc_0 19 13) ; "The toilet water is unappetizing."
								else
									(localproc_0 19 14) ; "Find some, first."
								)
							)
							((Said '/vent,fan')
								(localproc_0 19 15) ; "This vent is equipped with an electric fan, designed to remove offensive odors."
							)
							((Said '/drain')
								(if (== (floodScript state:) 2)
									(localproc_0 19 16) ; "It appears to be doing its job well."
								else
									(localproc_0 19 17) ; "You look in the drain and see nothing important."
								)
							)
							((Said '/man,gentleman,marshal')
								(if (gCast contains: local0)
									(localproc_0 19 18) ; "He appears to be a rather tall gentleman."
								else
									(localproc_0 19 19) ; "Huh?"
								)
							)
							((Said '<below/basin')
								(localproc_0 19 20) ; "There is a cabinet which hides the pipes."
							)
							((Said '/cabinet')
								(localproc_0 19 21) ; "It's mostly for decoration."
							)
							((Said '/outlet')
								(localproc_0 19 22) ; "They're hidden."
							)
							((Said '/door')
								(localproc_0 19 23) ; "The stall doors are uniformly uninteresting."
							)
							((Said '/basin')
								(if local11
									(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
								else
									(localproc_0 19 25) ; "It's handy for washing the hands. The soap dispensers are empty, however."
								)
							)
							((Said '/bracket<soap')
								(localproc_0 19 26) ; "Empty."
							)
							(
								(or
									(Said '/bracket,machine[<towel]')
									(Said '/bracket,machine<towel<newspaper')
								)
								(if local11
									(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
								else
									(localproc_0 19 27) ; "It's shiny, and it DOES have paper towels in it."
								)
							)
							((Said '/dryer')
								(if local11
									(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
								else
									(localproc_0 19 28) ; "It's shiny. You wonder who invented the concept."
								)
							)
							((or (Said '<up') (Said '/ceiling,light'))
								(localproc_0 19 29) ; "You look up and see the usual bathroom ceiling with flourescent lighting fixtures."
							)
							((or (Said '<down') (Said '/floor,tile'))
								(if local11
									(localproc_0 19 30) ; "You see a toilet mounted to the tile floor."
								else
									(localproc_0 19 31) ; "You see a clean tile floor with a water drain in the middle."
								)
							)
							((Said '/9mm')
								(if (gEgo has: 31) ; jailer_s_revolver
									(localproc_0 19 32) ; "It's a 4" Smith and Wesson .38 caliber K-38 revolver, Serial# 5557763."
								else
									(event claimed: 0)
								)
							)
							((Said '/mirror')
								(cond
									(local11
										(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
									)
									((< (gEgo y:) 135)
										(if (== (gEgo loop:) 0)
											(localproc_0 19 33) ; "Quit being so vain."
										else
											(localproc_0 19 34) ; "You'll have to turn around to see the mirror."
										)
									)
									(else
										(localproc_0 19 35) ; "You're not close enough."
									)
								)
							)
							((Said '/booth,stall')
								(if local11
									(localproc_0 19 10) ; "The stall is furnished with a stool for your sitting pleasure and toilet paper for your comfort."
									(localproc_0 19 11) ; "There seems to be some graffiti scrawled on the wall of the stall... You can just barely read it."
								else
									(localproc_0 19 36) ; "You can't see much from the outside. Better open one first."
								)
							)
							((Said '/crapper,crapper,tank')
								(if local11
									(gCurRoom setScript: stallScript)
								else
									(localproc_0 19 37) ; "The toilets are in the stalls, and you're not."
								)
							)
							((Said '[<at,around][/chamber,bathroom,bathroom]')
								(if local11
									(localproc_0 19 10) ; "The stall is furnished with a stool for your sitting pleasure and toilet paper for your comfort."
									(localproc_0 19 11) ; "There seems to be some graffiti scrawled on the wall of the stall... You can just barely read it."
									(gCurRoom setScript: stallScript)
								else
									(localproc_0 19 38) ; "You look around the public rest room but the only unusual thing you notice is that it's cleaner than most. Good old Lytton!"
								)
							)
						)
					)
					((Said 'open,unlock/cabinet')
						(localproc_0 19 39) ; "It's locked, you don't have the key, and you don't need anything out of the cabinet."
					)
					((Said 'smell/odor')
						(localproc_0 19 40) ; "There aren't any. The fan works."
					)
					(
						(or
							(Said 'move,remove,hoist,open/cover,lid,lid')
							(Said 'open/tank,crapper')
							(Said 'frisk/tank')
						)
						(if local11
							(= [local5 local11] 1)
							(gCurRoom setScript: stallScript)
						else
							(localproc_0 19 35) ; "You're not close enough."
						)
					)
					((Said 'taste,drink,drink[/water]')
						(localproc_0 19 41) ; "Lytton is a wonderful place, but its not known for its fabulous-tasting water."
					)
					((or (Said 'read/graffiti,wall') (Said 'look/graffiti'))
						(if local11
							(switch (Random 0 5)
								(0
									(localproc_0 19 42) ; "Here I sit all broken-hearted... Came to........(you can't make out the rest)."
								)
								(1
									(localproc_0 19 43) ; "Nostalgia just isn't what it used to be."
								)
								(2
									(localproc_0 19 44) ; "For a good time, call 683-4463....ask for Larry."
								)
								(3
									(localproc_0 19 45) ; "There's a fairly good anatomical drawing here, but it appears to be upside-down."
								)
								(4
									(localproc_0 19 46) ; "Where the hell is Coarsegold, CA???"
								)
								(5
									(localproc_0 19 47) ; "As I was walking down the stair I met a man who wasn't there. He wasn't there again today... I sure do wish he'd GO AWAY!"
								)
							)
						else
							(localproc_0 19 48) ; "What? Where?"
						)
					)
					((Said 'write')
						(localproc_0 19 49) ; "Defacing public property isn't part of your job description."
					)
					((or (Said 'shit') (Said 'get/shit'))
						(if local11
							(switch (Random 0 2)
								(0
									(localproc_0 19 50) ; "You hum a familiar tune..."Plop, plop, whiz, whiz....oh, what a relief it is.""
								)
								(1
									(localproc_0 19 51) ; "During this time of relief, you think to yourself... "Gee, wish I had something to read.""
								)
								(2
									(localproc_0 19 52) ; "As you occupy the stall you think, "It must have been the prunes.""
								)
							)
						else
							(localproc_0 19 53) ; "On the floor? Better go into a stall first."
						)
					)
					((or (Said 'leak') (Said 'get/leak'))
						(if local11
							(switch (Random 0 3)
								(0
									(localproc_0 19 54) ; "Whew!" you sigh, "I need to quit drinking so much coffee."
								)
								(1
									(localproc_0 19 55) ; "You take time out for a natural body function."
								)
								(2
									(localproc_0 19 56) ; "You rid yourself of enough coffee to float an aircraft carrier."
								)
								(3
									(localproc_0 19 57) ; "As you eliminate the day's coffee, you think..."I wonder where the "black" in my black coffee goes?""
								)
							)
						else
							(localproc_0 19 53) ; "On the floor? Better go into a stall first."
						)
					)
					((Said 'flush[/crapper]')
						(self changeState: 13)
					)
					((or (Said 'wipe/ass') (Said 'use/newspaper[<crapper]'))
						(if local11
							(localproc_0 19 58) ; "Of course!"
						else
							(localproc_0 19 59) ; "You should be in one of the stalls to do that."
						)
					)
					((Said 'sat')
						(if local11
							(localproc_0 19 60) ; "Now's no time to relax, Sonny."
						else
							(localproc_0 19 61) ; "There's no place to sit, unless you go into one of the toilet stalls."
						)
					)
					((Said 'frisk,check[<out]/stall,booth')
						(if local11
							(localproc_0 19 62) ; "You look all around the toilet and the stall, but you find nothing out of the ordinary."
						else
							(localproc_0 19 63) ; "Go ahead and enter one of the stalls."
						)
					)
					((Said 'frisk,check[<out]/crapper,tank')
						(if local11
							(gCurRoom setScript: stallScript)
						else
							(localproc_0 19 63) ; "Go ahead and enter one of the stalls."
						)
					)
					((Said 'frisk,check[<out]')
						(localproc_0 19 64) ; "You search high and low, but so far you've found nothing."
					)
					((Said 'talk/man,gentleman,marshal')
						(if (gCast contains: local0)
							(localproc_0 19 65) ; "He doesn't seem to hear you. He's humming under his breath..."Leeeavinn'...on a jet plane...""
						else
							(localproc_0 19 66) ; "Talking to yourself again?"
						)
					)
					((Said 'show/mugshot,shot,painting')
						(if (gCast contains: local0)
							(localproc_0 19 67) ; "Listen, I've got a flight to catch, so if you'll excuse me....."
						else
							(localproc_0 19 68) ; "There's nobody here."
						)
					)
					((Said 'get,use/towel,bracket')
						(if (gEgo inRect: 133 116 178 122)
							(localproc_0 19 69) ; "You grab a paper towel and use it."
						else
							(localproc_0 19 70) ; "The paper towel dispenser is over on the far wall."
						)
					)
					((Said 'press/button')
						(if (gEgo inRect: 155 116 182 122)
							(if (> local12 0)
								(localproc_0 19 71) ; "The dryer is already on."
							else
								(localproc_0 19 72) ; "You turn on the electric hand dryer."
								(= local12 80)
							)
						else
							(localproc_0 19 19) ; "Huh?"
						)
					)
					(
						(Said
							'use,go/crapper,bathroom,bathroom,(chamber<rest,bath)'
						)
						(if local11
							(switch (Random 0 3)
								(0
									(localproc_0 19 54) ; "Whew!" you sigh, "I need to quit drinking so much coffee."
								)
								(1
									(localproc_0 19 55) ; "You take time out for a natural body function."
								)
								(2
									(localproc_0 19 56) ; "You rid yourself of enough coffee to float an aircraft carrier."
								)
								(3
									(localproc_0 19 57) ; "As you eliminate the day's coffee, you think..."I wonder where the "black" in my black coffee goes?""
								)
							)
						else
							(localproc_0 19 73) ; "If you really have to go, use one of the stalls."
						)
					)
					((or (Said 'activate,start,use>') (Said 'turn<on>'))
						(cond
							((Said '/dryer')
								(if (gEgo inRect: 155 116 182 122)
									(if (> local12 0)
										(localproc_0 19 74) ; "It is already on."
									else
										(localproc_0 19 72) ; "You turn on the electric hand dryer."
										(= local12 80)
									)
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/basin,faucet,water')
								(if (gEgo inRect: 174 115 225 138)
									(if local13
										(localproc_0 19 74) ; "It is already on."
									else
										(localproc_0 19 75) ; "You turn on the sink water."
										(= local13 1)
									)
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/fan')
								(switch (Random 0 2)
									(0
										(localproc_0 19 3) ; "Your arms aren't nearly long enough."
									)
									(1
										(localproc_0 19 76) ; "It stays on all the time."
									)
									(2
										(localproc_0 19 74) ; "It is already on."
									)
								)
							)
						)
					)
					((or (Said 'deactivate,stop>') (Said 'turn,close<off>'))
						(cond
							((Said '/dryer')
								(if (gEgo inRect: 155 116 182 122)
									(if (> local12 0)
										(localproc_0 19 77) ; "It's on a timer and will shut off by itself."
										(= local12 80)
									else
										(localproc_0 19 78) ; "It is already off."
									)
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/faucet,basin,water')
								(if (gEgo inRect: 174 115 225 138)
									(if local13
										(localproc_0 19 79) ; "You turn the water off."
										(= local13 0)
									else
										(localproc_0 19 78) ; "It is already off."
									)
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/fan')
								(if (== (Random 0 2) 1)
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								else
									(localproc_0 19 76) ; "It stays on all the time."
								)
							)
						)
					)
					((Said 'dry>')
						(cond
							((Said '/9mm,revolver')
								(if (gEgo inRect: 133 116 178 122)
									(if (gEgo has: 31) ; jailer_s_revolver
										(cond
											((gEgo inRect: 155 116 182 122)
												(if (> local12 0)
													(if local17
														(localproc_0 19 80) ; "You've already dried the gun."
													else
														(SetScore 2 107)
														(= local17 1)
														(localproc_0 19 81) ; "You use the warm air from the electric hand dryer to dry off the gun."
													)
												else
													(localproc_0 19 82) ; "The hand dryer is not turned on."
												)
											)
											(local17
												(localproc_0 19 80) ; "You've already dried the gun."
											)
											(else
												(= local17 1)
												(localproc_0 19 83) ; "You rip off a paper towel, and wipe the gun dry."
												(localproc_0 19 84) ; "You also wipe off any possible fingerprints."
											)
										)
									else
										(localproc_0 19 85) ; "You don't have a gun that needs drying."
									)
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/hand')
								(cond
									((gEgo inRect: 133 116 178 122)
										(if (or (gEgo has: 31) local14) ; jailer_s_revolver
											(= local14 0)
											(if local12
												(localproc_0 19 86) ; "The warm air feels good on your hands."
											else
												(localproc_0 19 87) ; "In spite of your good upbringing, you wipe your hands on your pants. Shame on you."
											)
										else
											(localproc_0 19 88) ; "Your hands are already dry."
										)
									)
									((or (gEgo has: 31) local14) ; jailer_s_revolver
										(localproc_0 19 87) ; "In spite of your good upbringing, you wipe your hands on your pants. Shame on you."
									)
									(else
										(localproc_0 19 88) ; "Your hands are already dry."
									)
								)
							)
						)
					)
					((Said 'bath>')
						(cond
							((Said '/hand')
								(if (gEgo inRect: 174 115 225 138)
									(= local14 1)
									(localproc_0 19 89) ; "That's a GOOD boy! It's not worth any points, but at least you're clean."
								else
									(localproc_0 19 3) ; "Your arms aren't nearly long enough."
								)
							)
							((Said '/9mm,revolver')
								(localproc_0 19 90) ; "That is one STUPID idea!"
							)
						)
					)
				)
			)
		)
	)
)

(instance stallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom drawPic: 35)
				(gCast eachElementDo: #dispose)
				(if
					(and
						(IsItemAt 31) ; jailer_s_revolver
						(== local11 2)
						(>= global100 6)
						(< global100 8)
					)
					((= local1 (Act new:))
						view: 256
						setLoop: 2
						setCel: 0
						setPri: 6
						posn: 167 133
						init:
						illegalBits: 0
						ignoreActors:
						stopUpd:
					)
				)
				((= local19 (View new:))
					view: 256
					loop: 0
					cel: 0
					posn: 155 137
					setPri: 14
					init:
					stopUpd:
				)
				((= local18 (View new:))
					view: 256
					loop: 1
					cel: 0
					posn: 154 76
					setPri: 15
					init:
					stopUpd:
				)
				(if [local5 local11]
					(local18 posn: -100 0)
				)
				((= local9 (Prop new:))
					view: 256
					loop: 3
					cel: 0
					posn: 221 92
					setPri: 14
					init:
					ignoreActors:
					setScript: floodScript
				)
				(User canInput: 1)
			)
			(2
				(HandsOff)
				(local1 setMotion: MoveTo 167 60 self)
			)
			(3
				(SetScore 4)
				(local19 posn: 155 137)
				(gEgo get: 31) ; jailer_s_revolver
				(local1 dispose:)
				(local9 dispose:)
				(localproc_0 19 91 83) ; "The revolver is pretty wet, and so is your hand."
				(HandsOn)
				(self cue:)
			)
			(4
				(if (!= (gContinuousMusic state:) 3)
					(gContinuousMusic number: 29 loop: -1 play:)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) KEY_F6)
						(== (event message:) KEY_F8)
						(== (event message:) $3a00)
					)
					(proc0_10) ; "You can't do that now."
				)
			)
			(evSAID
				(cond
					(
						(or
							(Said 'move,remove,hoist,open/cover,lid,lid')
							(Said 'open[/tank,crapper]')
							(Said 'frisk/tank')
						)
						(if (== [local5 local11] 0)
							(local18 posn: -100 0)
							(= [local5 local11] 1)
						else
							(localproc_0 19 92) ; "The lid is already off."
						)
					)
					((Said 'replace,close,drop>')
						(cond
							((Said '/lid,cover,lid')
								(if (== [local5 local11] 1)
									(= [local5 local11] 0)
									(local18 posn: 154 75)
									(local19 posn: 155 137)
								else
									(localproc_0 19 93) ; "The lid is already on."
								)
							)
							((Said '/9mm')
								(localproc_0 19 94) ; "It's material evidence. You need to book it at the station, not put it back!"
							)
							((Said '/hand/water,tank')
								(localproc_0 19 95) ; "It's mighty icky in there."
							)
						)
					)
					((Said 'hoist,get,remove/9mm,revolver')
						(cond
							((gEgo has: 31) ; jailer_s_revolver
								(localproc_0 19 96) ; "You already have it."
							)
							(
								(and
									(== local11 2)
									(gCast contains: local1)
									(== [local5 local11] 1)
								)
								(if (== (local19 y:) 0)
									(localproc_0 19 97 25 3) ; "You roll up your sleeve, and carefully lift the revolver."
									(SetFlag 49)
									(= global128 0)
									(stallScript changeState: 2)
								else
									(localproc_0 19 98) ; "You don't see a gun."
								)
							)
							(else
								(localproc_0 19 99) ; "You don't see a weapon here."
							)
						)
					)
					(
						(or
							(Said 'exit[/booth,stall,crapper]')
							(Said 'get<out')
							(Said 'open/door')
						)
						(gCurRoom drawPic: (gCurRoom picture:))
						(gCast eachElementDo: #dispose)
						(gEgo init: loop: 0)
						(= local10 1)
						(HandsOn)
						(gCurRoom setScript: rm19Script)
						(cond
							((== local11 1)
								(= local10 1)
								(rm19Script changeState: 1)
							)
							((== local11 2)
								(= local10 1)
								(rm19Script changeState: 5)
							)
							((== local11 3)
								(= local10 1)
								(rm19Script changeState: 9)
							)
						)
					)
					((or (Said 'flush[/crapper]') (Said 'use,press/handle'))
						(rm19Script changeState: 13)
					)
					((or (Said 'use/newspaper[<crapper]') (Said 'wipe/ass'))
						(localproc_0 19 58) ; "Of course!"
					)
					((or (Said 'read/graffiti,wall') (Said 'look/graffiti'))
						(switch (Random 0 5)
							(0
								(localproc_0 19 42) ; "Here I sit all broken-hearted... Came to........(you can't make out the rest)."
							)
							(1
								(localproc_0 19 43) ; "Nostalgia just isn't what it used to be."
							)
							(2
								(localproc_0 19 44) ; "For a good time, call 683-4463....ask for Larry."
							)
							(3
								(localproc_0 19 45) ; "There's a fairly good anatomical drawing here, but it appears to be upside-down."
							)
							(4
								(localproc_0 19 46) ; "Where the hell is Coarsegold, CA???"
							)
							(5
								(localproc_0 19 47) ; "As I was walking down the stair I met a man who wasn't there. He wasn't there again today... I sure do wish he'd GO AWAY!"
							)
						)
					)
					((Said 'write')
						(localproc_0 19 49) ; "Defacing public property isn't part of your job description."
					)
					((or (Said 'shit') (Said 'get/shit'))
						(switch (Random 0 2)
							(0
								(localproc_0 19 50) ; "You hum a familiar tune..."Plop, plop, whiz, whiz....oh, what a relief it is.""
							)
							(1
								(localproc_0 19 51) ; "During this time of relief, you think to yourself... "Gee, wish I had something to read.""
							)
							(2
								(localproc_0 19 52) ; "As you occupy the stall you think, "It must have been the prunes.""
							)
						)
					)
					((or (Said 'leak') (Said 'get/leak') (Said 'use/crapper'))
						(switch (Random 0 3)
							(0
								(localproc_0 19 54) ; "Whew!" you sigh, "I need to quit drinking so much coffee."
							)
							(1
								(localproc_0 19 55) ; "You take time out for a natural body function."
							)
							(2
								(localproc_0 19 56) ; "You rid yourself of enough coffee to float an aircraft carrier."
							)
							(3
								(localproc_0 19 57) ; "As you eliminate the day's coffee, you think..."I wonder where the "black" in my black coffee goes?""
							)
						)
					)
					((Said 'taste,drink,drink[/water]')
						(localproc_0 19 100) ; "You've GOT to be kidding!"
					)
					((Said 'sat')
						(localproc_0 19 60) ; "Now's no time to relax, Sonny."
					)
					((Said 'frisk/crapper,stall,booth')
						(localproc_0 19 62) ; "You look all around the toilet and the stall, but you find nothing out of the ordinary."
					)
					((Said 'look>')
						(cond
							(
								(or
									(Said '[<in,in]/crapper,tank,water')
									(Said '<in,in[/crapper,tank,water]')
								)
								(if [local5 local11]
									(local19 posn: -100 0)
									(if
										(and
											(not (gEgo has: 31)) ; jailer_s_revolver
											(gCast contains: local1)
											(== local11 2)
										)
										(localproc_0 19 101 83) ; "You see what looks like a police revolver hidden in the bottom of the toilet tank."
									else
										(localproc_0 19 102 83) ; "Full of water."
									)
								else
									(localproc_0 19 103) ; "Remove the lid first."
								)
								(if
									(and
										global128
										(== local11 2)
										(not (gCast contains: local1))
									)
									(localproc_0 19 104) ; "The toilet is overflowing. It's not a pretty sight!"
								)
							)
							((Said '/handle')
								(localproc_0 19 105) ; "It's used to flush the toilet."
							)
							((Said '[<at,down][/floor,tile]')
								(localproc_0 19 30) ; "You see a toilet mounted to the tile floor."
							)
							((Said '/9mm')
								(cond
									((gEgo has: 31) ; jailer_s_revolver
										(localproc_0 19 106) ; "It's a 4" Smith and Wesson .38 caliber K-38, Serial# 5557763"
									)
									(
										(and
											(== (local19 y:) 0)
											(gCast contains: 31)
										)
										(localproc_0 19 101) ; "You see what looks like a police revolver hidden in the bottom of the toilet tank."
									)
									(else
										(localproc_0 19 107) ; "You can't see it."
									)
								)
							)
							((Said '/basin')
								(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
							)
							((Said '/mirror')
								(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
							)
							((Said '[<at,around][/booth,stall,wall]')
								(localproc_0 19 10) ; "The stall is furnished with a stool for your sitting pleasure and toilet paper for your comfort."
								(localproc_0 19 11) ; "There seems to be some graffiti scrawled on the wall of the stall... You can just barely read it."
							)
							(
								(or
									(Said '/bracket,machine[<towel]')
									(Said '/bracket,machine<towel<newspaper')
								)
								(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
							)
							((Said '/dryer')
								(localproc_0 19 24) ; "You'll have to leave the stall to get a good look at it."
							)
							((Said '/newspaper[<crapper]')
								(localproc_0 19 108) ; "Just your ordinary, white, thin, scratchy toilet paper."
							)
						)
					)
				)
			)
		)
	)
)

(instance floodScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global128
					(self changeState: 2)
				)
			)
			(1
				(local9 setCycle: End self)
			)
			(2
				(local9 loop: 4 setCycle: Fwd)
			)
		)
	)
)

(instance marshallScript of Script
	(properties)

	(method (init)
		(super init:)
		(= global212 3)
	)

	(method (doit)
		(if (and (<= (local0 distanceTo: gEgo) 10) (not local16))
			(= local16 1)
			(localproc_0 19 109) ; "Excuse me, please. You're in my way."
			(gEgo setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:))
		)
		(if (and (> (local0 distanceTo: gEgo) 10) local16)
			(= local16 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 151)
				(local0 startUpd: setMotion: MoveTo 192 119 self)
			)
			(1
				(= cycles 60)
			)
			(2
				(local0 setLoop: 2 setMotion: MoveTo 200 139 self)
			)
			(3
				(local0 setLoop: 0 setMotion: MoveTo 286 140 self)
			)
			(4
				(SetFlag 150)
				(local0 dispose:)
			)
		)
	)
)

