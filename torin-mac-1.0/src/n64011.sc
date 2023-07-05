;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64011)
(include sci.sh)
(use Main)
(use Print)

(public
	RoomTeleport 0
)

(procedure (RoomTeleport nextChapter &tmp nNextRoom)
	(switch nextChapter
		(1
			(= nNextRoom (TheLandsAbove))
		)
		(2
			(= nNextRoom (Escarpa))
		)
		(3
			(= nNextRoom (Pergola))
		)
		(4
			(= nNextRoom (Asthenia))
		)
		(5
			(= nNextRoom (Tenebrous))
		)
		(else
			(= nNextRoom 8000)
		)
	)
	(DisposeScript 64011 nNextRoom)
)

(procedure (TheLandsAbove &tmp nNextRoom)
	(= nNextRoom
		(Print
			y: 50
			fore: 235
			back: 227
			skip: 0
			font: gUserFont
			addTitle: {The Lands Above}
			addButton: 10000 {Intro} 0 31
			addButton: 11100 {Fahrmans House Int} 0 62
			addButton: 11000 {Fahrmans House Ext} 0 93
			addButton: 10100 {Forest scroller} 0 124
			addButton: 16000 {Crystal City, LS} 0 156
			addButton: 16100 {Crystal City Moat} 0 187
			addButton: 11200 {Sewing basket} 140 31
			addButton: 11300 {Dad's Ashtray} 140 62
			addButton: 12000 {Leaves} 140 93
			addButton: 14000 {Snails} 140 124
			addButton: 13000 {Bog} 200 93
			addButton: 15000 {Guard's House Ext} 240 93
			addButton: 15100 {Guard's House Int} 240 62
			addButton: 15200 {Phenocryst Portal} 240 31
			init:
		)
	)
)

(procedure (Escarpa &tmp nNextRoom)
	(= nNextRoom
		(Print
			y: 50
			fore: 235
			back: 227
			skip: 0
			font: gUserFont
			addTitle: {Escarpa}
			addButton: 20000 {Intro} 0 31
			addButton: 20100 {CliffScroller} 160 31
			addButton: 20200 {Bitternuts} 80 31
			addButton: 20300 {Throne Room} 240 31
			addButton: 20400 {Dragon Cave} 80 62
			addButton: 20500 {Skunk Cave} 240 62
			addButton: 20900 {Vedar} 240 93
			addButton: 20600 {Seraglio} 240 121
			addButton: 20700 {Phace Puzzle} 80 93
			addButton: 20800 {Transporter} 0 93
			init:
		)
	)
)

(procedure (Pergola &tmp nNextRoom)
	(= nNextRoom
		(Print
			y: 50
			fore: 235
			back: 227
			skip: 0
			font: gUserFont
			addTitle: {Pergola}
			addButton: 30000 {Intro} 0 31
			addButton: 30100 {OpeningScreen} 80 31
			addButton: 30200 {City} 80 62
			addButton: 30300 {Leenah Movie} 160 62
			addButton: 30400 {Star Puzzle} 240 62
			addButton: 30500 {Music Puzzle} 240 31
			init:
		)
	)
)

(procedure (Asthenia &tmp nNextRoom)
	(= nNextRoom
		(Print
			y: 50
			fore: 235
			back: 227
			skip: 0
			font: gUserFont
			addTitle: {Asthenia}
			addButton: 40000 {Intro} 0 31
			addButton: 40900 {Exit} 80 31
			addButton: 43000 {Puzzle} 160 31
			addButton: 40800 {Stones} 0 62
			addButton: 40700 {Mountain} 80 62
			addButton: 40600 {Cannon} 160 62
			addButton: 40500 {Lava} 240 62
			addButton: 40100 {Entrance} 0 93
			addButton: 40400 {SandCU} 80 93
			addButton: 40300 {Spits} 160 93
			addButton: 40200 {Island} 0 124
			addButton: 42200 {Ball Machine} 80 124
			addButton: 42100 {Catapult} 160 124
			addButton: 42000 {Caretakers} 240 124
			init:
		)
	)
)

(procedure (Tenebrous &tmp nNextRoom)
	(= nNextRoom
		(Print
			y: 50
			fore: 235
			back: 227
			skip: 0
			font: gUserFont
			addTitle: {Tenebrous}
			addButton: 50000 {Intro} 0 31
			addButton: 50100 {Storeroom} 240 31
			addButton: 50200 {AirDuct1} 160 31
			addButton: 50300 {AirDuctEnd} 80 31
			addButton: 50400 {InPlanter} 80 62
			addButton: 50500 {JailedMovie} 160 62
			addButton: 50600 {Slope} 80 93
			addButton: 50700 {TenebrousLS} 80 124
			addButton: 50800 {TenebrousMS} 160 124
			addButton: 50900 {Backstage} 240 124
			addButton: 53000 {MagicianCU} 80 155
			addButton: 53100 {RabbitCU} 160 155
			addButton: 53200 {ArchivistCU} 240 155
			addButton: 51000 {OnStage} 240 186
			addButton: 55000 {JudgeMovie} 160 186
			addButton: 51100 {NullVoid} 80 186
			addButton: 51200 {Porch} 80 217
			addButton: 51300 {HorrorHall} 160 217
			addButton: 51400 {Lair} 240 217
			init:
		)
	)
)

