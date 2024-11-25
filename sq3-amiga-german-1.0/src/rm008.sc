;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Feature)
(use Rev)
(use Timer)
(use Avoid)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm008 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm008 of Rm
	(properties
		picture 8
		style 0
		horizon 1
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(= gUseSortedFeatures 1)
		(= global35 120)
		(if (!= gPrevRoomNum 11)
			(self
				setLocales: 700
				setFeatures: thePod theMallard
				setScript: rmScript
			)
		)
		(Load rsSCRIPT 991)
		(= local7 991)
		(Load rsVIEW 16)
		(Load rsVIEW 6)
		(Load rsVIEW 19)
		(Load rsVIEW 21)
		(Load rsVIEW 29)
		(Load rsVIEW 257)
		(Load rsVIEW 750)
		(Load rsVIEW 193)
		(Load rsSOUND 11)
		(Load rsSOUND 56)
		(if (and (!= global135 4) (== global149 gCurRoomNum))
			(Load rsVIEW 36)
			(motivator init:)
		)
		(cond
			((== gPrevRoomNum 14)
				(= local1 1)
				((gInventory at: 2) moveTo: 8) ; Ladder
				(gLongSong number: 11 loop: -1 priority: 127 playBed:)
			)
			((== gPrevRoomNum 11)
				(Load rsVIEW 258)
				(Load rsSOUND 76)
				(= local4 (if global147 215 else 51))
				(= local5 (if global147 67 else 139))
			)
			(else
				(gEgo
					view: 19
					setLoop: 0
					illegalBits: 0
					ignoreHorizon: 1
					posn: 251 14
					setStep: 1 1
					setPri: -1
					init:
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Rev
					setMotion: MoveTo 251 47 rmScript
					setScript: rmScript
				)
			)
		)
		(if (IsItemAt 2) ; Ladder
			(ladder init: stopUpd:)
		)
		(hatch init:)
		(super init:)
		(if (== gPrevRoomNum 11)
			(self setScript: grabScript)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event param2 &tmp [temp0 50])
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '/scrap,iro,junk,debris,junk,debris')
						(Print 8 0) ; "All of the metal has very jagged edges but is, otherwise, fairly ordinary."
					)
					((Said '/handle[<craft,aluminum,door]')
						(if local0
							(Print 8 1) ; "It looks like your basic hatch handle."
						else
							(Print 8 2) ; "You can't do that from down here."
						)
					)
					((Said '/leech,(craft<little)')
						(switch (= param2 (Random 1 2))
							(1
								(Print 8 3) ; "It's a cute little thing. You've never seen anything like it in these parts, but then where are these parts? Some writing on its exterior reads `For a good time, don't call HAL!'"
							)
							(2
								(Print 8 4) ; "It's a cute little thing. You've never seen anything like it in these parts, but then where are these parts? Some writing on its exterior reads `Bowman was here.'"
							)
						)
					)
					((Said '/aluminum,craft[<big]')
						(PrintSplit 8 5) ; "It's a sleek-looking number if you can disregard the junk it's rooted in. It must be a recent addition to the collection as everything seems to be intact. Etched on each side is the name `ALUMINUM MALLARD'. On top is a small hatch."
					)
					((Said '/nozzle')
						(Print 8 6) ; "None are visible."
					)
					((Said '/engine')
						(Print 8 7) ; "You can't see them as they are buried in junk."
					)
					((Said '/neck,android,head')
						(Print 8 8) ; "You notice only the segmented spine-like neck of a former galactic menace."
					)
					(
						(and
							(not local0)
							(Said
								'[<in,through,in,in]/cavity[<leech,little,cavity,aperture]'
							)
						)
						(if (gEgo inRect: 2 64 91 109)
							(Print 8 9) ; "The hole in the pod is so small that you are unable to discern any interior features."
						else
							(Print 8 10) ; "You are at an unsuitable location for sucessfully viewing that."
						)
					)
					(
						(or
							(Said '<in,in,in/leech,craft')
							(Said '[<at,in,through,in]/pane,port,(cavity<port)')
							(Said '/cabin,chair[<pilot]')
						)
						(cond
							((gEgo inRect: 44 105 87 116)
								(Print 8 11) ; "The blackness of the pod's interior is broken only by a small quantity of light pouring through a tiny meteoroid hole."
							)
							((gEgo inRect: 59 117 170 162)
								(Print 8 12) ; "You can make out a pilot's seat and a console. The aft end is dark."
							)
							(else
								(NotClose) ; "It's not quite within reach."
							)
						)
					)
					((Said '/console[<craft]')
						(if (gEgo inRect: 59 117 170 162)
							(Print 8 13) ; "The angle makes it impossible to see any detail."
						else
							(Print 8 14) ; "You can't see anything like that from here."
						)
					)
					((Said '[<in,in,in]/motivator,cavity,compartment')
						(if (and local0 (gEgo inRect: 193 75 260 89))
							(if (== global135 4)
								(Print 8 15) ; "You peer into the compartment and see the ship's motivator unit resting snugly in its perch."
							else
								(Print 8 16) ; "You peer into the cavity in the top of the ship. The only noteworthy item is a modular plug in the bottom of the opening."
							)
						else
							(Print 8 17) ; "You can't see it from here."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,eightprong]')
							(Said '/eightprong[<8]')
						)
						(if local0
							(if (== global149 4)
								(Print 8 18) ; "You can't. It's covered by the warp motivator."
							else
								(Print 8 19) ; "It's the modular eight pin variety."
							)
						else
							(Print 8 20) ; "You can't see it from down here."
						)
					)
					((Said '/leggo,domino,artifact')
						(Print 8 21) ; "They look like remnants of an orbital space station, or perhaps some type of toys for an over-sized child."
					)
					((Said '/ladder')
						(if (IsItemAt 2) ; Ladder
							(Print 8 22) ; "It's a low-tech ascent/descent module."
						else
							(event claimed: 0)
						)
					)
					((Said '/door')
						(if local0
							(Print 8 23) ; "It looks like the small round passage that it is."
						else
							(Print 8 24) ; "You can't see it from down here."
						)
					)
					((Said '/step,stair')
						(Print 8 25) ; "There are none of those here."
					)
					((Said '/tube,hose,conduit')
						(Print 8 26) ; "There is nothing interesting about them."
					)
					((Said '[<around,at,in][/area]')
						(Print 8 27) ; "You find yourself at the bottom of another trash pit. An interesting array of alien artifacts is strewn from one end to the other. A large ship is in the middle and a small one is off to one side."
					)
				)
			)
			((Said '(play[<with]),use[/leggo,domino,artifact]')
				(Print 8 28) ; "Get serious. We've got a game to play."
			)
			(
				(Said
					'hoist,hoist,move,freeze,manipulate,press,pull/craft,leech,aluminum[<escape,escape,big,little]'
				)
				(Print 8 29) ; "Despite technological advances in strong, lightweight ship materials, you can't possibly budge it."
			)
			((Said 'get,get>')
				(cond
					((Said '/plug[<modular]')
						(if local0
							(Print 8 30) ; "You can't. It's part of the ship."
						else
							(event claimed: 0)
						)
					)
					((Said '/leggo,domino,artifact')
						(Print 8 31) ; "Forget it. They're buried too deeply. Besides, you're too old to be playing with toys - at least you should be!"
					)
					((Said '/ladder')
						(if (IsItemAt 2) ; Ladder
							(cond
								(
									(and
										global194
										(gEgo inRect: 220 115 274 140)
									)
									(gEgo get: 2) ; Ladder
									(ladder dispose:)
									(gGame changeScore: -5)
									(Print 8 32) ; "You grab the ladder and jam it in your pocket."
									(Print 8 33) ; "Ouch! (again)"
									(= global194 0)
								)
								((gEgo inRect: 215 114 226 121)
									(gEgo get: 2) ; Ladder
									(ladder dispose:)
									(gGame changeScore: -5)
									(Print 8 34) ; "You grab the ladder and jam it in your pocket."
									(Print 8 33) ; "Ouch! (again)"
								)
								(local0
									(Print 8 35) ; "You don't need it up here."
								)
								(else
									(NotClose) ; "It's not quite within reach."
								)
							)
						else
							(Print 8 36) ; "That's not here to be gotten."
						)
					)
				)
			)
			((Said 'enter/!*')
				(Print 8 37) ; "Be more specific."
			)
			((Said 'yell/hal')
				(Print 8 38) ; "I told you not to do that."
			)
			(
				(and
					(gEgo inRect: 193 75 260 89)
					(Said 'enter/cavity,compartment')
				)
				(Print 8 39) ; "It's too small for you."
			)
			(
				(Said
					'use,erect,erect,drop,stand,stand,place,place[<up,on]/ladder/leech,(craft<little)'
				)
				(Print 8 40) ; "That won't help."
			)
			(
				(or
					(Said 'open,enter/door[<craft,aluminum]')
					(Said 'turn/handle[<craft,aluminum,door]')
					(Said 'get,get<in[/craft,aluminum]')
					(Said 'board,board,enter,(get,get<in)/craft,aluminum')
					(Said 'climb<in,through/door')
				)
				(if local0
					(if (gEgo inRect: 165 77 208 96)
						(hatchScript changeState: 1)
					else
						(NotClose) ; "It's not quite within reach."
					)
				else
					(Print 8 41) ; "You can't do that from down here."
				)
			)
			(
				(or
					(Said
						'open,enter,(get,get<in,in)/door<leech,(craft<little)'
					)
					(Said 'climb/leech,(craft<little,escape,escape)')
				)
				(Print 8 42) ; "That can't be done."
			)
			((Said 'wire,cable,generator')
				(Print 8 43) ; "Nothing is done with that here."
			)
			(
				(or
					(Said 'plug,affix/motivator,machine,artifact')
					(Said 'use/plug')
				)
				(Print 8 44) ; "That isn't necessary."
			)
			((Said 'close/door')
				(Print 8 45) ; "Check again."
			)
			(
				(Said
					'use,erect,erect,drop,stand,stand,place,place[<up,on,down]/ladder[/craft]'
				)
				(if (gEgo has: 2) ; Ladder
					(cond
						((gEgo inRect: 175 105 270 168)
							(gEgo setScript: ladderScript)
						)
						((gEgo inRect: 2 64 91 109)
							(Print 8 46) ; "You're wasting your time messing with this relic."
						)
						(else
							(Print 8 47) ; "It won't work here."
						)
					)
				else
					(Print 8 48) ; "You don't have that."
				)
			)
			(
				(Said
					'use,get,get,climb/junk,debris,scrap,iro,artifact,domino,pole,relic'
				)
				(if (gEgo inRect: 17 122 61 155)
					(gEgo setScript: bleedScript)
				else
					(Print 8 49) ; "That would be fruitless. Don't bother."
				)
			)
			((Said 'climb,crawl[<through,in,in]/pane,port,(cavity<port)')
				(Print 8 50) ; "You can't. It's closed permanently."
			)
			(
				(or
					(Said
						'enter,(climb<in,through,in,in)/cavity[<leech,little]'
					)
					(Said
						'reach,hand,appendage<in,in,in/cavity,leech,craft[<little]'
					)
					(Said
						'reach,hand,appendage<in,in,in/hand,appendage/cavity,leech,craft[<little]'
					)
				)
				(if (gEgo inRect: 2 64 91 109)
					(Print 8 51) ; "I don't think there is much of you that could fit into the seriously snug aperture."
				else
					(NotClose) ; "It's not quite within reach."
				)
			)
			((Said 'descend,climb[<down,up]/ladder')
				(cond
					((IsItemAt 2) ; Ladder
						(cond
							(
								(and
									(== (ladder cel:) 1)
									(or
										(gEgo inRect: 215 114 226 121)
										(gEgo inRect: 193 73 222 102)
									)
								)
								(gEgo setScript: climbLadderScript)
							)
							((== (ladder cel:) 2)
								(Print 8 52) ; "Not with it down there."
							)
							(else
								(Print 8 53) ; "There is no ladder close enough to climb."
							)
						)
					)
					((gEgo has: 2) ; Ladder
						(Print 8 54) ; "There doesn't seem to be a ladder ready for scaling."
					)
					(else
						(Print 8 55) ; "That would be great. If only someone had been smart enough to bring a ladder."
					)
				)
			)
			((Said 'climb[<!*][/!*]')
				(cond
					((gEgo inRect: 241 48 261 55)
						(rmScript changeState: 2)
					)
					(
						(or
							(gEgo inRect: 193 73 222 102)
							(gEgo inRect: 215 114 226 121)
						)
						(if (IsItemAt 2) ; Ladder
							(cond
								((== (ladder cel:) 1)
									(gEgo setScript: climbLadderScript)
								)
								((== (ladder cel:) 2)
									(Print 8 52) ; "Not with it down there."
								)
								(else
									(Print 8 53) ; "There is no ladder close enough to climb."
								)
							)
						else
							(Print 8 56) ; "There is no good way to scale the slick ship."
						)
					)
					(else
						(Print 8 57) ; "You're not in a good location for climbing that."
					)
				)
			)
			((Said 'climb[<in]/leech')
				(Print 8 58) ; "That's not possible."
			)
			(
				(or
					(Said 'climb[<down,off]/ladder,craft,aluminum,aluminum')
					(Said 'climb<down,off')
					(Said 'descend/ladder,craft,aluminum,aluminum')
				)
				(if (gEgo inRect: 193 73 222 102)
					(if (IsItemAt 2) ; Ladder
						(cond
							((== (ladder cel:) 1)
								(gEgo setScript: climbLadderScript)
							)
							((== (ladder cel:) 2)
								(Print 8 52) ; "Not with it down there."
							)
							(else
								(Print 8 53) ; "There is no ladder close enough to climb."
							)
						)
					else
						(Print 8 56) ; "There is no good way to scale the slick ship."
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'climb,(climb<up)[/!*]')
				(cond
					((gEgo inRect: 241 48 261 55)
						(rmScript changeState: 2)
					)
					((gEgo inRect: 215 114 226 121)
						(if (IsItemAt 2) ; Ladder
							(cond
								((== (ladder cel:) 1)
									(gEgo setScript: climbLadderScript)
								)
								((== (ladder cel:) 2)
									(Print 8 52) ; "Not with it down there."
								)
								(else
									(Print 8 53) ; "There is no ladder close enough to climb."
								)
							)
						else
							(Print 8 56) ; "There is no good way to scale the slick ship."
						)
					)
					(else
						(Print 8 57) ; "You're not in a good location for climbing that."
					)
				)
			)
			((Said 'descend,(climb<down)[/!*]')
				(if (gEgo inRect: 193 73 222 102)
					(if (IsItemAt 2) ; Ladder
						(cond
							((== (ladder cel:) 1)
								(gEgo setScript: climbLadderScript)
							)
							((== (ladder cel:) 2)
								(Print 8 52) ; "Not with it down there."
							)
							(else
								(Print 8 53) ; "There is no ladder close enough to climb."
							)
						)
					else
						(Print 8 56) ; "There is no good way to scale the slick ship."
					)
				else
					(Print 8 57) ; "You're not in a good location for climbing that."
				)
			)
		)
		(if (Said 'climb,climb/neck,head,android,nerve,cable')
			(if (gEgo inRect: 241 48 261 55)
				(rmScript changeState: 2)
			else
				(NotClose) ; "It's not quite within reach."
			)
		)
		(if
			(or
				(Said 'climb[<up,on,to]/neck,head,android,nerve,cable')
				(Said 'climb<up,on')
				(Said 'climb/neck,head,android,nerve,cable')
			)
			(if (gEgo inRect: 241 48 261 55)
				(rmScript changeState: 2)
			else
				(event claimed: 0)
			)
		)
		(if
			(or
				(Said 'climb[<up,on]/ladder,craft,aluminum,aluminum')
				(Said 'climb<up,on')
				(Said 'climb/ladder,craft,aluminum,aluminum')
			)
			(if (gEgo inRect: 215 114 226 121)
				(if (IsItemAt 2) ; Ladder
					(cond
						((== (ladder cel:) 1)
							(gEgo setScript: climbLadderScript)
						)
						((== (ladder cel:) 2)
							(Print 8 52) ; "Not with it down there."
						)
						(else
							(Print 8 53) ; "There is no ladder close enough to climb."
						)
					)
				else
					(Print 8 59) ; "The ship is too slick. You seem to remember an ectomorphic programmer friend telling you about ships with non-stick coatings for greater debris collision tolerance."
				)
			else
				(Print 8 57) ; "You're not in a good location for climbing that."
			)
		)
		(if (Said 'break/pane,glass')
			(Print 8 60) ; "You can't do that, nor would it be helpful."
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

(instance rmScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(1
				(HandsOn)
				(= global100 0)
				(gEgo
					view: 0
					setCycle: Walk
					setLoop: -1
					loop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 3 2
				)
				(if (!= local1 1)
					(gEgo posn: 250 54 setPri: -1 illegalBits: $c000)
				else
					(= local0 1)
					(gEgo posn: 207 86 illegalBits: 0)
					(= local1 0)
				)
			)
			(2
				(HandsOff)
				(= global100 1)
				(gEgo
					view: 19
					setLoop: 0
					setStep: 1 1
					illegalBits: 0
					posn: 251 47
					setMotion: MoveTo 251 13 self
					setCycle: Fwd
					moveSpeed: 1
					cycleSpeed: 1
				)
			)
			(3
				(gCurRoom newRoom: 7)
			)
			(4
				(gEgo
					setMotion: 0
					view: 257
					setLoop: (gEgo loop:)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(gEgo
					setStep: -1 10
					setCycle: 0
					ignoreActors:
					illegalBits: 0
				)
				(if (== local2 1)
					(gEgo setPri: 4)
					(if (< (gEgo x:) 175)
						(gEgo setMotion: JumpTo (gEgo x:) 134 self)
					else
						(gEgo setMotion: JumpTo (gEgo x:) 110 self)
					)
				)
				(if (== local2 3)
					(gEgo
						setStep: 10
						setMotion: MoveTo (- (gEgo x:) 32) 138 self
					)
				)
				(if (== local2 2)
					(gEgo
						setStep: -1 15
						setMotion:
							JumpTo
							(+ (gEgo x:) 10)
							(+ (gEgo y:) 30)
							self
					)
				)
			)
			(6
				(cond
					((== local2 3)
						(gEgo view: 750 setLoop: 1 setCel: 2)
						(Timer setReal: self 3)
						(self state: (+ state 1))
						(thump playBed:)
					)
					((== local2 2)
						(gEgo view: 16 loop: 0 cel: 0 stopUpd:)
						(Timer setCycle: self 2)
					)
					(else
						(gEgo hide:)
						(Timer set: self 2)
					)
				)
			)
			(7
				(Print 8 61) ; "We warned you to be careful. Did you listen? Nooooo! Good luck next time."
				(EgoDead 901 0 15 1)
				(HandsOn)
			)
			(8
				(gEgo
					view: 0
					setStep: 3 2
					setLoop: -1
					setPri: -1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 0
					illegalBits: $c000
				)
				(= global100 0)
				(if (not global194)
					(ladder setPri: 8 forceUpd:)
				)
				(= local2 0)
				(= local0 0)
				(RedrawCast)
				(Print 8 62) ; "You got lucky this time."
				(HandsOn)
			)
		)
	)

	(method (doit)
		(if (and (not gHandsOff) (not global100) (== local0 1))
			(if
				(or
					(== (gEgo onControl: 0) 8193)
					(== (gEgo onControl: 0) -24576)
					(== (gEgo onControl: 0) -24575)
					(== (gEgo onControl: 0) 24577)
				)
				(= local2 1)
			)
			(if
				(or
					(== (gEgo onControl: 0) 4097)
					(== (gEgo onControl: 0) 20481)
					(== (gEgo onControl: 0) -12287)
				)
				(if (< (gEgo x:) 175)
					(= local2 3)
				else
					(= local2 2)
				)
			)
			(if (> local2 0)
				(= local0 0)
				(HandsOff)
				(self changeState: 4)
				(= global100 1)
				(= local3 (gEgo loop:))
			)
		)
		(super doit:)
	)
)

(instance bleedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 193
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(= local6 (Print 8 63 #dispose)) ; "YEOW!"
			)
			(1
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
				(cls)
			)
			(2
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(3
				(gEgo cycleSpeed: 6)
				(= seconds 4)
			)
			(4
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(5
				(gEgo cel: 0 setCycle: 0)
				(RedrawCast)
				(Print 8 64 #at -1 20 #width 280) ; "It's obvious that the metal was sharper than you. The resulting laceration turns you into a living fountain - at least for a few moments. Unfortunately for you, this show was your finale. Good luck in the afterlife."
				(EgoDead 901 0 6 8)
			)
		)
	)
)

(instance hatchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local1 1)
					(self changeState: 2)
				else
					(hatch stopUpd:)
				)
			)
			(1
				(gEgo setMotion: 0 posn: 205 86)
				(HandsOff)
				(Print 8 65) ; "You move into position and, grabbing the dull finish of the hatch's handle, commence to open and enter the ship."
				(= cycles 2)
			)
			(2
				(hatch startUpd: setCycle: End self)
			)
			(3
				(if (== local1 1)
					(self state: (+ state 1))
				)
				(= seconds 2)
			)
			(4
				(gEgo
					view: 21
					posn: 202 87
					setLoop: 1
					cel: 0
					setMotion: 0
					setCycle: End self
					cycleSpeed: 1
				)
				(self state: (+ state 1))
			)
			(5
				(gEgo
					view: 21
					posn: 202 87
					setLoop: 1
					cel: 7
					init:
					setPri: 9
					setMotion: 0
					setCycle: Beg self
					cycleSpeed: 1
				)
			)
			(6
				(if (not local1)
					(gLongSong fade:)
					(if (not global231)
						(= global231 1)
						(gGame changeScore: 10)
					)
					(gCurRoom newRoom: 14)
				else
					(= cycles 5)
				)
			)
			(7
				(hatch setCycle: Beg self)
				(rmScript changeState: 1)
			)
			(8
				(hatch stopUpd:)
			)
		)
	)
)

(instance ladderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom setScript: rmScript)
				(gEgo setAvoider: Avoid setMotion: MoveTo 220 120 self)
			)
			(1
				(PutItem 2 gCurRoomNum) ; Ladder
				(gGame changeScore: 5)
				(gEgo setAvoider: 0 loop: 1)
				(ladder init: ignoreActors: 1 stopUpd:)
				(DisposeScript 985)
				(HandsOn)
			)
		)
	)
)

(instance climbLadderScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= global100 1)
				(HandsOff)
				(gEgo
					view: 19
					setLoop: 0
					illegalBits: 0
					ignoreActors: 1
					x: 220
					y: (if local0 103 else 119)
					setPri: 9
				)
				(if (not local0)
					(gEgo setMotion: MoveTo 220 103 self)
				else
					(ladder setPri: 8 forceUpd:)
					(gEgo setMotion: MoveTo 220 119 self setCycle: Rev)
				)
			)
			(1
				(HandsOn)
				(= global100 0)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					ignoreActors: 0
				)
				(if (not local0)
					(= local0 1)
					(ladder setPri: 10 forceUpd:)
					(gEgo setPri: 9 illegalBits: 0 posn: 216 89)
					(RedrawCast)
					(gCurRoom setScript: rmScript)
					(Print 8 66) ; "You notice it to be slick up here. Be careful."
				else
					(gEgo setPri: -1 illegalBits: $c000 posn: 220 120)
					(= local2 0)
					(= local0 0)
				)
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(claw init: setMotion: MoveTo local4 local5 self)
			)
			(1
				(= cycles 15)
			)
			(2
				(cond
					((== global135 3)
						(if (== global147 1)
							(gLongSong number: 76 loop: 1 play:)
							(gGame changeScore: 15)
							(RedrawCast)
							(Print 8 67) ; "Sensing an adequate surface, the claw releases its cargo and begins the ascent to the grabber unit. The object thuds into place within the cavity of the ship."
							(= global135 4)
							(= global149 global147)
						else
							(gLongSong number: 76 loop: 1 play:)
							(gGame changeScore: -15)
							(RedrawCast)
							(Print 8 68) ; "Sensing the floor, the claw releases its cargo and begins the ascent to the grabber unit."
							(motivator init:)
							(= global149 gCurRoomNum)
							(= global135 global147)
						)
						(= global148 4)
					)
					(
						(and
							(== global135 global147)
							(or (== global149 gCurRoomNum) (== global135 4))
						)
						(claw setLoop: 2)
						(if (!= global147 1)
							(motivator hide:)
						)
						(= global149 0)
						(= global135 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(RedrawCast)
						(Print 8 69) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 8 70) ; "Finding nothing here, the claw begins to ascend to the grabber unit."
						(= global148 4)
					)
				)
				(= cycles 2)
			)
			(3
				(claw
					setLoop: (if (== global135 3) 2 else 0)
					setMotion: MoveTo local4 -19 self
				)
			)
			(4
				(gCurRoom newRoom: 11)
			)
		)
	)
)

(instance ladder of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 29
			loop: 0
			cel: (if global194 2 else 1)
			ignoreActors: 1
			posn: (if global194 242 else 219) (if global194 131 else 114)
			setPri:
				(cond
					(global194 4)
					(local0 10)
					(else 8)
				)
		)
	)
)

(instance hatch of Prop
	(properties
		view 21
	)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setPri: 8
			posn: 188 89
			setScript: hatchScript
			cycleSpeed: 1
		)
	)
)

(instance claw of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 258
			setLoop: (if (== global135 3) 2 else 0)
			setPri: 15
			setStep: 1 2
			illegalBits: 0
			ignoreHorizon: 1
			ignoreActors: 1
			posn: local4 -19
			setCycle: Fwd
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
			posn: 66 155
			setStep: 1 3
			setPri: 11
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
							(Print 8 71) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(Print 8 72) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					((Said '/plug[<modular,8,eightprong]')
						(Print 8 73) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					((Said '[<down,below,at][/dirt,deck]')
						(Print 8 74) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal plates appear to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			(
				(Said
					'remove,turn,get,get,move,freeze,manipulate,press,roll,pull/motivator,artifact,machine'
				)
				(Print 8 75) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said '(turn<on),start/motivator,artifact,machine[<little,round]')
				(Print 8 76) ; "You aren't capable of doing that."
			)
			((Said 'remove,pull,press,get,get/plug[<modular,8,eightprong]')
				(Print 8 77) ; "You can't. It's permanently attached."
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

(instance thePod of Feature
	(properties
		x 54
		y 104
	)

	(method (handleEvent event param2)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look,look/craft,leech[<little]')
				(switch (= param2 (Random 1 2))
					(1
						(Print 8 78) ; "It's a cute little thing. You've never seen anything like it in these parts, but then where are these parts? Some writing on its exterior reads `For a good time, don't call HAL!'."
					)
					(2
						(Print 8 79) ; "It's a cute little thing. You've never seen anything like it in these parts, but then where are these parts? Some writing on its exterior reads `Bowman was here'."
					)
				)
			)
		)
	)
)

(instance theMallard of Feature
	(properties
		x 187
		y 106
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look,look/craft,aluminum[<big]')
				(PrintSplit 8 5) ; "It's a sleek-looking number if you can disregard the junk it's rooted in. It must be a recent addition to the collection as everything seems to be intact. Etched on each side is the name `ALUMINUM MALLARD'. On top is a small hatch."
			)
		)
	)
)

