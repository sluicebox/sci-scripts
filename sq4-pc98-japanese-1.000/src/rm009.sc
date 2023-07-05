;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use MCyc)
(use Sound)
(use Actor)
(use System)

(public
	rm009 0
)

(local
	local0
	[local1 53] = [0 0 126 37 0 1 129 37 0 2 131 41 0 3 136 47 0 4 144 60 0 5 154 71 0 6 159 80 0 6 162 88 0 6 166 96 0 6 169 104 0 6 173 113 0 6 177 124 0 0 -100 -100 -32768]
)

(instance rm009 of SQRoom
	(properties
		picture 9
	)

	(method (init)
		(Load rsVIEW 1)
		(super init:)
		(self setScript: mallardScript setRegions: 707) ; intro
	)
)

(instance mallardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(= local0
					(proc0_12
						{We rejoin our friend and semi-hero Roger Wilco as he rockets back toward his home planet, Xenon, which he hasn't seen since Space Quest II. Having successfully rescued those two ingrates from Andromeda, he decides a pit stop on Magmetheus is in order.#j\9a\e9\f3\e9\96\de\e0\f8\e9\cb\b0\db\b0\e3\de\91\f9\a0 \db\bc\de\ac\b0\a5\b3\a8\d9\ba\96\de\a4\a0 \n\93\e1\8d\93\9e\fd\a0 \b1\d9\d0\c6\ad\b0\d1\a5\cf\d7\b0\c4\de\9a\de\93\e3\de\a0 \n\96\fa\e9\93\ef\fa\9a\97\8e\93\e3\de\91\f9\be\de\c9\dd\9e\92\ed\a0\f1\96\8f\e3\92\f9\e4\9a\fb\e3\de\91\f9\a1\a0 \n\n\e0\eb\de\e9\e4\e1\8d\93\a4\96\fa\ea\a0\cf\b8\de\d2\c3\a8\b3\bd\9e\92\e9\a0\93\e1\8d\93\ca\de\b0\e3\de\a0 \n\9c\ea\de\f7\98\a0 \97\8d\93\99\92\86\9d\f9\9a\e4\e6\9c\e0\a1}
						67
						2
						(LangSwitch 5 15)
						70
						315
						28
						global136
						29
						global129
						30
						1
						33
						310
					)
				)
				(= seconds 15)
			)
			(2
				(soundFX init: loop: 1 number: 110 play:)
				(= seconds 1)
				(proc0_12 local0)
				(mallard init: setCycle: MCyc @local1 self)
				(= seconds 2)
			)
			(3
				(mallard dispose:)
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance mallard of Prop
	(properties
		view 1
	)
)

(instance soundFX of Sound
	(properties)
)

