;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use eRS)
(use Osc)
(use MCyc)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm153 0
)

(local
	local0
	local1
	local2
	local3 = 10
	local4 = 15
	[local5 16] = [161 189 186 154 120 91 87 118 119 107 80 67 61 79 107 126]
	[local21 37] = [2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 -32768]
)

(procedure (localproc_0 param1 param2)
	(if local0
		(proc0_12 local0)
	)
	(= local0
		(proc0_12
			param2
			67
			10
			(if (== param1 0) 10 else 160)
			28
			(if (== param1 0) global130 else global137)
			29
			global129
			70
			300
		)
	)
)

(instance rm153 of SQRoom
	(properties
		picture 150
	)

	(method (init)
		(LoadMany rsVIEW 522 520 521)
		(LoadMany rsSOUND 49 118 119 120 121)
		(gEgo setCycle: 0)
		(super init:)
		(lOrb init:)
		(rOrb init:)
		(self setScript: captiveScript)
	)

	(method (doit)
		(super doit:)
		(if (and (not local2) (== (gLongSong prevSignal:) 10))
			(= local2 1)
		)
	)
)

(instance captiveScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent)
		(if register
			(= seconds 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong number: 49 playBed:)
				(vohaul init:)
				(police init: setCycle: Walk setMotion: MoveTo 200 158 self)
			)
			(1
				(= register 1)
				(User canControl: 1)
				(theMouth init: setCycle: ForwardCounter 7)
				(theEyes init: setCycle: ForwardCounter 4)
				(localproc_0
					0
					{Well... what have we here?#j\ec\b0\f1\a5\a5\a5\a5\a5\a5\a4\e0\de\fa\86\e2\fa\e3\97\e0\fd\e0\de\fe}
				)
				(= seconds 4)
			)
			(2
				(theMouth hide:)
				(theEyes hide:)
				(= cycles 1)
			)
			(3
				(localproc_0
					1
					{This is the rebel scum we captured in the SQ4 time sector.#j\bd\cd\df\b0\bd\a5\b8\b4\bd\c4\80\e9\c0\b2\d1\be\b8\c0\b0\e3\de\n\e2\96\ef\94\e0 \ea\fd\97\de\8c\98\9c\8c\e3\de\9d\a1}
				)
				(= seconds 5)
			)
			(4
				(localproc_0
					1
					{He had just aided Wilco in escaping.#j\9a\92\e2\ea\a4\9b\8f\97 \b3\a8\d9\ba\96\de\e6\99\de\f9\e9\86\e3\e2\e0\de\8f\e0\fd\e3\de\9d\a1}
				)
				(= seconds 5)
			)
			(5
				(localproc_0
					1
					{The read-out on his time gun indicates that Wilco was successfully transported...#j\9a\92\e2\e9\c0\b2\d1\a5\b6\de\dd\e9\eb\8e\93\9c\de\e6\f6\f9\e4\a4\n\b3\a8\d9\ba\ea\c4\d7\dd\bd\ce\df\b0\c4\e6\9e\92\9a\93\9c\ef\9c\e0\a5\a5\a5\a5\a1}
				)
				(= seconds 6)
			)
			(6
				(localproc_0
					1
					{...into this time sector as you feared.#j\a5\a5\a5\a5\a5\a5\9c\fd\ea\df\92\9c\e0\e4\93\f8\a4\b3\a8\d9\ba\ea\a4\n\9a\e9\c0\b2\d1\be\b8\c0\b0\e6\f4\8f\e3\97\e0\f6\93\e3\de\9d\a1}
				)
				(= seconds 5)
			)
			(7
				(theMouth setCel: 0 show: setCycle: ForwardCounter 5)
				(theEyes show: setCycle: ForwardCounter 3)
				(localproc_0
					0
					{That is no longer a concern.#j\9f\fd\e5\9a\e4\ea\a4\92\ef\ea\a0\f3\fd\e0\de\92\9c\de\8c\e5\92\a1\n\9f\92\e2\ea\a4\a0 \b3\a8\d9\ba\e9\a0\f1\9d\9a\e0\de\ff}
				)
				(= seconds 4)
			)
			(8
				(theMouth setCycle: ForwardCounter 9)
				(theEyes setCycle: ForwardCounter 6)
				(localproc_0
					0
					{Wilco will surrender to us once he has learned we have captured his SON!#j\b5\da\e0\e1\96\de\a4\f1\9d\9a\86\e2\96\ef\94\e0\e4\92\93\9a\e4\86\9c\fa\ea\de\a4 \b3\a8\d9\ba\ea\9a\93\9b\fd\9d\f9\ea\9d\de\e0\de\a1}
				)
				(= seconds 6)
			)
			(9
				(theMouth setCycle: ForwardCounter 9)
				(theEyes setCycle: ForwardCounter 6)
				(localproc_0
					0
					{Then he will be destroyed once and for all. Ha ha ha....#j\9f\93\9d\fa\ea\de\a4\f4\e2\ea\95\9c\ef\92\e0\de\a1\ca\af\ca\af\ca\a5\a5\a5\a5\a5\a5}
				)
				(= seconds 4)
			)
			(10
				(= register 0)
				(User canControl: 0)
				(theEyes dispose:)
				(theMouth setCycle: MCyc @local21 self)
			)
			(11
				(theMouth dispose:)
				(= cycles 1)
			)
			(12
				(proc0_12 local0)
				(gCurRoom drawPic: 803 6)
				(gCurRoom newRoom: 365)
			)
		)
	)
)

(instance police of Actor
	(properties
		x 349
		y 218
		view 521
		loop 1
		priority 6
		signal 16
	)
)

(instance vohaul of Prop
	(properties
		x 121
		y 84
		view 520
		priority 10
		signal 16
	)
)

(instance theEyes of Prop
	(properties
		x 132
		y 69
		view 520
		loop 1
		cel 1
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance theMouth of Prop
	(properties
		x 122
		y 99
		view 520
		loop 2
		priority 11
		signal 16
	)
)

(instance lOrbZap of Sound
	(properties)
)

(instance rOrbZap of Sound
	(properties)
)

(instance lOrb of Prop
	(properties
		x 47
		y 123
		description {left orb}
		lookStr {The strange orbs crackle and sizzle with raw energy.}
		view 151
		priority 8
	)

	(method (doit)
		(super doit:)
		(if (and local3 (not (-- local3)))
			(if (< (Random 1 10) 5)
				(= loop 0)
			else
				(= loop 2)
			)
			(if (< (Random 1 10) 5)
				(if local2
					(lOrbZap number: (if loop 120 else 118) play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if local2
					(lOrbZap number: (if loop 120 else 118) play:)
				)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local3 (Random 20 50))
		(lOrbZap stop:)
		(self stopUpd:)
		(super cue:)
	)
)

(instance rOrb of Prop
	(properties
		x 230
		y 87
		description {right orb}
		lookStr {The strange orbs crackle and sizzle with raw energy.}
		view 151
		loop 1
		priority 8
	)

	(method (doit)
		(super doit:)
		(if (and local4 (not (-- local4)))
			(if (< (Random 1 10) 5)
				(= loop 1)
			else
				(= loop 3)
			)
			(if (< (Random 1 10) 5)
				(if local2
					(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if local2
					(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local4 (Random 20 50))
		(rOrbZap stop:)
		(self stopUpd:)
		(super cue:)
	)
)

