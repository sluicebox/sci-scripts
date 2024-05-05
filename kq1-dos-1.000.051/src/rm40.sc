;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm40 0
)

(local
	local0
)

(procedure (localproc_0)
	(Print 40 47) ; "It is of no use to keep guessing the gnome's name."
)

(procedure (localproc_1)
	(if (and (IsFlag 37) (== (gnome view:) 111) (== (gnome loop:) 1))
		((ScriptID 0 21) number: 92 loop: 1 init: play:) ; gameSound
		(++ global135)
		(if (or (IsFlag 92) (IsFlag 108) (> global135 3))
			(localproc_0)
		else
			(Printf 40 48 &rest) ; "%s"
			(switch global135
				(2
					(Print 40 49) ; "GNOME: "You have only one guess left.""
				)
				(1
					(Print 40 50) ; "GNOME: "You still have two guesses.""
				)
			)
			(if (>= global135 3)
				(gnome setScript: failGuess)
			)
		)
		(return 1)
	else
		(if (gCast contains: gnome)
			(if (IsFlag 1)
				(Print 40 29) ; "The gnome momentarily pauses in response to the mysterious voice, then resumes his whittling"
			else
				(Print 40 30) ; "The gnome is busy whittling, and doesn't hear your guess. Move closer and give it another try."
			)
		)
		(return 0)
	)
)

(instance rm40 of Rm
	(properties
		picture 40
		horizon 86
		north 41
		east 39
		south 25
		west 33
	)

	(method (init)
		(LoadMany rsVIEW 111 110 240)
		(LoadMany rsSOUND 92 74)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(gAddToPics
			add: goldPile strawPile spinningWheel
			eachElementDo: #init
			doit:
		)
		(= local0 0)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 319 (gEgo x:) 178) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 52) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 155 (gEgo y:) 121))
			)
			(east
				(gEgo x: 317)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(hole init:)
		(bush init:)
		(if (and (not (IsFlag 92)) (not (IsFlag 108)))
			(gnome setScript: gnomeWhittle)
		)
	)

	(method (notify param1)
		(if (gCast contains: gnome)
			(localproc_1 40 0)
		else
			(Printf 40 1 param1) ; "Sir Graham, please try to find another word for "%s.""
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and script (!= script gnomeWhittle))
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			((and (& (gEgo onControl:) $0200) (not local0))
				(= local0 1)
				(Print 40 2) ; "You weren't invited into the gnome's house."
			)
			((and (not (& (gEgo onControl:) $0200)) (== local0 1))
				(= local0 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((proc0_14 event 36 158 70 176)
				(Print 40 3) ; "There's a rock over by the bush, but this rock is nothing compared to the one the gnome lives in!"
			)
			((proc0_14 event 28 0 165 131)
				(Print 40 4) ; "The gnome's house is carved right into the rock between three trees."
			)
			((Said 'look,look/boulder')
				(if (< (GetDistance (gEgo x:) (gEgo y:) 53 167) 30)
					(Print 40 3) ; "There's a rock over by the bush, but this rock is nothing compared to the one the gnome lives in!"
				else
					(Print 40 4) ; "The gnome's house is carved right into the rock between three trees."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing,building,ceder]')
						(Print 40 4) ; "The gnome's house is carved right into the rock between three trees."
					)
					((Said '/leaf')
						(Print 40 5) ; "The broad leaves provide shade for the gnome during the hot summer months."
					)
					((Said '/hay,(heap<hay)')
						(strawPile doVerb: 1)
					)
					((Said '/gold,dust,(heap<gold,dust)')
						(goldPile doVerb: 1)
					)
					((Said '/wheel,(wheel<spinning)')
						(spinningWheel doVerb: 1)
					)
					((Said '/root')
						(Print 40 6) ; "The roots of the three trees grow freely around the gnome's house."
					)
					((Said '/hole')
						(Print 40 7) ; "This hole, carved into the side of the rock, is the entrance to the gnome's home. It's too dark inside to make out any details, and the gnome probably prefers it that way."
					)
					((Said '/man,gnome')
						(cond
							((not (gCast contains: gnome))
								(Print 40 8) ; "The wizened gnome went inside his house."
							)
							((== (gnome view:) 111)
								(if (== (gnome loop:) 2)
									(Print 40 9) ; "You see a wizened old gnome sitting in front of his house, whittling."
								else
									(Print 40 10) ; "You are speaking with a wizened old gnome."
								)
							)
							(else
								(Print 40 11) ; "You see a wizened old gnome walking to his house."
							)
						)
					)
				)
			)
			((or (Said 'kill,hit') (Said 'throw,use/dagger,boulder,shot'))
				(if (gCast contains: gnome)
					(Print 40 12) ; "Why? The gnome has done nothing to you."
				else
					(Print 40 13) ; "The gnome isn't here."
				)
			)
			((Said 'get,get>')
				(cond
					((Said '/hay,(heap<hay)')
						(Print 40 14) ; "You won't need any straw on your quest."
					)
					((Said '/gold,dust,(heap<gold,dust)')
						(Print 40 15) ; "The gnome spun that gold out of straw! You can't take it, but don't worry. If you needed it, the gnome would give it to you."
					)
					((Said '/wheel,(wheel<spinning)')
						(Print 40 16) ; "The spinning wheel helps the gnome make his living. Please don't take it."
					)
				)
			)
			(
				(or
					(Said 'spin[/hay][/gold<in]')
					(Said 'spin/gold,wheel')
					(Said 'make/gold')
				)
				(Print 40 17) ; "Only gnomes know how to do that."
			)
			((Said 'enter/building[<gnome]')
				(Print 40 2) ; "You weren't invited into the gnome's house."
			)
		)
	)
)

(instance gnome of Actor
	(properties
		x 200
		y 122
		noun '/gnome,man'
		view 111
		priority 9
		signal 16
		illegalBits 0
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (gEgo distanceTo: gnome))
		(cond
			(
				(and
					(not (IsFlag 108))
					(not (IsFlag 92))
					(not (IsFlag 1))
					(not
						(and (gnome script:) (!= (gnome script:) gnomeWhittle))
					)
					(< temp0 40)
					(> (gEgo y:) 128)
					(== (gnome loop:) 2)
				)
				(gnomeTalk start: 0)
				(gnome setScript: gnomeTalk)
			)
			(
				(and
					(not (IsFlag 108))
					(not (IsFlag 92))
					(not
						(and (gnome script:) (!= (gnome script:) gnomeWhittle))
					)
					(or (> temp0 70) (IsFlag 1))
					(< (gnome loop:) 2)
				)
				(gnomeTalk start: 4)
				(gnome setScript: gnomeTalk)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'kill,hit') (Said 'throw,use/dagger,boulder,shot'))
				(if (gCast contains: gnome)
					(Print 40 12) ; "Why? The gnome has done nothing to you."
				else
					(Print 40 13) ; "The gnome isn't here."
				)
			)
			((or (Said 'look,look[/gnome,man,room]') (MousedOn self event 3))
				(event claimed: 1)
				(if (== (gnome view:) 111)
					(if (== (gnome loop:) 2)
						(Print 40 9) ; "You see a wizened old gnome sitting in front of his house, whittling."
					else
						(Print 40 10) ; "You are speaking with a wizened old gnome."
					)
				else
					(Print 40 11) ; "You see a wizened old gnome walking to his house."
				)
			)
			((Said 'capture,get,get,get/gnome,man')
				(Print 40 18) ; "Now what in the world would you do with a gnome?"
			)
			((Said '/rumpelstilskin')
				(if (IsFlag 37)
					(if (not (localproc_1 40 19))
						(event claimed: 0)
					)
				else
					(Print 40 20) ; "The gnome is busy whittling, and doesn't notice you."
				)
			)
			((Said '/mikel')
				(if (IsFlag 37)
					(if (or (IsFlag 92) (IsFlag 108))
						(if (!= global135 1)
							(++ global135)
							(Print 40 21) ; "What do you think I am, a car? This also won't get you a raise. Nice try."
						else
							(Print 40 22) ; "GNOME: "Please, keep guessing, won't you?""
						)
					else
						(localproc_0)
					)
				else
					(Print 40 20) ; "The gnome is busy whittling, and doesn't notice you."
				)
			)
			((Said '/nikslitselpmur')
				(if (IsFlag 37)
					(self setScript: goodGuess)
				else
					(Print 40 20) ; "The gnome is busy whittling, and doesn't notice you."
				)
			)
			((or (Said 'kiss/gnome,man') (Said 'hug/gnome,man'))
				(Print 40 23) ; "GNOME: "Really, Sir Graham!""
			)
			((or (Said 'talk,talk') (Said 'say/hello') (Said 'hello'))
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(Print 40 24) ; "The gnome momentarily pauses in response to the mysterious voice, then resumes his whittling."
					)
					(
						(and
							(< (gEgo distanceTo: gnome) 60)
							(> (gEgo y:) 128)
						)
						(if (and (IsFlag 6) (IsFlag 37))
							(Print 40 25) ; "GNOME: "You still haven't guessed my name!""
						else
							(gnomeTalk start: 0)
							(gnome setScript: gnomeTalk)
						)
					)
					(else
						(Print 40 26) ; "The gnome can't hear you from there!"
					)
				)
			)
			((and (!= (event type:) evMOUSEBUTTON) (IsFlag 37))
				(gGame handleEvent: event)
				(if (not (event claimed:))
					(cond
						((and (== (gnome view:) 111) (== (gnome loop:) 1))
							(++ global135)
							((ScriptID 0 21) number: 92 loop: 1 init: play:) ; gameSound
							(switch global135
								(1
									(Print 40 27) ; "GNOME: "Where did you get that idea? That's not even close!""
								)
								(2
									(Print 40 28) ; "GNOME: "You have only one guess left, Sir Graham!""
								)
								(3
									(self setScript: failGuess)
								)
								(else
									(localproc_0)
								)
							)
							(event claimed: 1)
						)
						((gCast contains: gnome)
							(if (IsFlag 1)
								(Print 40 29) ; "The gnome momentarily pauses in response to the mysterious voice, then resumes his whittling"
							else
								(Print 40 30) ; "The gnome is busy whittling, and doesn't hear your guess. Move closer and give it another try."
							)
							(event claimed: 1)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance gnomeWhittle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gnome init: setLoop: 2 cycleSpeed: 1)
				(self cue:)
			)
			(1
				(gnome setCycle: End self)
			)
			(2
				(= cycles (Random 1 5))
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance goodGuess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(gCurRoom script:)
						(== (gEgo view:) (if (IsFlag 0) 23 else 16))
					)
					((gCurRoom script:) cue:)
					(= cycles 7)
				else
					(self cue:)
				)
			)
			(1
				((ScriptID 0 21) number: 74 loop: 1 init: play:) ; gameSound
				(Print 40 31) ; "GNOME: "That's right! Outstanding! I didn't think you were THAT clever.""
				(Print 40 32) ; "GNOME: "As a reward for your sharp intellect, here are some beans. They're no ordinary beans, but it's up to you to find out why.""
				(Print 40 33) ; "GNOME: "Somebody as smart as yourself should have no problem at all. <giggle>""
				(if (< (gEgo distanceTo: gnome) 15)
					(self changeState: 2)
				else
					(Print 40 34) ; "GNOME: "Well, step over here so I can give them to you.""
					(self cue:)
				)
			)
			(2
				(self setScript: approachGnome self)
			)
			(3
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(SetScore 107 (- 5 global135))
				(SetScore 108 4)
				(gEgo get: 20) ; Beans
				(if (== (gEgo onControl: 1) 2)
					(self setScript: gnomeWaitLeave self)
				else
					(self setScript: gnomeLeaves self)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance failGuess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(gCurRoom script:)
						(== (gEgo view:) (if (IsFlag 0) 23 else 16))
					)
					((gCurRoom script:) cue:)
					(= cycles 7)
				else
					(self cue:)
				)
			)
			(1
				(Print 40 35) ; "GNOME: "You didn't guess my name, but I am still going to help you, Sir Graham.""
				(Print 40 36) ; "GNOME: "Take this golden key. It will aid you on your quest, Sir Graham, but it's up to you to find out how!""
				(if (< (gEgo distanceTo: gnome) 15)
					(self changeState: 2)
				else
					(Print 40 37) ; "GNOME: "Well, step over here so I can give it to you.""
					(self cue:)
				)
			)
			(2
				(self setScript: approachGnome self)
			)
			(3
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(SetScore 92 3)
				(gEgo get: 3) ; Key
				(if (== (gEgo onControl: 1) 2)
					(gnome setScript: gnomeWaitLeave)
				else
					(gnome setScript: gnomeLeaves)
				)
				(self dispose:)
			)
		)
	)
)

(instance approachGnome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: Avoid
					setMotion: MoveTo (gnome x:) (+ (gnome y:) 10) self
				)
			)
			(1
				(gEgo setAvoider: 0 setHeading: 0)
				(= cycles 5)
			)
			(2
				(Print 40 38) ; "GNOME: "Here you are. Good luck on your quest.""
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance gnomeWaitLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 40 39) ; "GNOME: "Er, pardon me, Sir Graham, but you're blocking my home. I have other adventurers to help and other puzzles to pose!""
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 155 136 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 175 155 self)
			)
			(2
				(Print 40 40) ; "GNOME: "Thank you, Sir Graham.""
				(proc0_1)
				(gnome
					view: 110
					cycleSpeed: 0
					ignoreControl:
					ignoreActors:
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 158 140 self
				)
			)
			(3
				(gnome setPri: -1 setMotion: MoveTo 100 110 self)
			)
			(4
				(gnome dispose:)
				(HandsOn)
			)
		)
	)
)

(instance gnomeLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gnome
					view: 110
					cycleSpeed: 0
					ignoreControl:
					ignoreActors:
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 128 122 self
				)
			)
			(1
				(gnome setPri: -1 setMotion: MoveTo 90 108 self)
			)
			(2
				(gnome dispose:)
				(HandsOn)
			)
		)
	)
)

(instance gnomeTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 37)
				(gnome loop: 1 cel: 0)
				(= cycles 2)
			)
			(1
				(gnome loop: 0 setCycle: End self)
			)
			(2
				(if (IsFlag 27)
					(Print 40 41) ; "GNOME: "So, you've come back! Good for you, Sir Graham!""
					(Print 40 25) ; "GNOME: "You still haven't guessed my name!""
				else
					(Print 40 42) ; "GNOME: "Welcome, Sir Graham. I have been expecting you.""
					(SetFlag 27)
				)
				(gnome cel: 0 setCycle: End self)
			)
			(3
				(if (not (IsFlag 6))
					(Print 40 43) ; "GNOME: "I have something that will be of great use to you. But first, Sir Graham, you must answer this riddle. I'll give you three guesses. What is my name?""
					(SetFlag 6)
				)
				(gnome setLoop: 1)
				(HandsOn)
				(self dispose:)
			)
			(4
				(gnome loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(Print 40 44) ; "GNOME: "It's been delightful chatting with you, Sir Graham.  I get so few visitors... Perhaps it's the fault of that thickheaded troll.""
				(gnome loop: 2 setCycle: Fwd)
				(self dispose:)
			)
			(6
				(Print 40 45) ; "mad"
			)
			(7
				(Print 40 46) ; "really mad"
			)
		)
	)
)

(instance spinningWheel of PicView
	(properties
		x 242
		y 133
		noun '/wheel'
		nsTop 103
		nsLeft 226
		nsBottom 130
		nsRight 256
		description {spinning wheel}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 500
		shiftClick 1
		view 240
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(Print 40 51) ; "This is the gnome's spinning wheel."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance goldPile of PicView
	(properties
		x 224
		y 143
		noun '/gold,dust'
		nsTop 129
		nsLeft 212
		nsBottom 142
		nsRight 238
		description {pile of gold}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 500
		shiftClick 1
		view 240
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 40 52) ; "This is a pile of gold."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance strawPile of PicView
	(properties
		x 265
		y 140
		noun '/heap<hay,hay'
		nsTop 130
		nsLeft 254
		nsBottom 140
		nsRight 277
		description {pile of straw}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 500
		shiftClick 1
		view 240
		cel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(Print 40 53) ; "There is a small pile of straw here."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hole of NewFeature
	(properties
		x 122
		y 98
		noun '/hole,door,doorway'
		nsTop 78
		nsLeft 111
		nsBottom 118
		nsRight 133
		description {hole in tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This hole, carved into the side of the rock, is the entrance to the gnome's home.__It's too dark inside to make out any details, and the gnome probably prefers it that way.}
	)
)

(instance bush of NewFeature
	(properties
		x 28
		y 165
		noun '/bush'
		nsTop 153
		nsLeft 7
		nsBottom 178
		nsRight 49
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Several nice bushes and plants surround the gnome's home.}
	)
)

