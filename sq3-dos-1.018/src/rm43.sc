;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
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
	rm43 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(class BView of View
	(properties)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance footPrint of BView
	(properties)
)

(instance rm43 of Rm
	(properties
		picture 43
		style 7
		east 44
		south 47
		west 42
	)

	(method (init)
		(User canInput: 1 canControl: 0)
		(NormalEgo)
		(if (not global152)
			(Load rsVIEW 66)
			(Load rsVIEW 67)
		)
		(Load rsVIEW 70)
		(Load rsVIEW 121)
		(Load rsSOUND 13)
		(super init:)
		(w init:)
		(orld init: addToPic:)
		(o init: addToPic:)
		(wonder init: addToPic:)
		(if (or (== global110 1) (== global110 2))
			(gEgo observeControl: 16384)
			(door view: 121 loop: 0 cel: 0 posn: 157 118 init: stopUpd:)
		)
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 10))
				)
			)
			(2
				(= global111 (Act new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(if (gCast contains: global111)
			(global111
				view: 106
				setCycle: Walk
				observeControl: 2
				posn: 1000 1000
				hide:
				init:
			)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 140)
				)
				(west
					(global111 posn: -40 140)
				)
				(south
					(global111 posn: 160 249)
				)
			)
			(= global110 1)
			(self setScript: tActions)
		)
		(if (not global152)
			(car init:)
			(shadow init:)
			(HandsOff)
			(self setScript: kid1Script)
		else
			(if (!= (gLongSong number:) 22)
				(gLongSong number: 22 priority: 1 loop: -1 play:)
			)
			(gEgo view: 0 setStep: 3 2 illegalBits: $8000 init:)
			(switch gPrevRoomNum
				(42
					(gEgo posn: 2 (gEgo y:))
				)
				(44
					(if (< (gEgo y:) 110)
						(gEgo posn: 317 110)
					else
						(gEgo posn: 317 (gEgo y:))
					)
				)
				(47
					(gEgo posn: (gEgo x:) 187)
				)
				(470
					(gEgo
						view: (if global130 138 else 0)
						posn: 158 125
						loop: 2
						cel: 0
					)
					(if global130
						(Load rsVIEW 755)
					)
					(cond
						((== global110 0)
							(HandsOff)
							(= global110 1)
							(self setScript: terminatorGrabs)
							(Load rsPIC 430)
							(Load rsVIEW 107)
							(Load rsVIEW 121)
						)
						(global130
							(self setScript: hatTrick)
						)
					)
				)
				(else
					(gEgo posn: 160 187)
				)
			)
			(if (!= (gCurRoom script:) terminatorGrabs)
				(HandsOn)
			)
		)
		(= local0 1)
	)

	(method (doit &tmp [temp0 30])
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (or (== (gEgo onControl: 0) 4) (== (gEgo onControl: 0) 5))
			(self newRoom: 470)
		)
		(if (== (-- local0) 0)
			(if (== (w cel:) 0)
				(w cel: 1)
			else
				(w cel: 0)
			)
			(= local0 (Random 1 4))
		)
	)

	(method (newRoom newRoomNumber)
		(if (or (not script) (== script tActions))
			(gEgo illegalBits: $8000)
			(cond
				((!= newRoomNumber 470)
					(gLongSong owner: -1 number: 22 priority: 0 loop: -1 play:)
				)
				((== (gLongSong number:) 22)
					(gLongSong fade:)
				)
			)
			(if
				(and
					(gCast contains: global111)
					(< (gEgo distanceTo: global111) 120)
				)
				(= global110 2)
			)
			(DisposeScript 988)
			(if (not gHandsOff)
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look/leg')
						(Print 43 0) ; "The massive metal legs support an equally massive metal monster. Kinda takes your breath away, doesn't it?"
					)
					((Said 'look/feet,s')
						(Print 43 1) ; "Whoever built this thing did a thorough job. Right down to the polyfoam toejam."
					)
					((or (Said 'devil,s') (Said '/devil,s') (Said '//devil,s'))
						(Print 43 2) ; "It looks real, but not real important."
					)
					((Said 'look/door,entrance,door')
						(if (gCast contains: door)
							(Print 43 3) ; "It looks like Fester has closed up. The door is closed and locked."
						else
							(Print 43 4) ; "The doorway is wide open."
						)
					)
					((Said 'knock/door')
						(if (gCast contains: door)
							(if (< (gEgo distanceTo: door) 10)
								(Print 43 5) ; "There's no answer."
							else
								(NotClose) ; "It's not quite within reach."
							)
						else
							(Print 43 6) ; "There isn't one here."
						)
					)
					((Said 'open/door')
						(if (gCast contains: door)
							(if (< (gEgo distanceTo: door) 10)
								(Print 43 7) ; "It appears to be locked."
							else
								(NotClose) ; "It's not quite within reach."
							)
						else
							(Print 43 6) ; "There isn't one here."
						)
					)
					((or (Said 'get/cap') (Said 'get<up/cap'))
						(if (gEgo has: 6) ; Astro_Chicken_Flight_Hat
							(Print 43 8) ; "You already have it."
						else
							(Print 43 9) ; "You don't see one here."
						)
					)
					((Said 'look/box,table,glass,animal,animal,lawn,slime,show')
						(if (gEgo inRect: 189 110 246 130)
							(Print 43 10) ; "You peer through the glass of the display case and find a cute and cuddly little creature. A small sign on the glass informs you that this is an Antarean slime devil. How cuuuuuuuute!"
						else
							(Print 43 11) ; "It's hard to see anything from this far away."
						)
					)
					((Said 'break/box,glass')
						(if (gEgo inRect: 189 110 246 130)
							(Print 43 12) ; "Just open the case."
						else
							(NotClose) ; "It's not quite within reach."
						)
					)
					((Said 'open/box')
						(cond
							((== (gCurRoom script:) tActions)
								(Print 43 13) ; "You'd better get out of there."
							)
							((gEgo inRect: 189 110 246 130)
								(gCurRoom setScript: AlienDeath)
							)
							(else
								(Print 43 14) ; "Your arms just aren't quite long enough. Try getting a little closer."
							)
						)
					)
					((Said 'read,look/menace[<neon,flashing]')
						(if
							(and
								(gCast contains: door)
								(gEgo inRect: 102 90 246 143)
							)
							(Print 43 15) ; "The sign on the door says "Closed"."
						else
							(Print 43 16) ; "Like a cool oasis in the desert, the friendly sign beckons you to enter the World o' Wonders tourist haven."
							(if (gCast contains: door)
								(Print 43 17) ; "Unfortunately, a closed door is keeping you out.  There seems to be a small sign on the door."
							)
						)
					)
					(
						(or
							(Said 'look/area')
							(Said 'look/building,hill,animal')
							(Said 'look[<around][/!*]')
						)
						(Print 43 18) ; "Ah Ha! A tourist trap. This giant metal facsimile of a space beast is nothing more than a cheap marketing ploy designed to suck in any moron dumb enough to fall for such trickery... You suddenly feel like a dumb moron."
					)
				)
			)
			(evKEYBOARD
				(if
					(and
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_RETURN)
						(== (gCurRoom script:) terminatorGrabs)
						(<= 5 (terminatorGrabs state:) 8)
					)
					(cls)
					(event claimed: 1)
					(terminatorGrabs seconds: 0)
					(terminatorGrabs cue:)
				)
			)
		)
	)
)

(instance kid1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 13 priority: 3 loop: -1 play:)
				(kid1 init: setMotion: MoveTo 188 137 self)
			)
			(1
				(car setScript: kid2Script)
				(kid1 setMotion: MoveTo 246 160 self)
			)
			(2
				(kid1 dispose:)
			)
		)
	)
)

(instance kid2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kid2 init: setMotion: MoveTo 188 137 self)
			)
			(1
				(gCurRoom setScript: momScript)
				(kid2 setMotion: MoveTo 246 160 self)
			)
			(2
				(kid2 dispose:)
			)
		)
	)
)

(instance momScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mom init: setMotion: MoveTo 197 142 self)
			)
			(1
				(mom setMotion: MoveTo 284 149 self)
			)
			(2
				(car setScript: popScript)
				(mom setMotion: MoveTo 284 160 self)
			)
			(3
				(mom dispose:)
			)
		)
	)
)

(instance popScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pop init: setMotion: MoveTo 152 120 self)
			)
			(1
				(pop setMotion: MoveTo 196 146 self)
			)
			(2
				(pop loop: 4 cel: 0 setCycle: Walk)
				(= cycles 2)
			)
			(3
				(pballoon init:)
				(pop cycleSpeed: 1 setCycle: End self)
			)
			(4
				(pballoon dispose:)
				(pop
					loop: 3
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 284 160 self
				)
				(gCurRoom setScript: festerScript)
			)
			(5
				(pop dispose:)
			)
		)
	)
)

(instance festerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fester init: setMotion: MoveTo 185 137 self)
			)
			(1
				(fester loop: 1 setCycle: End self)
			)
			(2
				(fester loop: 4 setCycle: Fwd)
				(fballoon init:)
				(gEgo setScript: carScript)
				(= seconds 4)
			)
			(3
				(fballoon cel: 1)
				(= seconds 4)
			)
			(4
				(fballoon dispose:)
				(fester loop: 1 cel: 2 setCycle: Beg self)
			)
			(5
				(fester loop: 2 setCycle: Walk setMotion: MoveTo 141 108 self)
			)
			(6
				(fester dispose:)
				(gEgo init: view: 0 setStep: 3 2)
				(switch gPrevRoomNum
					(42
						(gEgo
							posn: -5 (gEgo y:)
							setMotion: MoveTo 5 (gEgo y:) self
						)
					)
					(44
						(if (< (gEgo y:) 110)
							(gEgo posn: 324 110)
						else
							(gEgo posn: 324 (gEgo y:))
						)
						(gEgo setMotion: MoveTo 314 (gEgo y:) self)
					)
					(47
						(gEgo
							posn: (gEgo x:) 222
							setMotion: MoveTo (gEgo x:) 186 self
						)
					)
					(else
						(gEgo posn: 160 222 setMotion: MoveTo 166 186 self)
					)
				)
			)
			(7
				(HandsOn)
				(client setScript: 0)
				(= global152 1)
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(car setMotion: MoveTo 278 160 self)
				(shadow setMotion: MoveTo 287 191)
			)
			(1
				(car xStep: 10 setMotion: MoveTo 368 160 self)
				(shadow xStep: 10 setMotion: MoveTo 368 191)
			)
			(2
				(car dispose:)
				(shadow dispose:)
				(dust init: setCycle: End self)
			)
			(3
				(dust dispose:)
				(self dispose:)
			)
		)
	)
)

(instance AlienDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 126)
					(gEgo setMotion: MoveTo (gEgo x:) 126 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setMotion: MoveTo 228 126 self)
			)
			(2
				(gEgo
					view: 84
					setLoop: 0
					setCel: 255
					posn: 228 126
					ignoreControl:
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setLoop: 1 setCel: 255 setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 2
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 218 133 self
				)
			)
			(6
				(gEgo setMotion: MoveTo 177 133 self)
			)
			(7
				(gEgo setMotion: MoveTo 173 151 self)
			)
			(8
				(gEgo setMotion: MoveTo 197 135 self)
			)
			(9
				(gEgo setMotion: MoveTo 175 150 self)
			)
			(10
				(gEgo setLoop: 3 setCel: 255 setCycle: End self)
			)
			(11
				(gEgo setLoop: 4 setCel: 255 setCycle: End self)
			)
			(12
				(Print 43 19) ; "They may be cute, but only an idiot would get near one! Looks like you won't be around to appreciate the other diverse wonders of this garden-spot of the universe."
				(= global197 1)
			)
		)
	)
)

(instance car of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 0
			setCel: 0
			setPri: 15
			posn: 278 175
			xStep: 1
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/car')
					(Print 43 20) ; "It's a nifty late-model hoverwagon, perfect for a family on the go!"
				)
			)
		)
	)
)

(instance shadow of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 0
			setCel: 1
			setPri: 14
			posn: 280 176
			xStep: 1
			ignoreActors:
		)
	)
)

(instance kid1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 2
			setCel: 0
			posn: 139 109
			xStep: 6
			yStep: 3
			setCycle: Fwd
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/boy')
					(Print 43 21) ; "Kids are always welcome at the World o' Wonders tourist haven, but if you break it, you buy it!"
				)
			)
		)
	)
)

(instance kid2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 2
			setCel: 0
			posn: 139 109
			xStep: 6
			yStep: 3
			setCycle: Fwd
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/boy')
					(Print 43 21) ; "Kids are always welcome at the World o' Wonders tourist haven, but if you break it, you buy it!"
				)
			)
		)
	)
)

(instance mom of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 5
			setCel: 0
			posn: 144 109
			setCycle: Fwd
			xStep: 5
			yStep: 3
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/mom')
					(Print 43 22) ; "I hope everyone went to the bathroom! This is the last stop for 80,000 miles!"
				)
			)
		)
	)
)

(instance pop of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 3
			setCel: 0
			posn: 142 111
			setCycle: Fwd
			xStep: 5
			yStep: 3
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/dad,man,alien')
					(Print 43 23) ; "Dad's pleased with his keen bargaining skills. "Boy, I sure got some good deals! This is some REAL high quality stuff!""
				)
			)
		)
	)
)

(instance fester of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 67
			setLoop: 0
			setCel: 0
			posn: 141 108
			xStep: 3
			yStep: 2
			setCycle: Fwd
			ignoreActors:
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said 'look/man,blatz')
					(Print 43 24) ; "Obviously the friendly proprietor of this establishment. He certainly has an honest face."
				)
			)
		)
	)
)

(instance fballoon of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 67
			setLoop: 3
			setCel: 0
			setPri: 15
			posn: 217 103
			ignoreActors:
		)
	)
)

(instance pballoon of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 6
			setCel: 0
			setPri: 15
			posn: 168 123
			stopUpd:
			ignoreActors:
		)
	)
)

(instance dust of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 66
			setLoop: 1
			setCel: 0
			setPri: 15
			posn: 287 166
			ignoreActors:
		)
	)
)

(instance w of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 1
			setCel: 0
			setPri: 15
			posn: 95 34
			ignoreActors:
		)
	)
)

(instance orld of View
	(properties)

	(method (init)
		(super init:)
		(self view: 70 setLoop: 0 setCel: 0 posn: 116 35 setPri: 14 stopUpd:)
	)
)

(instance o of View
	(properties)

	(method (init)
		(super init:)
		(self view: 70 setLoop: 0 setCel: 1 posn: 155 36 setPri: 14 stopUpd:)
	)
)

(instance wonder of View
	(properties)

	(method (init)
		(super init:)
		(self view: 70 setLoop: 0 setCel: 2 posn: 178 61 setPri: 14 stopUpd:)
	)
)

(instance door of View
	(properties)
)

(instance terminatorGrabs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 106)
				(gEgo setMotion: MoveTo 181 157 self)
			)
			(1
				(HandsOff)
				(= global111 (Act new:))
				(global111
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x:) (gEgo y:)
				)
				(if global130
					(= global130 0)
					(PutItem 6 -1) ; Astro_Chicken_Flight_Hat
					(= local5 (Act new:))
					(local5
						view: 755
						posn: (gEgo x:) (- (gEgo y:) 10)
						setAvoider: Avoid
						setStep: 5 5
						setCycle: Fwd
						setMotion: MoveTo -10 170
						init:
					)
				)
				(gEgo
					view: 106
					setLoop: 4
					cel: 255
					ignoreHorizon:
					illegalBits: 0
					setCycle: End
					setPri: (gEgo priority:)
					setStep: 4 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 11)
						(- (gEgo y:) 15)
						self
				)
				(RedrawCast)
			)
			(2
				(gEgo setLoop: 5 setCycle: Fwd)
				(global111
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority:)
					setCycle: Fwd
					init:
				)
				(= seconds 2)
			)
			(3
				(global111
					view: 106
					setLoop: 7
					setPri: (gEgo priority:)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(4
				(global111 setCel: 1)
				(RedrawCast)
				(gCurRoom drawPic: 430)
				(gCast eachElementDo: #hide)
				(= local1 (Prop new:))
				(local1
					view: 107
					setLoop: 0
					cel: 6
					posn: 61 189
					setPri: 14
					cycleSpeed: 0
					setScript: mouthActions
					init:
				)
				(= local2 (Prop new:))
				(local2
					view: 107
					setLoop: 2
					posn: 149 86
					setPri: 14
					setCycle: Fwd
					init:
				)
				(= local3 (Prop new:))
				(local3
					view: 107
					setLoop: 1
					cel: 0
					posn: 160 52
					setPri: 14
					setScript: eyeActions
					init:
				)
				(= seconds 3)
			)
			(5
				(local1 cycleSpeed: 1 setCycle: Fwd)
				(Print 43 25 #font 600 #at -1 10 #width 300 #dispose) ; "Sooo... this is Roger Wilco, the man I have been sent across the universe to track down and terminate. I am not impressed. You were too easy to find. You tend to leave a mess wherever you go."
				(= seconds 15)
			)
			(6
				(cls)
				(Print 43 26 #font 600 #at -1 10 #width 300 #dispose) ; "Seems you forgot to pay for that Labionian Terror Beast mating call whistle. Now let's see ... with interest that comes to 400,000 buckazoids. I don't think you've got that kind of cash on you Hmm? No... I didn't think so."
				(= seconds 15)
			)
			(7
				(cls)
				(Print 43 27 #font 600 #at -1 10 #width 300 #dispose) ; "The good people at the Gippazoid Novelty Co. are most displeased. Nonpayment is a serious offense."
				(= seconds 10)
			)
			(8
				(cls)
				(Print 43 28 #font 600 #at -1 10 #width 300 #dispose) ; "But lucky for you I'm in a good mood today. I will count to ten real slow then I track you down. If you make it to your ship I forget I see you. But if I catch you again..... I dust you like bundt cake."
				(= seconds 15)
			)
			(9
				(cls)
				(gCast eachElementDo: #show)
				(local1 dispose:)
				(local2 dispose:)
				(local3 dispose:)
				(door view: 121 loop: 0 cel: 0 posn: 157 118 init: stopUpd:)
				(orld init: addToPic:)
				(o init: addToPic:)
				(wonder init: addToPic:)
				(gCurRoom drawPic: 43)
				(= cycles 1)
			)
			(10
				(global111 setLoop: 7 setCycle: Fwd)
				(= seconds 2)
			)
			(11
				(= seconds 2)
			)
			(12
				(global111 setLoop: 6)
				(= seconds 3)
			)
			(13
				(global111 hide:)
				(gEgo
					cycleSpeed: 2
					setCycle: Beg
					setMotion:
						MoveTo
						(- (gEgo x:) 11)
						(+ (gEgo y:) 15)
						self
				)
			)
			(14
				(gEgo
					view: 0
					illegalBits: $8000
					observeControl: 16384
					cycleSpeed: 0
					setCycle: Walk
					setLoop: -1
					setStep: 3 2
					setPri: -1
					loop: 2
				)
				(HandsOn)
				(= global114 10)
				(gCurRoom setScript: tActions)
			)
		)
	)
)

(instance tActions of Script
	(properties)

	(method (doit)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if
			(and
				(or (== local4 1) (== local4 7))
				(or
					(== (global111 cel:) 0)
					(if (< (global111 loop:) 2)
						(== (global111 cel:) 4)
					else
						(== (global111 cel:) 3)
					)
				)
			)
			(footPrint
				view: 106
				loop: (global111 loop:)
				cel: (global111 cel:)
				posn: (global111 x:) (global111 y:)
				ignoreActors: 1
				addToPic:
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 106)
				(= seconds global114)
			)
			(1
				(global111
					view: 106
					setLoop: -1
					setCycle: Walk
					illegalBits: $8000
					observeControl: 16384
					show:
					setMotion: Chase gEgo 10 self
					setAvoider: Avoid
				)
				(= local4 1)
			)
			(2
				(HandsOff)
				(= local4 10)
				(global111 posn: (gEgo x:) (gEgo y:))
				(gEgo
					view: 106
					setLoop: 4
					cel: 255
					ignoreHorizon:
					illegalBits: 0
					setCycle: End
					setPri: (gEgo priority:)
					setStep: 4 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 11)
						(- (gEgo y:) 15)
						self
				)
			)
			(3
				(gEgo setLoop: 5 setCycle: Fwd)
				(global111
					view: 106
					setLoop: 6
					illegalBits: 0
					setPri: (gEgo priority:)
					setCycle: Fwd
					show:
				)
				(= seconds 4)
			)
			(4
				(global111
					view: 106
					setLoop: 7
					setPri: (gEgo priority:)
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(5
				(gEgo hide:)
				(= local6 (Sound new:))
				(local6 number: 97 loop: -1 priority: 3 play:)
				(global111 setLoop: 8 setCycle: Fwd)
				(= seconds 6)
			)
			(6
				(local6 stop:)
				(global111 setLoop: 8 setCel: 0)
				(EgoDead 901 0 14 16) ; "Thanks for playing Space Quest ]I[. As usual, you've been a real hoot."
			)
		)
	)
)

(instance eyeActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 cel: 1)
				(= cycles (Random 4 10))
			)
			(1
				(local3 cel: 0)
				(= state -1)
				(= cycles (Random 10 60))
			)
		)
	)
)

(instance mouthActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setCycle: Fwd)
				(= seconds (Random 4 12))
			)
			(1
				(local1 setCycle: 0 cel: 1)
				(= state -1)
				(= cycles (Random 7 15))
			)
		)
	)
)

(instance hatTrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 181 157 self)
			)
			(1
				(Print 43 29) ; "You realize how ridiculous you look and remove the hat."
				(gEgo view: 0)
				(= global130 0)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

